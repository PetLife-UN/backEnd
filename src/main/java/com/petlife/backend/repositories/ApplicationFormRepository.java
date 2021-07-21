package com.petlife.backend.repositories;

import com.petlife.backend.models.ApplicationForm;
import com.petlife.backend.models.Pet;
import com.petlife.backend.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ApplicationFormRepository extends JpaRepository<ApplicationForm, Long> {
    Optional<ApplicationForm> findById(Long id);

    @Query("SELECT ap FROM ApplicationForm ap WHERE ap.pet.id = ?1")
    List<ApplicationForm> findByPet(Long pet_id);




    @Query("SELECT  ap " +
            "FROM ApplicationForm ap " +
            "INNER JOIN Pet p ON p = ap.pet " +
            "WHERE p.user =:#{#user} AND p.adoptado = false " +
            "ORDER BY ap.id DESC")
    Optional<List<ApplicationForm>> findByUser(@Param("user") User user);


    @Query("SELECT  ap " +
            "FROM ApplicationForm ap " +
            "INNER JOIN Pet p ON p = ap.pet " +
            "WHERE p.user =:#{#user} AND p.isDeleted =:#{#isDeleted} AND (:visible is null OR ap.publicationVisible = :visible) " +
            "ORDER BY ap.id DESC")
    Optional <Page<ApplicationForm>> findByUserPage(@Param("user") User user, @Param("isDeleted") Boolean isDeleted, @Param("visible") Boolean visible, Pageable pageable);

}
