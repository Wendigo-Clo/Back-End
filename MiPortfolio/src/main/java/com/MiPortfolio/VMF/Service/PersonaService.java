/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MiPortfolio.VMF.Service;

import com.MiPortfolio.VMF.Entity.Persona;
import com.MiPortfolio.VMF.Repository.IPersonaRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PersonaService {

    @Autowired
    IPersonaRepo ipersonaRepo;

    
    public List<Persona> list(){
         return ipersonaRepo.findAll();
     }
     
     public Optional<Persona> getOne(int id){
         return ipersonaRepo.findById(id);
     }
     
     public Optional<Persona> getByNombre(String nombre){
         return ipersonaRepo.findByNombre(nombre);
     }
     
     public void save(Persona persona){
         ipersonaRepo.save(persona);
     }
     
    public void editarPersona(Persona persona){
         ipersonaRepo.save(persona);
     }
     
     public void delete(int id){
         ipersonaRepo.deleteById(id);
     }
     
     public boolean existsById(int id){
         return ipersonaRepo.existsById(id);
     }
     
     public boolean existsByNombre(String nombre){
         return ipersonaRepo.existsByNombre(nombre);
     }
    


}
