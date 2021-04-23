package com.petlife.backend.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(	name = "pet")
public class Pet {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotBlank
        @Size(max = 50)
        private String nombre;

        private Integer edad;

        @NotBlank
        private eEsteril esteril;

        @NotBlank
        private eTipoMascota tipo;

        @NotBlank
        @Size(max = 10)
        private String sexo;

        @Size(max = 50)
        private String raza;

        @NotBlank
        private eTamaño tamano;

        @Size(max = 500)
        private String descripicon;


        private boolean vacunada;

        @ElementCollection
        private List<String> links_fotos = new ArrayList<String>();

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "user_id")
        private User user_id;


        private boolean adoptado;


        public Long getId() {
                return id;
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

        public String getDescripicon() {
                return descripicon;
        }

        public void setDescripicon(String descripicon) {
                this.descripicon = descripicon;
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

        public User getUser_id() {
                return user_id;
        }

        public void setUser_id(User user_id) {
                this.user_id = user_id;
        }

        public boolean isAdoptado() {
                return adoptado;
        }

        public void setAdoptado(boolean adoptado) {
                this.adoptado = adoptado;
        }


}
