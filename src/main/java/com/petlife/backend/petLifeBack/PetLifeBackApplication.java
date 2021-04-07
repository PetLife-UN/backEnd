package com.petlife.backend.petLifeBack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@SpringBootApplication
@EntityScan(basePackages = {"com.petLife.backend.models"})
public class PetLifeBackApplication {

    public static void main(String[] args) {
    	SpringApplication.run(PetLifeBackApplication.class, args);
    }



}
