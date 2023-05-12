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
public class Estudio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;
    @NotNull
    private String tituloEstudio;
    private String descripcionEstudio;
    private String fechaEstudio;
    
    
        //RelacionTabla 
    @ManyToOne
    //creacion de columna con llave foranea
    @JoinColumn(name = "personaid")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Persona persona; 
    //Constrictor

    public Estudio() {
    }

    public Estudio(String tituloEstudio, String descripcionEstudio, String fecha) {
        this.tituloEstudio = tituloEstudio;
        this.descripcionEstudio = descripcionEstudio;
        this.fechaEstudio = fechaEstudio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTituloEstudio() {
        return tituloEstudio;
    }

    public void setTituloEstudio(String tituloEstudio) {
        this.tituloEstudio = tituloEstudio;
    }

    public String getDescripcionEstudio() {
        return descripcionEstudio;
    }

    public void setDescripcionEstudio(String descripcionEstudio) {
        this.descripcionEstudio = descripcionEstudio;
    }

    public String getFecha() {
        return fechaEstudio;
    }

    public void setFecha(String fecha) {
        this.fechaEstudio = fechaEstudio;
    }
    
    
    
}
