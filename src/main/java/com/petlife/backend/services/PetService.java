package com.petlife.backend.services;


import com.petlife.backend.models.Pet;
import com.petlife.backend.models.User;
import com.petlife.backend.repositories.PetRepository;
import com.petlife.backend.repositories.UserRepository;
import com.petlife.backend.requestModels.response.PetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PetService {
    @Autowired
    PetRepository petRepository;

    public List<Pet> findAllPubliactions() {
        return petRepository.findAll();
    }

    public Pet insert(Pet p) {

        try
        {
            return petRepository.save(p);
        }
        catch(Exception e)
        {
            return p;
        }

    }

    public List<Pet> findAll() {

        try
        {
            return petRepository.findAll();
        }
        catch(Exception e)
        {
            return null;
        }

    }


    public Pet getPetById(long Id){
        try
        {
            return petRepository.getShortPetByIdAlt(Id);
        }
        catch(Exception e)
        {
            return null;
        }
    }

    public Page<Pet> getShortPetsInfoPage(Boolean adopted, Integer page, Integer size ){
        try
        {
            return petRepository.getShortPetsInfoPage(adopted, PageRequest.of(page,size));
        }
        catch(Exception e)
        {
            return null;
        }
    }

    public List<Pet> getPetsByUser(User user){
       Optional<List<Pet>> result = petRepository.findByUser(user);

        if(result.isPresent()){
            return result.get();
        }
        return null;
    }


    public boolean delete(Long id) {
        try {
            petRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Pet findById(Long id) {
        Optional<Pet> result = petRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        } else {
            return null;
        }
    }

    public boolean save(Pet p) {
        try {
            petRepository.save(p);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean update(Pet p) {
        try {
            petRepository.save(p);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<PetResponse> removeUserDetails(List<Pet> list){
        List<PetResponse> response = new ArrayList<>();

        for(Pet pet : list){
            if(!pet.isDeleted()) {
                response.add(new PetResponse(pet));
            }
        }
        return response;
    }

}
