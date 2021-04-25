package com.petlife.backend.repositories;

import com.petlife.backend.models.Pet;
import com.petlife.backend.models.User;
import com.petlife.backend.models.eTipoMascota;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

    Optional<Pet> findById(Long id);
    Optional<Pet> findByTipo(eTipoMascota id);


    @Query("select new Pet(p.id,p.nombre,p.edad,p.tipo,p.raza,p.link_foto,p.user)  " +
            "from Pet p " +
            "where p.adoptado  =:#{#adopted} "+
            " order by p.id")
    Page<Pet> getShortPetsInfoPage(@Param("adopted") Boolean adopted, Pageable pageable);

    Pet getPetById(long Id);

}
