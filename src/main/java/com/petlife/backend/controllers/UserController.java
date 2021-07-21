package com.petlife.backend.controllers;

import com.petlife.backend.models.User;
import com.petlife.backend.requestModels.request.UserModifyDetailsRequest;
import com.petlife.backend.requestModels.response.UserProfileResponse;
import com.petlife.backend.security.UserDetailsImpl;
import com.petlife.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/getUserDetails")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> returnUserDetails(){
        UserDetailsImpl user_auth= (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userService.findByEmail(user_auth.getUsername());

        List<String> roles = user_auth.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        UserProfileResponse pojo = new UserProfileResponse(user, roles);

        return  ResponseEntity.ok(pojo);


    }

    @PutMapping("/modifyUserDetails")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> modifyUserDetails(@RequestBody UserModifyDetailsRequest info){
        UserDetailsImpl user_auth= (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userService.findByEmail(user_auth.getUsername());

        user.setName(info.getName());
        user.setCellPhoneNumber(info.getCellPhoneNumber());
        user.setSurname(info.getSurname());

        userService.update(user);
        return ResponseEntity.ok("Modifications Done");
    }

}
