package com.petlife.backend.controllers;

import com.petlife.backend.models.ApplicationForm;
import com.petlife.backend.models.Pet;
import com.petlife.backend.models.User;
import com.petlife.backend.requestModels.request.ApplyForm;
import com.petlife.backend.requestModels.request.ApplyModifyRequest;
import com.petlife.backend.requestModels.request.UserModifyDetailsRequest;
import com.petlife.backend.requestModels.response.MessageResponse;
import com.petlife.backend.security.UserDetailsImpl;
import com.petlife.backend.services.ApplicationFormService;
import com.petlife.backend.services.PetService;
import com.petlife.backend.services.UserService;
import com.petlife.backend.services.SendEmailService;
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
    SendEmailService emailService;


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
        User user = pet.getUser();

        if(result) {
            String urlPetImage = "https://un-petlife.netlify.app/Info-mascota/"+pet_id.toString();
            String adopter = "<table style=\"max-width: 600px; padding: 10px; margin:0 auto; border-collapse: collapse;\">" +
                    "<tr>" +
                        "<td style=\"background-color: #ecf0f1; text-align: left; padding: 0\">"+
                            "<img width=\"20%\" style=\"display:block; margin: 0% 1%\" src=\"https://i.postimg.cc/pV3qdkj2/petlife.jpg\">"+
                        "</td>"+
                    "</tr>" +
                        "<td style=\"background-color: #ecf0f1\">"+
                            "<div style=\"color: #34495e; margin: 4% 10% 2%; text-align: justify;font-family: sans-serif\">"+
                                "<h2 style=\"color: #e67e22; margin: 0 0 7px\">¡Felicitaciones!</h2>"+
                                "<p style=\"margin: 2px; font-size: 15px\">"+
                                    "Tu solicitud para aplicar a la adopción de "+ pet.getNombre()+" ha sido enviada :D. Haz click sobre el siguiente botón para verla "+
                                "</p>"+
                            "</div>"+
                            "<div style=\"width: 100%; text-align: center\">"+
                    "</p><a class=\"button\" href=\""+ urlPetImage +"\" style=\"color:white; box-shadow:inset 0px -3px 7px 0px #29bbff;background:linear-gradient(to bottom, #2dabf9 5%, #0688fa 100%);background-color:#2dabf9;border-radius:3px;border:1px solid #0b0e07;display:inline-block;cursor:pointer;color:#ffffff;font-family:Arial;font-size:15px;padding:9px 23px;text-decoration:none;text-shadow:0px 1px 0px #263666;\">" +
                    "Haga clic aquí para ver la publicación</a></div></div>"+
                            "</div>"+
                        "</td>" +
                    "</tr>" +
                    "</table>";

            String publisher = "<table style=\"max-width: 600px; padding: 10px; margin:0 auto; border-collapse: collapse;\">" +
                    "<tr>" +
                        "<td style=\"background-color: #ecf0f1; text-align: left; padding: 0\">"+
                            "<img width=\"20%\" style=\"display:block; margin: 0% 1%\" src=\"https://i.postimg.cc/pV3qdkj2/petlife.jpg\">"+
                        "</td>"+
                    "</tr>" +
                        "<td style=\"background-color: #ecf0f1\">"+
                            "<div style=\"color: #34495e; margin: 4% 10% 2%; text-align: justify;font-family: sans-serif\">"+
                                "<h2 style=\"color: #e67e22; margin: 0 0 7px\">¡Felicitaciones!</h2>"+
                                "<p style=\"margin: 2px; font-size: 15px\">"+
                                    "Has recibido una solicitud de adopción para "+ pet.getNombre()+" :D. Haz click sobre el siguiente botón para verla "+
                                "</p>"+
                            "</div>"+
                            "<div style=\"width: 100%; text-align: center\">"+
                                "</p><a class=\"button\" href=\""+ urlPetImage +"\" style=\"color:white; box-shadow:inset 0px -3px 7px 0px #29bbff;background:linear-gradient(to bottom, #2dabf9 5%, #0688fa 100%);background-color:#2dabf9;border-radius:3px;border:1px solid #0b0e07;display:inline-block;cursor:pointer;color:#ffffff;font-family:Arial;font-size:15px;padding:9px 23px;text-decoration:none;text-shadow:0px 1px 0px #263666;\">" +
                                    "Haz clic aquí para ver la publicación</a></div></div>"+
                            "</div>"+
                        "</td>" +
                    "</tr>" +
                    "</table>";

            emailService.sendEmailPasswordRecovery(user.getEmail(), "Notificación solicitud de adopción",publisher);
            emailService.sendEmailPasswordRecovery(applicationForm.getEmail(), "Notificación solicitud de adopción",adopter);

            return ResponseEntity.ok(new MessageResponse("Se ha registrado correctamente"));
        }
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
    public ResponseEntity<?> returnApplicUser(@RequestParam Optional<Boolean> deleted, @RequestParam Optional<Boolean> visible, @RequestParam Optional<Integer> page,@RequestParam Optional<Integer> size){
        UserDetailsImpl user_auth= (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userService.findByEmail(user_auth.getUsername());
        Page<ApplicationForm> apppages = applicationFormService.getApplByUserPage(user, deleted.orElse(false), visible.orElse(null),page.orElse(0),size.orElse(6));
        return new ResponseEntity<>(applicationFormService.removeUserDetailsPage(apppages), HttpStatus.OK);
    }

    @PutMapping("/modifyApplicationVis")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> modifyUserDetails(@RequestBody ApplyModifyRequest applyInfo){
        UserDetailsImpl user_auth= (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userService.findByEmail(user_auth.getUsername());
        ApplicationForm appli = applicationFormService.findById(applyInfo.getId());
        if(appli != null){
            if(appli.getPet().getUser() == user){
                appli.setPublicationVisible(applyInfo.isPublicationVisible());
                applicationFormService.update(appli);
                return new ResponseEntity<>(new MessageResponse("Publicacion modificada correctamente"),HttpStatus.OK);
            }
            return new ResponseEntity<>(new MessageResponse("Usuario no autorizado"),HttpStatus.UNAUTHORIZED);

        }
        return new ResponseEntity<>(new MessageResponse("Publicacion no encontrada"),HttpStatus.NOT_FOUND);
    }
}
