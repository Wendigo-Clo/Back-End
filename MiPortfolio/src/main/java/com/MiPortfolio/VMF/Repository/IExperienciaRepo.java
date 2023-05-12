/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.MiPortfolio.VMF.Repository;

import com.MiPortfolio.VMF.Entity.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExperienciaRepo extends JpaRepository<Experiencia, Long> {
    public Optional<Experiencia> findBytituloExp(String tituloExp);
    public Optional<Experiencia> findBydescripcionExp(String descripcionExp);
    public Optional<Experiencia> getBytituloExp(String tituloExp);
    public boolean existsBytituloExp(String tituloExp);
}
