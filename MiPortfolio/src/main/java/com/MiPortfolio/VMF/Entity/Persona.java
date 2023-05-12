/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MiPortfolio.VMF.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import java.util.List;


@Entity
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private Long id;
    @NotNull
    private String nombre;
    private String descripcion;
    private String fotoPerfil;
    
    
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "persona")
    List<Estudio> EstudioList;
    
    @OneToMany(fetch = FetchType.EAGER,mappedBy="persona")
    List<Experiencia> ExperienciaList;
    
    @OneToMany(fetch = FetchType.EAGER,mappedBy="persona")
    List<Skills> SkillsList;
    
    

    //Constructor

    public Persona() {
    }

    public Persona(String nombre, String descripcion, String fotoPerfil) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fotoPerfil = fotoPerfil;
    }
    
    //G&S

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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }
    
}
