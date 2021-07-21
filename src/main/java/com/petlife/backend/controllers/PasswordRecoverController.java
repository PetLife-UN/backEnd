package com.petlife.backend.controllers;

import com.petlife.backend.models.PasswordToken;
import com.petlife.backend.models.User;
import com.petlife.backend.requestModels.request.PasswordChangeRequest;
import com.petlife.backend.services.PasswordTokenService;
import com.petlife.backend.services.SendEmailService;
import com.petlife.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/passrecover")
public class PasswordRecoverController {
    @Autowired
    UserService userService;

    @Autowired
    PasswordTokenService passwordTokenService;

    @Autowired
    SendEmailService emailService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping(value = "/sendLink/{email}")
    public ResponseEntity<Void> sendToken(@PathVariable String email){
        User user = userService.findByEmail(email);
        if(user != null){
            PasswordToken token = passwordTokenService.generatePasswordRecoveryToken(user);
            String url = "https://un-petlife.netlify.app/password/" + token.getToken();

            String text = "<div><h3>Solicitud de reestablecimiento de contraseña</h3>" +
                    "<h4>¡Hola!</h4><p>Hemos recibido una solicitud para el cambio de contraseña a la cuenta enlazada a éste correo, si fuiste tu por favor sigue el proceso en el siguiente enlace que te brindaremos." +
                    " Podrá usar este enlace durante la próxima hora, luego de esto vencerá y tendrá que solicitar uno nuevo." +
                    " Si no realizo ninguna solicitud de cambio de contraseña, puede hacer caso omiso a este correo." +
                    "</p><a class=\"button\" href=\""+ url +"\" style=\"color:white; box-shadow:inset 0px -3px 7px 0px #29bbff;background:linear-gradient(to bottom, #2dabf9 5%, #0688fa 100%);background-color:#2dabf9;border-radius:3px;border:1px solid #0b0e07;display:inline-block;cursor:pointer;color:#ffffff;font-family:Arial;font-size:15px;padding:9px 23px;text-decoration:none;text-shadow:0px 1px 0px #263666;\">" +
                    "Haga clic aquí para redirigirse al cambio de contraseña</a></div></div>";

            emailService.sendEmailPasswordRecovery(user.getEmail(), "Recuperación de Contraseña", text);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping (value = "/changePassword")
    public ResponseEntity<Void> changePassword(@RequestBody PasswordChangeRequest request){
        User user = userService.findByEmail(passwordTokenService.getUsername(request.getToken()));
        if(user != null){
            user.setPassword( passwordTokenService.encryptPassword(request.getPassword()));
            userService.update(user);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


}
