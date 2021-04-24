package com.petlife.backend.controllers;

import com.petlife.backend.models.*;
import com.petlife.backend.requestModels.request.PublishPetRequest;
import com.petlife.backend.requestModels.request.RegisterRequest;
import com.petlife.backend.requestModels.response.MessageResponse;
import com.petlife.backend.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/publish")

@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
public class PublicationController {
    @Autowired
    PetService petService;

    @PostMapping("/publish-pet")
    public ResponseEntity<?> registerUser(PublishPetRequest publishRequest) {

        // Create new user's account
        Pet pet = new Pet(publishRequest);
        petService.save(pet);

        return ResponseEntity.ok(new MessageResponse("Mascota Publicada Satisfactoriamente"));

    }

}
