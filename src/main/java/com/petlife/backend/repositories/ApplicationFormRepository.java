package com.petlife.backend.repositories;

import com.petlife.backend.models.ApplicationForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ApplicationFormRepository extends JpaRepository<ApplicationForm, Long> {
    Optional<ApplicationForm> findById(Long id);

    @Query("SELECT ap FROM ApplicationForm ap WHERE ap.pet.id = ?1")
    List<ApplicationForm> findByPet(Long pet_id);
}
