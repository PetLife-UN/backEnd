package com.petlife.backend.requestModels.response;

import com.petlife.backend.models.Pet;

public class PetResponse {
    private Long id;

    private String nombre;

    private Integer edad;

    private String esteril;

    private String tipo;

    private String sexo;

    private String raza;

    private String tamano;

    private String descripcion;

    private boolean vacunada;

    private boolean adoptado;

    private String link_foto;

    private boolean isDeleted;

    public PetResponse(Long id, String nombre, Integer edad, String esteril, String tipo, String sexo, String raza, String tamano, String descripcion, boolean vacunada, boolean adoptado, String link_foto, boolean isDeleted) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.esteril = esteril;
        this.tipo = tipo;
        this.sexo = sexo;
        this.raza = raza;
        this.tamano = tamano;
        this.descripcion = descripcion;
        this.vacunada = vacunada;
        this.adoptado = adoptado;
        this.link_foto = link_foto;
        this.isDeleted = isDeleted;
    }

    public PetResponse(Pet pet){
        this.id = pet.getId();
        this.nombre = pet.getNombre();
        this.edad = pet.getEdad();
        this.esteril = pet.getEsteril();
        this.tipo = pet.getTipo();
        this.sexo = pet.getSexo();
        this.raza = pet.getRaza();
        this.tamano = pet.getTamano();
        this.descripcion = pet.getDescripcion();
        this.vacunada = pet.isVacunada();
        this.adoptado = pet.isAdoptado();
        this.link_foto = pet.getLinks_foto();
        this.isDeleted = pet.isDeleted();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public boolean isAdoptado() {
        return adoptado;
    }

    public void setAdoptado(boolean adoptado) {
        this.adoptado = adoptado;
    }

    public String getLink_foto() {
        return link_foto;
    }

    public void setLink_foto(String link_foto) {
        this.link_foto = link_foto;
    }

    public boolean isDeleted() { return isDeleted; }

    public void setDeleted(boolean deleted) { isDeleted = deleted; }
}
