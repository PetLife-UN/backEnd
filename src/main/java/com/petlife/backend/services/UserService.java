package com.petlife.backend.services;

import com.petlife.backend.models.User;
import com.petlife.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> findAllPeople() {
        return userRepository.findAll();
    }


    public User insert(User p) {

        try
        {
            return userRepository.save(p);
        }
        catch(Exception e)
        {

            /*Implementar logging sobre el insert de un User*/
            return p;
        }

    }

    public boolean delete(Long id) {
        try {
            userRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            /*Implementar logging sobre el insert de un User*/
            return false;
        }
    }

    public User findById(Long id) {
        Optional<User> result = userRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        } else {
            return null;
        }
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

    public User findByActivationToken(String activationToken) {
        return userRepository.findByActivationToken(activationToken).orElse(null);
    }

    public boolean existByEmail(String email){
        return userRepository.existsByEmail(email);
    }

    public boolean save(User p) {
        try {
            userRepository.save(p);
            return true;
        } catch (Exception e) {
            /*Implementar logging sobre el insert de un User*/
            return false;
        }
    }

    public boolean update(User p) {
        try {
            userRepository.save(p);
            return true;
        } catch (Exception e) {
            /*Implementar logging sobre el update de un User*/
            return false;
        }
    }
}
