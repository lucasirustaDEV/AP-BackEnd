package com.ABML.ABML.controller;

import com.ABML.ABML.dto.DtoProyecto;
import com.ABML.ABML.model.Proyecto;
import com.ABML.ABML.service.ProyectoService;
import java.util.List;
import com.ABML.ABML.security.controller.Mensaje;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
@CrossOrigin(origins = "https://portfolio-lucas-ap.web.app")
/*@CrossOrigin(origins = "http://localhost:4200")*/
@RequestMapping("/proyecto")
/*@CrossOrigin(origins = {"https://portfolio-lucas-ap.web.app","http://localhost:4200"})*/
public class ProyectoController {
    @Autowired
    ProyectoService proyectoS;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Proyecto>> list() {
        List<Proyecto> list = proyectoS.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyecto> getById(@PathVariable("id") int id){
        if(!proyectoS.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe id"), HttpStatus.BAD_REQUEST);
        }
        
        Proyecto proy = proyectoS.getOne(id).get();
        return new ResponseEntity(proy, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!proyectoS.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe ID"), HttpStatus.NOT_FOUND);
        }
        proyectoS.delete(id);
        return new ResponseEntity(new Mensaje("Proyecto eliminado"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoProyecto dtoProy){
        if(StringUtils.isBlank(dtoProy.getNombre())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);           
        }
        /*if(proyectoS.existsByNombre(dtoProy.getNombre())){
            return new ResponseEntity(new Mensaje("El nombre ya existe"), HttpStatus.BAD_REQUEST);
        }*/
        Proyecto proy = new Proyecto (
            dtoProy.getNombre(), dtoProy.getDescripcion(), dtoProy.getImgproyecto(), dtoProy.getLinkproyecto()
        );
        proyectoS.save(proy);
        return new ResponseEntity(new Mensaje("Proyecto creado"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoProyecto dtoProy){
        if(!proyectoS.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe ID"), HttpStatus.NOT_FOUND);
        }
        /*if(proyectoS.existsByNombre(dtoProy.getNombre()) && proyectoS.getByNombre(dtoProy.getNombre()).get().getId() != id){
            return new ResponseEntity(new Mensaje ("Nombre repetido"), HttpStatus.BAD_REQUEST);
        }*/
        if(StringUtils.isBlank(dtoProy.getNombre())){
            return new ResponseEntity(new Mensaje("El campo está vacío"), HttpStatus.BAD_REQUEST);
        }
        
        Proyecto proy = proyectoS.getOne(id).get();
        
        proy.setNombre(dtoProy.getNombre());
        proy.setDescripcion(dtoProy.getDescripcion());
        proy.setImgproyecto(dtoProy.getImgproyecto());
        proy.setLinkproyecto(dtoProy.getLinkproyecto());
        
        proyectoS.save(proy);
        
        return new ResponseEntity(new Mensaje("Proyecto actualizado"), HttpStatus.OK);
    }
}
