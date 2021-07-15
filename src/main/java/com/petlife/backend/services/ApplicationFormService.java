package com.petlife.backend.services;

import com.petlife.backend.models.ApplicationForm;
import com.petlife.backend.models.Pet;
import com.petlife.backend.models.User;
import com.petlife.backend.repositories.ApplicationFormRepository;
import com.petlife.backend.requestModels.request.ApplyForm;
import com.petlife.backend.requestModels.response.ApplyFormResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public List<ApplicationForm> getApplUser(User user){
        Optional<List<ApplicationForm>> result = applicationFormRepository.findByUser(user);
        if(result.isPresent()){
            return result.get();
        }
        return null;
    }

    public Page<ApplicationForm> getApplByUserPage(User user, Boolean adopted, Boolean visible, Integer page, Integer size){
        Optional<Page<ApplicationForm>> result = applicationFormRepository.findByUserPage(user, adopted, visible, PageRequest.of(page,size));
        if(result.isPresent()){
            return result.get();
        }
        return null;
    }

    public List<ApplyFormResponse> removeUserDetails(List<ApplicationForm> lista){
        List<ApplyFormResponse> response = new ArrayList<>();
        for (ApplicationForm apply : lista) {

            response.add(new ApplyFormResponse(apply));
        }
        return response;
    }

    public Page<ApplyFormResponse> removeUserDetailsPage(Page<ApplicationForm> appPages){
        List <ApplicationForm> appList = appPages.getContent();
        List<ApplyFormResponse> responseList = new ArrayList<>();
        for (ApplicationForm apply : appList) {
            responseList.add(new ApplyFormResponse(apply));
        }
        Page<ApplyFormResponse> responsePage = new PageImpl<>(responseList,PageRequest.of(appPages.getNumber(),appPages.getSize()), appPages.getTotalElements() );

        return responsePage;
    }

    public ApplicationForm findById(long id){

        Optional<ApplicationForm> apply = applicationFormRepository.findById(id);
        if(apply.isPresent()){
            return(apply.get());
        }
        return null;
    }

    public boolean update(ApplicationForm appli) {
        try {
            applicationFormRepository.save(appli);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
