/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MiPortfolio.VMF.Dto;

import jakarta.validation.constraints.NotBlank;



public class EstudioDto {
    @NotBlank
    private String tituloEstudio;
    @NotBlank
    private String descripcionEstudio;
    @NotBlank
    private String fechaEstudio;

    //Constructor
    public EstudioDto() {
    }

    public EstudioDto(String tituloEstudio, String descripcionEstudio, String fechaEstudio) {
        this.tituloEstudio = tituloEstudio;
        this.descripcionEstudio = descripcionEstudio;
        this.fechaEstudio = fechaEstudio;
    }
    
    //GyS

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

    public String getFechaEstudio() {
        return fechaEstudio;
    }

    public void setFechaEstudio(String fechaEstudio) {
        this.fechaEstudio = fechaEstudio;
    }
    
    
}
