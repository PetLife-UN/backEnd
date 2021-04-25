package com.petlife.backend.services;


import com.petlife.backend.models.Pet;
import com.petlife.backend.models.User;
import com.petlife.backend.repositories.PetRepository;
import com.petlife.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<Pet> getAll() {

        try
        {
            return petRepository.findAll();
        }
        catch(Exception e)
        {
            return null;
        }

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

}
