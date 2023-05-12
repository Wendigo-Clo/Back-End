/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MiPortfolio.VMF.Controller;

import com.MiPortfolio.VMF.Dto.SkillDto;
import com.MiPortfolio.VMF.Entity.Skills;
import com.MiPortfolio.VMF.Security.Controller.Mensaje;
import com.MiPortfolio.VMF.Service.SkillsService;
import io.micrometer.common.util.StringUtils;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/skills")
@CrossOrigin(origins = {"http://localhost:4200"})
public class SkillsController {
    SkillsService skillServices;
    
     @GetMapping("/lista")
    public ResponseEntity<List<Skills>> list(){
        List<Skills> list = skillServices.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    //No necesita detalles ya que no tiene descripcion
    
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        if (!skillServices.existsById(id)) {
            return new ResponseEntity(new Mensaje("esa skill no existe"), HttpStatus.NOT_FOUND);
        }
        skillServices.delete(id);
        return new ResponseEntity(new Mensaje("skills eliminada"), HttpStatus.OK);
    }

    
    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody SkillDto skillDto){      
        if(StringUtils.isBlank(skillDto.getNombreSkill()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(skillServices.existsByNombreSkill(skillDto.getNombreSkill()))
            return new ResponseEntity(new Mensaje("Esa skill no existe"), HttpStatus.BAD_REQUEST);
        
        Skills skill = new Skills( skillDto.getNombreSkill(), skillDto.getPorcentaje());
        skillServices.save(skill);
        
        return new ResponseEntity(new Mensaje("Skill agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/editar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody SkillDto skillDto){
        //Validamos si existe el ID
        if(!skillServices.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de skill
        if(skillServices.existsByNombreSkill(skillDto.getNombreSkill()) && skillServices.getByPorcentaje(skillDto.getPorcentaje()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(skillDto.getNombreSkill()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Skills skill = skillServices.getOne(id).get();
        skill.setNombreSkill(skillDto.getNombreSkill());
        skill.setPorcentaje(skillDto.getPorcentaje());

        
        skillServices.save(skill);
        return new ResponseEntity(new Mensaje("Skill actualizado"), HttpStatus.OK);
             
    }
}
