package com.petlife.backend.services;

import com.petlife.backend.models.ApplicationForm;
import com.petlife.backend.repositories.ApplicationFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationFormService {

    @Autowired
    ApplicationFormRepository applicationFormRepository;

    public List<ApplicationForm> findAllApplications(){
        return applicationFormRepository.findAll();
    }

    public List<ApplicationForm> findAllApplicationsByPet(Long pet_id){
        return applicationFormRepository.findByPet(pet_id);
    }

    public boolean instert(ApplicationForm applicationForm){
        try{
            applicationFormRepository.save(applicationForm);
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
        return true;
    }

}
