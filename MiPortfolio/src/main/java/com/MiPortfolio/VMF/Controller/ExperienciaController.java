/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.MiPortfolio.VMF.Controller;


import com.MiPortfolio.VMF.Dto.ExperienciaDto;
import com.MiPortfolio.VMF.Entity.Experiencia;
import com.MiPortfolio.VMF.Security.Controller.Mensaje;
import com.MiPortfolio.VMF.Service.ExperienciaService;
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
@RequestMapping ("/exp")
@CrossOrigin(origins = {"http://localhost:8080"})
public class ExperienciaController {
    //Creo para urilizar sus metodos

     ExperienciaService experienciaService;
     
     
    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list(){
        List<Experiencia> list = experienciaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
     
    
    @GetMapping("/detalles/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") Long id){
        if(!experienciaService.existsById(id))
            return new ResponseEntity(new Mensaje("esa descripcion no existe"), HttpStatus.NOT_FOUND);
        Experiencia experiencia = experienciaService.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
    
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        if (!experienciaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("Esa experiencia no existe"), HttpStatus.NOT_FOUND);
        }
        experienciaService.delete(id);
        return new ResponseEntity(new Mensaje("Experiencia eliminada"), HttpStatus.OK);
    }

    
    @PostMapping("/crear")
    public ResponseEntity<Experiencia> create(@RequestBody ExperienciaDto experienciaDto){      
        if(StringUtils.isBlank(experienciaDto.getTituloExp()))
            return new ResponseEntity(new Mensaje("El titulo es obligatorio"), HttpStatus.BAD_REQUEST);
        if(experienciaService.existsByTituloExp(experienciaDto.getTituloExp()))
            return new ResponseEntity(new Mensaje("Esa experiencia no existe"), HttpStatus.BAD_REQUEST);
        
        Experiencia experiencia = new Experiencia( experienciaDto.getTituloExp(), experienciaDto.getDescripcionExp(),experienciaDto.getFechaExp());
        experienciaService.save(experiencia);
        
        return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);
    }
    
    
    @PutMapping("/editar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody ExperienciaDto experienciaDto){
        //Validamos si existe el ID
        if(!experienciaService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de experiencias REVISAR YA QUE ES LONG SE DEBE INVERTIR
        if(experienciaService.existsByTituloExp(experienciaDto.getTituloExp()) && !Objects.equals(experienciaService.getByDescripcionExp(experienciaDto.getDescripcionExp()).get().getId(), id))
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(experienciaDto.getTituloExp()))
            return new ResponseEntity(new Mensaje("El titulo es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Experiencia experiencia = experienciaService.getOne(id).get();
        experiencia.setTituloExp(experienciaDto.getTituloExp());
        experiencia.setDescripcionExp(experienciaDto.getDescripcionExp());
        experiencia.setFechaExp(experienciaDto.getFechaExp());

        
        experienciaService.save(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia actualizado"), HttpStatus.OK);
             
    }
    
}
