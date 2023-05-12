/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MiPortfolio.VMF.Service;

import com.MiPortfolio.VMF.Entity.Skills;
import com.MiPortfolio.VMF.Repository.ISkillsRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SkillsService {

    @Autowired
    ISkillsRepo iskillsRepo;

       
        
    public List<Skills> list(){
        return iskillsRepo.findAll();
    }
    
    public Optional<Skills> getOne(Long id){
        return iskillsRepo.findById(id);
    }
    
    public Optional<Skills> getByNombreSkill(String nombreSkills){
        return iskillsRepo.findByNombreSkill(nombreSkills);
    }
    
    public Optional<Skills> getByPorcentaje(String porcentaje){
        return iskillsRepo.findByporcentaje(porcentaje);
    }
        
    public void save(Skills skills){
        iskillsRepo.save(skills);
    }
    
    public void editarSkill(Skills skills){
        iskillsRepo.save(skills);
    }
    
    public void delete(Long id){
        iskillsRepo.deleteById(id);
    }
    
    public boolean existsById(Long id){
        return iskillsRepo.existsById(id);
    }
    
    public boolean existsByNombreSkill(String nombreSkills){
        return iskillsRepo.existsByNombreSkill(nombreSkills);
    }
    
}
