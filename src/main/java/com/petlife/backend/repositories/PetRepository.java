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
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

    Optional<Pet> findById(Long id);
    Optional<Pet> findByTipo(eTipoMascota id);


    @Query("select new Pet(p.id, p.nombre, p.edad, p.tipo, p.sexo, p.raza, p.link_foto) " +
            "from Pet p " +
            "where p.adoptado  =:#{#adopted}  AND p.isDeleted = false"+
            " order by p.id")
    Page<Pet> getShortPetsInfoPage(@Param("adopted") Boolean adopted, Pageable pageable);


    List<Pet> findAll();

    @Query("select new Pet(p.id, p.nombre, p.edad, p.esteril, p.tipo, p.sexo, p.raza, p.tamano, p.descripcion, p.vacunada, p.adoptado, p.link_foto) " +
            "from Pet p " +
            "where p.id  =:#{#id} AND p.isDeleted = false"+
            " order by p.id")
    Pet getShortPetByIdAlt(@Param("id") long id);

    @Query("select new Pet(p.id, p.nombre, p.edad, p.esteril, p.tipo, p.sexo, p.raza, p.tamano, p.descripcion, p.vacunada, p.adoptado, p.link_foto) from Pet p where" +
            " ((:tipo) is null OR p.tipo IN (:tipo)) AND (:esteril is null OR p.esteril = :esteril) AND (:sexo is null OR p.sexo = :sexo) AND ((:tamano) is null OR p.tamano IN (:tamano)) AND (:vacunada is null OR p.vacunada = :vacunada) AND p.isDeleted = false ORDER BY p.id")
    Page<Pet> getShortPetsFilteredPage(@Param("tipo") List<String > tipos, @Param("esteril") String esteril,@Param("sexo") String sexo,@Param("tamano") List<String> tamano,@Param("vacunada") Boolean vacunada, Pageable pageable);

    Pet getPetById(long Id);

    Optional<List<Pet>> findByUser( User user);
    


}
