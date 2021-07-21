package com.petlife.backend.controllers;

import com.petlife.backend.services.JwtServices;
import com.petlife.backend.models.Role;
import com.petlife.backend.models.User;
import com.petlife.backend.models.eRole;
import com.petlife.backend.repositories.RoleRepository;
import com.petlife.backend.requestModels.response.JwtResponse;
import com.petlife.backend.requestModels.request.LoginRequest;
import com.petlife.backend.requestModels.response.MessageResponse;
import com.petlife.backend.requestModels.request.RegisterRequest;
import com.petlife.backend.services.PasswordTokenService;
import com.petlife.backend.services.SendEmailService;
import com.petlife.backend.security.UserDetailsImpl;
import com.petlife.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserService userService;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordTokenService passwordTokenService;

    @Autowired
    JwtServices jwtUtils;

    @Autowired
    private SendEmailService sendEmailService;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        User user = userService.findByEmail(loginRequest.getUsername());
        if(user != null){
            if(user.isActivated()){
                Authentication authentication = authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

                SecurityContextHolder.getContext().setAuthentication(authentication);
                String jwt = jwtUtils.generateJwtToken(authentication);

                UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
                List<String> roles = userDetails.getAuthorities().stream()
                        .map(item -> item.getAuthority())
                        .collect(Collectors.toList());
                user.setLastLogin(LocalDateTime.now());
                userService.update(user);

                return ResponseEntity.ok(new JwtResponse(
                        userDetails.getId(),
                        userDetails.getUsername(),
                        userDetails.getEmail(),
                        roles,
                        jwt));
            }
            return new ResponseEntity<>(new MessageResponse("Usuario no activado"),HttpStatus.FORBIDDEN );
        }
        return new ResponseEntity<>(new MessageResponse("Usuario no registrado"),HttpStatus.NOT_FOUND );


    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegisterRequest signUpRequest) {
        if (userService.existByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        // Create new user's account
        User user = new User(signUpRequest.getEmail(),
                passwordTokenService.encryptPassword(signUpRequest.getPassword()),
                signUpRequest.getName(),
                signUpRequest.getSurname(),
                signUpRequest.getCellPhoneNumber()
                );

        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(eRole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(eRole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;
                    case "mod":
                        Role modRole = roleRepository.findByName(eRole.ROLE_MODERATOR)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(modRole);

                        break;
                    default:
                        Role userRole = roleRepository.findByName(eRole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }
        user.setRoles(roles);
        userService.save(user);
        sendEmailService.sendEmail(user.getEmail(), "Welcome to petLife", user.getActivationToken(), "https://un-petlife.netlify.app/activate");

        if (userService.save(user) == true) {
            sendEmailService.sendEmail(user.getEmail(), "Bienvendio a PetLife", user.getActivationToken(), "https://un-petlife.netlify.app/activate");
        }




        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

    @PostMapping("/activate/{token}")
    public ResponseEntity<?> activateAccount(@PathVariable String token) {
        User user = userService.findByActivationToken(token);
        if(user != null){
            if(!user.isActivated()){
                user.setActivated(true);
                userService.update(user);
                return ResponseEntity.ok(new MessageResponse("Account is now activated"));
            }
            return new ResponseEntity<>(new MessageResponse("Account already activated"), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new MessageResponse("Account not found"), HttpStatus.NOT_FOUND);
    }
}
