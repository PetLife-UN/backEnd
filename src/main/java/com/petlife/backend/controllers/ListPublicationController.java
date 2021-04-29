package com.petlife.backend.controllers;

import com.petlife.backend.models.*;
import com.petlife.backend.requestModels.request.PublishPetRequest;
import com.petlife.backend.requestModels.request.RegisterRequest;
import com.petlife.backend.requestModels.response.MessageResponse;
import com.petlife.backend.security.AuthEntryPointJwt;
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
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

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
