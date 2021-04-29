package com.petlife.backend.controllers;

import com.petlife.backend.services.JwtServices;
import com.petlife.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/token")

public class TokenController {

    @Autowired
    JwtServices jwtUtils;

    @Autowired
    UserRepository userRepo;

    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @PostMapping(value = "/expired/{tokenString}")
    public ResponseEntity<String> checkIfTokenIsExpired(@PathVariable String tokenString){

        if(!jwtUtils.checkIfExpired(tokenString)){
            return ResponseEntity.ok().body("Token valid.");
        }else{
            return ResponseEntity.badRequest().body("Token expired.");
        }
    }



}
