package com.petlife.backend.controllers;

import com.petlife.backend.models.ApplicationForm;
import com.petlife.backend.models.Pet;
import com.petlife.backend.requestModels.request.ApplyForm;
import com.petlife.backend.requestModels.response.MessageResponse;
import com.petlife.backend.services.ApplicationFormService;
import com.petlife.backend.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/apply")
public class ApplicationFormController {

    private final ApplicationFormService applicationFormService;
    private final PetService petService;

    @Autowired
    public ApplicationFormController(ApplicationFormService applicationFormService, PetService petService){
        this.applicationFormService = applicationFormService;
        this.petService = petService;
    }

    @PostMapping("/{pet_id}")
    public ResponseEntity<?> applyPet(@RequestBody ApplyForm applyForm,@PathVariable("pet_id") Long pet_id){
        Pet pet = petService.findById(pet_id);
        ApplicationForm applicationForm = new ApplicationForm(applyForm, pet);
        boolean result = applicationFormService.instert(applicationForm);
        if(result)
            return ResponseEntity.ok(new MessageResponse("Se ha registrado correctamente"));
        else
            return new ResponseEntity<>(new MessageResponse("No se ha podido registrar la solicitud"), HttpStatus.NOT_FOUND);
    }
}
