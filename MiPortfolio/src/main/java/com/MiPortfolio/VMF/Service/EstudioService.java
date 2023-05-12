/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MiPortfolio.VMF.Service;

import com.MiPortfolio.VMF.Entity.Estudio;
import com.MiPortfolio.VMF.Repository.IEstudioRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EstudioService {
    
    @Autowired 
    IEstudioRepo iestudioRepo;
    
    
    public List<Estudio> list(){
        return iestudioRepo.findAll();
    }
    
    public Optional<Estudio> getOne(Long id){
        return iestudioRepo.findByid(id);
    }
    
    public Optional<Estudio> getByNombreEstudio(String tituloEstudio){
        return iestudioRepo.findBytituloEstudio(tituloEstudio);
    }
    public Optional<Estudio> getByDescripcionEstudio(String tituloEstudio){
        return iestudioRepo.findByDescripcionEstudio(tituloEstudio);
    }
        
    public void save(Estudio Estudio){
        iestudioRepo.save(Estudio);
    }
    
    public void editarEstudio(Estudio Estudio){
        iestudioRepo.save(Estudio);
    }
    
    public void delete(Long idEstudio){
        iestudioRepo.deleteById(idEstudio);
    }
    
    public boolean existsById(Long id){
        return iestudioRepo.existsById(id);
    }
    
    public boolean existsBytituloEstudio(String tituloEstudio){
        return iestudioRepo.existsBytituloEstudio(tituloEstudio);
    }
    
    
}
