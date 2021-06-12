package com.petlife.backend.controllers;

import com.petlife.backend.models.Pet;
import com.petlife.backend.models.User;
import com.petlife.backend.repositories.PetRepository;
import com.petlife.backend.requestModels.response.MessageResponse;
import com.petlife.backend.security.UserDetailsImpl;
import com.petlife.backend.services.PetService;
import com.petlife.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/pet")

public class PetController {

    @Autowired
    PetRepository petRepository;

    @Autowired
    PetService petService;

    @Autowired
    UserService userService;

    @GetMapping("/consultaAll")
    public @ResponseBody ResponseEntity<?> consultaPetalt() {
        List<Pet> pets = petService.findAll();
        return new ResponseEntity<List<Pet>>(pets, HttpStatus.OK);
    }

    @GetMapping("/consulta")
    public @ResponseBody ResponseEntity<?> consultaPetBasicaPages(@RequestParam Optional<Boolean> adopted,@RequestParam Optional<Integer> page,@RequestParam Optional<Integer> size) {
        Page<Pet> pets = petService.getShortPetsInfoPage(adopted.orElse(Boolean.FALSE), page.orElse(0),size.orElse(6));
        return new ResponseEntity<Page<Pet>>(pets, HttpStatus.OK);
    }

    @GetMapping("/consultaPet")
    public @ResponseBody ResponseEntity<?> consultaPetId(@RequestParam Long idPet) {
        Pet pet = petService.getPetById(idPet);
        return new ResponseEntity <Pet>( pet, HttpStatus.OK);
    }

    @GetMapping("/getUserPets")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> returnPetsfromUser(){
        UserDetailsImpl user_auth= (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userService.findByEmail(user_auth.getUsername());

        List<Pet> petList = petService.getPetsByUser(user);
        if(!petList.isEmpty()){
            return  ResponseEntity.ok(petService.removeUserDetails(petList));
        }
        return new ResponseEntity<>(new MessageResponse("User doesn't have any pets"),HttpStatus.NOT_FOUND);
    }

    @PutMapping("/deletePet")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> deleteUserPet(@RequestParam Long id){
        Pet pet = petService.getPetById(id);
        if(pet != null){
            pet.setDeleted(true);
            petService.update(pet);
            return ResponseEntity.ok("Pet successfully deleted");
        }
        return ResponseEntity.badRequest().body("Pet Already deleted");
    }

}
