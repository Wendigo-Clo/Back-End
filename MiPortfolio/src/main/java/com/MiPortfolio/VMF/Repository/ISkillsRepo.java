/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.MiPortfolio.VMF.Repository;



import com.MiPortfolio.VMF.Entity.Skills;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISkillsRepo extends JpaRepository<Skills, Long>{
    public Optional<Skills> findByNombreSkill(String nombreSkill);
    public Optional<Skills> findByporcentaje(String Porcentaje);
    public boolean existsByNombreSkill(String nombreSkill); 
}
