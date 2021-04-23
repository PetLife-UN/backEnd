package com.petlife.backend.requestModels.request;

import com.petlife.backend.models.eEsteril;
import com.petlife.backend.models.eTamaño;
import com.petlife.backend.models.eTipoMascota;

import javax.persistence.ElementCollection;
import javax.validation.constraints.NotBlank;
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
    private boolean vacunada;
    @NotBlank
    private String descripcion;

    @NotBlank
    private String token;

    @ElementCollection
    private List<String> links_fotos = new ArrayList<String>();

    /*
    *   aqui debería ir el token?
    *
    * */

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public eEsteril getEsteril() {
        return esteril;
    }

    public void setEsteril(eEsteril esteril) {
        this.esteril = esteril;
    }

    public eTipoMascota getTipo() {
        return tipo;
    }

    public void setTipo(eTipoMascota tipo) {
        this.tipo = tipo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public eTamaño getTamano() {
        return tamano;
    }

    public void setTamano(eTamaño tamano) {
        this.tamano = tamano;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isVacunada() {
        return vacunada;
    }

    public void setVacunada(boolean vacunada) {
        this.vacunada = vacunada;
    }

    public List<String> getLinks_fotos() {
        return links_fotos;
    }

    public void setLinks_fotos(List<String> links_fotos) {
        this.links_fotos = links_fotos;
    }
}
