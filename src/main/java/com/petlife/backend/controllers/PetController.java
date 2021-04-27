package com.petlife.backend.controllers;

import com.petlife.backend.models.Pet;
import com.petlife.backend.repositories.PetRepository;
import com.petlife.backend.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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



}