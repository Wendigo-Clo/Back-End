/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.MiPortfolio.VMF.Repository;

import com.MiPortfolio.VMF.Entity.Estudio;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEstudioRepo extends JpaRepository<Estudio, Long> {
    public Optional<Estudio> findBytituloEstudio(String tituloEstudio);
    public Optional<Estudio> findByDescripcionEstudio(String descripcionEstudio);
    public boolean existsBytituloEstudio(String tituloEstudio);
    public boolean existsByDescripcionEstudio(String descripcionEstudio);
    public Optional<Estudio> findByid(Long id);
    public boolean existsByid(Long id);
}
