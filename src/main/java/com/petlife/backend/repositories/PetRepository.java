package com.petlife.backend.repositories;

import com.petlife.backend.models.Pet;
import com.petlife.backend.models.User;
import com.petlife.backend.models.eTipoMascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
    /*
    *   Aqui quiero agregar que me busque las mascotas dado el id o nombre del usuario que las publicó
    *
    *
    *
    * */

    Optional<Pet> findById(Long id);
    Optional<Pet> findByTipo(eTipoMascota id);

}
