package com.petlife.backend.controllers;

import com.petlife.backend.jwt.JwtUtil;
import com.petlife.backend.repositories.UserRepository;
import com.petlife.backend.requestModels.response.TokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/token")

public class TokenController {

    @Autowired
    JwtUtil jwtUtils;

    @Autowired
    UserRepository userRepo;

    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @PostMapping(value = "/expired/{tokenString}")
    public ResponseEntity<String> checkIfTokenIsExpired(@PathVariable String tokenString){

        if(jwtUtils.checkIfExpired(tokenString) <= 0){
            return ResponseEntity.ok().body("Token valid.");
        }else{
            return ResponseEntity.badRequest().body("Token expired.");
        }
    }

    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN') ")
    @PostMapping(value = "/requestNew")
    public ResponseEntity<?> requestNewToken(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();

        String jwt = jwtUtils.generateJwtToken(auth);

        return ResponseEntity.ok(new TokenResponse(
                jwt
        ));

    }




}
