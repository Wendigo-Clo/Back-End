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
public class Skills {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private Long id;
    @NotNull
    private String nombreSkill;
    private String porcentaje;

                //RelacionTabla 
    @ManyToOne
    //creacion de columna con llave foranea
    @JoinColumn(name = "personaid")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Persona persona;
    
    //Constructors
    public Skills() {
    }

    public Skills(String nombreSkill, String porcentaje) {
        this.nombreSkill = nombreSkill;
        this.porcentaje = porcentaje;
    }
        //G&S

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreSkill() {
        return nombreSkill;
    }

    public void setNombreSkill(String nombreSkill) {
        this.nombreSkill = nombreSkill;
    }

    public String getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(String porcentaje) {
        this.porcentaje = porcentaje;
    }
    

}
    
