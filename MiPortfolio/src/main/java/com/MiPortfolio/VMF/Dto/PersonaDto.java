/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MiPortfolio.VMF.Dto;

import jakarta.validation.constraints.NotBlank;


public class PersonaDto {
    @NotBlank
    private String nombre;
    @NotBlank
    private String descripcion;
    @NotBlank
    private String fotoPerfil;
    
    //Constructor

    public PersonaDto() {
    }

    public PersonaDto(String nombre, String descripcion, String fotoPerfil) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fotoPerfil = fotoPerfil;
    }
         
    //GYS

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
