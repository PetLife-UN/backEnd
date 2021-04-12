package com.petlife.backend.services;

import com.petlife.backend.models.Role;
import com.petlife.backend.models.eRole;
import com.petlife.backend.repositories.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class RoleConfiguration {

    @Bean
    CommandLineRunner commandLineRunner(RoleRepository roleRepository){
        return args -> {
           /* eRole user = eRole.ROLE_USER;
            Role rUser = new Role(user);
            eRole moderator = eRole.ROLE_MODERATOR;
            Role rModerator = new Role(moderator);
            eRole admin = eRole.ROLE_ADMIN;
            Role rAdmin = new Role(admin);
            roleRepository.saveAll(List.of(rUser, rModerator, rAdmin));
            */

        };
    }
}
