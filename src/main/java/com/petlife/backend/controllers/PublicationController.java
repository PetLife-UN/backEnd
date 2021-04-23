package com.petlife.backend.controllers;

import com.petlife.backend.models.*;
import com.petlife.backend.requestModels.request.PublishPetRequest;
import com.petlife.backend.requestModels.request.RegisterRequest;
import com.petlife.backend.requestModels.response.MessageResponse;
import com.petlife.backend.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

public class PublicationController {
    @Autowired
    PetService petService;

    @PostMapping("/publish-pet")
    public ResponseEntity<?> registerUser(PublishPetRequest publishRequest) {
        /*
         *   //debemos validar el token justo aquí??
         *
         *   if(validToken(publishRequest.getToken())){
         *
         *   };
         *
         */


        // Create new user's account
        Pet pet = new Pet(publishRequest);
        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));

    }

}
