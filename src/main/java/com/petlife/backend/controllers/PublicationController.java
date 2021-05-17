package com.petlife.backend.controllers;

import com.petlife.backend.models.*;
import com.petlife.backend.requestModels.request.PublishPetRequest;
import com.petlife.backend.requestModels.response.MessageResponse;
import com.petlife.backend.security.UserDetailsImpl;
import com.petlife.backend.services.JwtServices;
import com.petlife.backend.services.PetService;
import com.petlife.backend.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;



@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/publish")
public class PublicationController {

    private static final Logger logger = LoggerFactory.getLogger(PublicationController.class);

    @Autowired
    PetService petService;

    @Autowired
    UserService userService;

    @Autowired
    JwtServices jwtServices;

    @PostMapping("/new-publish")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> registerUser(@RequestBody PublishPetRequest publishRequest, @RequestHeader HttpHeaders header) {

        UserDetailsImpl user_auth= (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user=userService.findByEmail(user_auth.getUsername());



        // Create new user's account
        Pet pet = new Pet(publishRequest, user);
        logger.error(pet.toString());
        Long l= (long)4;

        petService.insert(pet);

        return ResponseEntity.ok(new MessageResponse("Mascota Publicada Satisfactoriamente"));
    }


}
