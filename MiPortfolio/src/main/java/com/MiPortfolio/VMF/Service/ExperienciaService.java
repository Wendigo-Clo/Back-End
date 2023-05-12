/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MiPortfolio.VMF.Service;


import com.MiPortfolio.VMF.Entity.Experiencia;
import com.MiPortfolio.VMF.Repository.IExperienciaRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class ExperienciaService {
    
    @Autowired
    IExperienciaRepo iexperienciaRepo;
    
        
    public List<Experiencia> list(){
        return iexperienciaRepo.findAll();
    }
    
    public Optional<Experiencia> getOne(Long id){
        return iexperienciaRepo.findById(id);
    }
    
    public Optional<Experiencia> getByNombreExp(String tituloExp){
        return iexperienciaRepo.findBytituloExp(tituloExp);
    }
    public Optional<Experiencia> getByDescripcionExp(String descripcionExp){
        return iexperienciaRepo.findBydescripcionExp(descripcionExp);
    }
        
    public void save(Experiencia Exp){
        iexperienciaRepo.save(Exp);
    }
    
    public void editarExp(Experiencia Exp){
        iexperienciaRepo.save(Exp);
    }
    
    public void delete(Long id){
        iexperienciaRepo.deleteById(id);
    }
    
    public boolean existsById(Long id){
        return iexperienciaRepo.existsById(id);
    }
    
    
    public boolean existsByTituloExp(String tituloExp){
        return iexperienciaRepo.existsBytituloExp(tituloExp);
    }
    
}
