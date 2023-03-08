package com.ABML.ABML.controller;

import com.ABML.ABML.dto.DtoEducacion;
import com.ABML.ABML.model.Educacion;
import com.ABML.ABML.security.controller.Mensaje;
import com.ABML.ABML.service.EducacionService;
import java.util.List;
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
@RequestMapping("/educacion")
/*@CrossOrigin(origins = {"https://portfolio-lucas-ap.web.app","http://localhost:4200"})*/
public class EducacionController {
    @Autowired
    EducacionService sEducacion;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list() {
        List<Educacion> list = sEducacion.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id){
        if(!sEducacion.existsById(id)){
            return new ResponseEntity(new Mensaje ("No existe id"), HttpStatus.BAD_REQUEST);
        }
        
        Educacion edu = sEducacion.getOne(id).get();
        return new ResponseEntity(edu, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sEducacion.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe ID"), HttpStatus.NOT_FOUND);
        }
        sEducacion.delete(id);
        return new ResponseEntity(new Mensaje("Educacion eliminada"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoEducacion dtoEdu){
        if(StringUtils.isBlank(dtoEdu.getNombreE())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);           
        }
        /*if(sEducacion.existsByNombreE(dtoEdu.getNombreE())){
            return new ResponseEntity(new Mensaje("El nombre ya existe"), HttpStatus.BAD_REQUEST);
        }*/
        Educacion edu = new Educacion (
            dtoEdu.getNombreE(), dtoEdu.getDescripcionE(), dtoEdu.getDesde(),dtoEdu.getHasta(),dtoEdu.getImglogo()
        );
        sEducacion.save(edu);
        return new ResponseEntity(new Mensaje("Educación creada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoEducacion dtoEdu){
        if(!sEducacion.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe ID"), HttpStatus.NOT_FOUND);
        }
        /*if(sEducacion.existsByNombreE(dtoEdu.getNombreE()) && sEducacion.getByNombreE(dtoEdu.getNombreE()).get().getId() != id){
            return new ResponseEntity(new Mensaje ("Nombre repetido"), HttpStatus.BAD_REQUEST);
        }*/
        if(StringUtils.isBlank(dtoEdu.getNombreE())){
            return new ResponseEntity(new Mensaje("El campo está vacío"), HttpStatus.BAD_REQUEST);
        }
        
        Educacion edu = sEducacion.getOne(id).get();
        
        edu.setNombreE(dtoEdu.getNombreE());
        edu.setDescripcionE(dtoEdu.getDescripcionE());
        edu.setDesde(dtoEdu.getDesde());
        edu.setHasta(dtoEdu.getHasta());
        edu.setImglogo(dtoEdu.getImglogo());
        
        sEducacion.save(edu);
        
        return new ResponseEntity(new Mensaje("Eduacaion actualizada"), HttpStatus.OK);
    }
}
