package com.petlife.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.petlife.backend.requestModels.request.PublishPetRequest;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(	name = "pets")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Pet {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotBlank
        @Size(max = 50)
        private String nombre;

        private Integer edad;

        @NotBlank
        private String esteril;

        @NotBlank
        private String tipo;

        @NotBlank
        @Size(max = 10)
        private String sexo;

        @Size(max = 50)
        private String raza;

        @NotBlank
        private String tamano;

        @Size(max = 500)
        private String descripcion;


        private boolean vacunada;

        private boolean adoptado;

        private String link_foto;

        @Column(columnDefinition = "boolean default false")
        private boolean isDeleted;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "user_id")

        @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
        private User user;

        @OneToMany(fetch = FetchType.LAZY, mappedBy = "pet")
        private Set<ApplicationForm> applications = new HashSet();


        public Pet(String nombre,Integer edad,String esteril, String tipo, String sexo , String raza ,
                   String tamano, String descripcion, boolean vacunada, boolean adoptado, String link_foto, User user ){
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
                this.user=user;
                this.isDeleted = false;
        }

        public Pet(PublishPetRequest s, User uid){
                this.nombre= s.getNombre();
                this.edad= s.getEdad();
                this.esteril= s.getEsteril();
                this.tipo= s.getTipo();
                this.sexo= s.getSexo();
                this.raza= s.getRaza();
                this.tamano= s.getTamano();
                this.descripcion= s.getDescripcion();
                this.vacunada= s.isVacunada();
                this.link_foto=s.getLinks_fotos();
                this.user =uid;
                this.adoptado=false;
                this.isDeleted = false;
        }

        public Pet(Long id, String nombre, Integer edad, String tipo, String raza, String link_foto, User user) {
                this.id = id;
                this.nombre = nombre;
                this.edad = edad;
                this.tipo = tipo;
                this.raza = raza;
                this.link_foto = link_foto;
                this.user = user;
                this.isDeleted = false;
        }

        public Pet(Long id, String nombre, Integer edad, String tipo, String raza, String link_foto) {
                this.id = id;
                this.nombre = nombre;
                this.edad = edad;
                this.tipo = tipo;
                this.raza = raza;
                this.link_foto = link_foto;
                this.isDeleted = false;
        }

        public Pet(Long id, String nombre, Integer edad, String tipo, String sexo, String raza, String link_foto) {
                this.id = id;
                this.nombre = nombre;
                this.edad = edad;
                this.tipo = tipo;
                this.sexo = sexo;
                this.raza = raza;
                this.link_foto = link_foto;
                this.isDeleted = false;
        }

        public Pet(Long id, String nombre, Integer edad, String esteril, String tipo, String sexo, String raza, String tamano, String descripcion, boolean vacunada, boolean adoptado, String link_foto) {
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
                this.isDeleted = false;
        }

        public Pet(){
                this.isDeleted = false;
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

        public String getLinks_foto() {
                return link_foto;
        }

        public void setLink_foto(String link_foto) {
                this.link_foto = link_foto;
        }

        public User getUser() {
                return user;
        }

        public void setUser(User user) {
                this.user = user;
        }

        public boolean isAdoptado() {
                return adoptado;
        }

        public void setAdoptado(boolean adoptado) {
                this.adoptado = adoptado;
        }

        public boolean isDeleted() {
                return isDeleted;
        }

        public void setDeleted(boolean deleted) {
                isDeleted = deleted;
        }

        @Override
        public String toString(){
                return this.nombre+","+this.edad+", usuario:";
        }


}
