package com.petlife.backend.models;

import com.petlife.backend.requestModels.request.PublishPetRequest;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

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
        private String descripcion;


        private boolean vacunada;

        private boolean adoptado;

        private String link_foto;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "user_id")
        private User user_id;



        public Pet(String nombre,Integer edad,eEsteril esteril, eTipoMascota tipo, String sexo , String raza ,
                   eTamaño tamano, String descripcion, boolean vacunada, boolean adoptado, String link_foto ){
                this.nombre=nombre;
                this.edad=edad;
                this.esteril=esteril;
                this.tipo=tipo;
                this.sexo=sexo;
                this.raza=raza;
                this.tamano=tamano;
                this.descripcion=descripcion;
                this.vacunada=vacunada;
                this.adoptado=adoptado;
                this.link_foto=link_foto;

        }

        public Pet(PublishPetRequest s){
                this.nombre= s.getNombre();
                this.edad= s.getEdad();
                this.esteril= s.getEsteril();
                this.tipo= s.getTipo();
                this.sexo= s.getSexo();
                this.raza= s.getRaza();
                this.tamano= s.getTamano();
                this.descripcion= s.getDescripcion();
                this.vacunada= s.isVacunada();
                this.adoptado=false;

        }



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

        public String getLinks_foto() {
                return link_foto;
        }

        public void setLink_foto(String link_foto) {
                this.link_foto = link_foto;
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
