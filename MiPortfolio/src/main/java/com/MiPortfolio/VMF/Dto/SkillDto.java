/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MiPortfolio.VMF.Dto;

import jakarta.validation.constraints.NotBlank;


public class SkillDto {
    @NotBlank
    private String nombreSkill;
    @NotBlank
    private String porcentaje;
    
    //Constructor

    public SkillDto() {
    }
    

    public SkillDto(String nombreSkill, String porcentaje) {
        this.nombreSkill = nombreSkill;
        this.porcentaje = porcentaje;
    }
    
    
    //G&S

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
