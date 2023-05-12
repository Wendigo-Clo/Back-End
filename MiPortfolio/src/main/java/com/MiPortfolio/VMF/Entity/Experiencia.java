/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MiPortfolio.VMF.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Experiencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;
    @NotNull
    private String tituloExp;
    private String descripcionExp;
    private String fechaExp;
    
    
            //RelacionTabla 
    @ManyToOne
    //creacion de columna con llave foranea
    @JoinColumn(name = "personaid")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Persona persona;
    //Constructor

    public Experiencia() {
    }

    public Experiencia(String tituloExp, String descripcionExp, String fechaExp) {
        this.tituloExp = tituloExp;
        this.descripcionExp = descripcionExp;
        this.fechaExp = fechaExp;
    }

      //G & S

    public Long getId() {
        return id;
    }

    public void setIdExp(Long id) {
        this.id = id;
    }

    public String getTituloExp() {
        return tituloExp;
    }

    public void setTituloExp(String tituloExp) {
        this.tituloExp = tituloExp;
    }

    public String getDescripcionExp() {
        return descripcionExp;
    }

    public void setDescripcionExp(String descripcionExp) {
        this.descripcionExp = descripcionExp;
    }

    public String getFechaExp() {
        return fechaExp;
    }

    public void setFechaExp(String fechaExp) {
        this.fechaExp = fechaExp;
    }
    
    

}
