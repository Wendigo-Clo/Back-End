/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MiPortfolio.VMF.Controller;

import com.MiPortfolio.VMF.Dto.EstudioDto;
import com.MiPortfolio.VMF.Entity.Estudio;
import com.MiPortfolio.VMF.Security.Controller.Mensaje;
import com.MiPortfolio.VMF.Service.EstudioService;
import io.micrometer.common.util.StringUtils;
import java.util.List;
import java.util.Objects;
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
@RequestMapping ("/estudio")
@CrossOrigin(origins = {"http://localhost:4200"})
public class EstudioController {
           EstudioService estudioService;
    
        
    @GetMapping("/lista")
    public ResponseEntity<List<Estudio>> list(){
        List<Estudio> list = estudioService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detalles/{id}")
    public ResponseEntity<Estudio> getById(@PathVariable("id") Long id){
        if(!estudioService.existsById(id))
            return new ResponseEntity(new Mensaje("esa descripcion no existe"), HttpStatus.NOT_FOUND);
        Estudio estudio = estudioService.getOne(id).get();
        return new ResponseEntity(estudio, HttpStatus.OK);
    }
    
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        if (!estudioService.existsById(id)) {
            return new ResponseEntity(new Mensaje("ese estudio no existe"), HttpStatus.NOT_FOUND);
        }
        estudioService.delete(id);
        return new ResponseEntity(new Mensaje("Estudio eliminado"), HttpStatus.OK);
    }

    
    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody EstudioDto estudioDto){      
        if(StringUtils.isBlank(estudioDto.getTituloEstudio()))
            return new ResponseEntity(new Mensaje("El titulo es obligatorio"), HttpStatus.BAD_REQUEST);
        /*if(estudioService.existsBytituloEstudio(estudioDto.getTituloEstudio()))
            return new ResponseEntity(new Mensaje("Ese estudio no existe"), HttpStatus.BAD_REQUEST);
       */
        Estudio estudio = new Estudio( estudioDto.getTituloEstudio(), estudioDto.getDescripcionEstudio(),estudioDto.getFechaEstudio());
        estudioService.save(estudio);
        
        return new ResponseEntity(new Mensaje("Estudio agregado"), HttpStatus.OK);
    }
    
    
    @PutMapping("/editar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody EstudioDto estudioDto){
        //Validamos si existe el ID
        if(!estudioService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de estudios
        if(estudioService.existsBytituloEstudio(estudioDto.getTituloEstudio()) && !Objects.equals(estudioService.getByDescripcionEstudio(estudioDto.getDescripcionEstudio()).get().getId(), id))
            return new ResponseEntity(new Mensaje("Ese estudio ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(estudioDto.getTituloEstudio()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Estudio estudio = estudioService.getOne(id).get();
        estudio.setTituloEstudio(estudioDto.getTituloEstudio());
        estudio.setDescripcionEstudio(estudioDto.getDescripcionEstudio());
        estudio.setFecha(estudioDto.getFechaEstudio());

        
        estudioService.save(estudio);
        return new ResponseEntity(new Mensaje("Estudio actualizado"), HttpStatus.OK);
             
    }
}
    

