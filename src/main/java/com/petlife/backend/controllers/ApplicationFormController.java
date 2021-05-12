package com.petlife.backend.controllers;

import com.petlife.backend.models.ApplicationForm;
import com.petlife.backend.models.Pet;
import com.petlife.backend.models.User;
import com.petlife.backend.requestModels.request.ApplyForm;
import com.petlife.backend.requestModels.response.MessageResponse;
import com.petlife.backend.security.UserDetailsImpl;
import com.petlife.backend.services.ApplicationFormService;
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
@RequestMapping("/api/apply")
public class ApplicationFormController {

    private final ApplicationFormService applicationFormService;
    private final PetService petService;

    @Autowired
    UserService userService;

    @Autowired
    public ApplicationFormController(ApplicationFormService applicationFormService, PetService petService){
        this.applicationFormService = applicationFormService;
        this.petService = petService;
    }

    @PostMapping("/form/{pet_id}")
    public ResponseEntity<?> applyPet(@RequestBody ApplyForm applyForm,@PathVariable("pet_id") Long pet_id){
        Pet pet = petService.findById(pet_id);
        ApplicationForm applicationForm = new ApplicationForm(applyForm, pet);
        boolean result = applicationFormService.instert(applicationForm);
        if(result)
            return ResponseEntity.ok(new MessageResponse("Se ha registrado correctamente"));
        else
            return new ResponseEntity<>(new MessageResponse("No se ha podido registrar la solicitud"), HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getApplicationUser")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> returnApplicUser(){
        UserDetailsImpl user_auth= (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userService.findByEmail(user_auth.getUsername());
        List<ApplicationForm> applist = applicationFormService.getApplUser(user);
        return new ResponseEntity<>(applicationFormService.removeUserDetails(applist), HttpStatus.OK);
    }

    @GetMapping("/getApplicationUserPage")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> returnApplicUser(@RequestParam Optional<Boolean> adopted, @RequestParam Optional<Integer> page,@RequestParam Optional<Integer> size){
        UserDetailsImpl user_auth= (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userService.findByEmail(user_auth.getUsername());
        Page<ApplicationForm> apppages = applicationFormService.getApplByUserPage(user, adopted.orElse(false), page.orElse(0),size.orElse(6));
        return new ResponseEntity<>(applicationFormService.removeUserDetailsPage(apppages), HttpStatus.OK);
    }
}
