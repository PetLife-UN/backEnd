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
    private String esteril;

    @NotBlank
    private String tipo;

    @NotBlank
    private String sexo;

    @NotBlank
    private String raza;

    @NotBlank
    private String tamano;

    @NotBlank
    private boolean vacunada;

    @NotBlank
    private String descripcion;


    private String link_foto ;


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

    public String getEsteril() {
        return esteril;
    }

    public void setEsteril(String esteril) {
        this.esteril = esteril;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
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

    public String getTamano() {
        return tamano;
    }

    public void setTamano(String tamano) {
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

    public String getLinks_fotos() {
        return link_foto;
    }

    public void setLink_foto(String links_fotos) {
        this.link_foto = links_fotos;
    }
}
