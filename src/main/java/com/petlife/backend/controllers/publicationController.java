package com.petlife.backend.controllers;

import com.petlife.backend.models.Role;
import com.petlife.backend.models.User;
import com.petlife.backend.models.eRole;
import com.petlife.backend.requestModels.request.PublishPetRequest;
import com.petlife.backend.requestModels.request.RegisterRequest;
import com.petlife.backend.requestModels.response.MessageResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

public class publicationController {

    @PostMapping("/publish-pet")
    public ResponseEntity<?> registerUser(PublishPetRequest signUpRequest) {


        return ResponseEntity.ok(new MessageResponse("Publicación guardada"));
    }
}
