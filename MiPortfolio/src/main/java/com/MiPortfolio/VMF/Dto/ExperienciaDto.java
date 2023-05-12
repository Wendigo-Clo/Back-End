/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MiPortfolio.VMF.Dto;

import jakarta.validation.constraints.NotBlank;


public class ExperienciaDto {
    @NotBlank
    private String tituloExp;
    @NotBlank
    private String descripcionExp;
    @NotBlank
    private String fechaExp;
    
    //Contructor

    public ExperienciaDto() {
    }

    public ExperienciaDto(String tituloExp, String descripcionExp, String fechaExp) {
        this.tituloExp = tituloExp;
        this.descripcionExp = descripcionExp;
        this.fechaExp = fechaExp;
    }
    
    //G&S

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
