package com.petlife.backend.requestModels.request;

import com.petlife.backend.models.eEsteril;
import com.petlife.backend.models.eTamaño;
import com.petlife.backend.models.eTipoMascota;

import javax.persistence.ElementCollection;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

public class PublishPetRequest {

    @NotBlank
    private String nombre;

    @NotBlank
    private Integer edad;

    @NotBlank
    private eEsteril esteril;

    @NotBlank
    private eTipoMascota tipo;

    @NotBlank
    private String sexo;

    @NotBlank
    private String raza;

    @NotBlank
    private eTamaño tamano;

    @NotBlank
    private String descripicon;

    @NotBlank
    private boolean vacunada;

    @ElementCollection
    private List<String> links_fotos = new ArrayList<String>();



}
