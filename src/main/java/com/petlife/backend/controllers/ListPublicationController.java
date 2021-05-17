package com.petlife.backend.controllers;

import com.petlife.backend.requestModels.request.PublishPetRequest;
import com.petlife.backend.requestModels.response.MessageResponse;
import com.petlife.backend.services.JwtServices;
import com.petlife.backend.services.PetService;
import com.petlife.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/publish")

public class ListPublicationController {

    @Autowired
    PetService petService;

    @Autowired
    UserService userService;

    @Autowired
    JwtServices jwtServices;

    @PostMapping("/list-publish")
    public ResponseEntity<?> registerUser(@RequestBody PublishPetRequest publishRequest) {

        petService.findAll();

        return ResponseEntity.ok(new MessageResponse("Mascota Publicada Satisfactoriamente"));
    }



}
