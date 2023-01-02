package com.ABML.ABML.controller;

import com.ABML.ABML.dto.DtoPersona;
import com.ABML.ABML.model.Persona;
import com.ABML.ABML.security.controller.Mensaje;
import com.ABML.ABML.service.PersonaService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personas")
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {
    @Autowired
    PersonaService personaS;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list() {
        List<Persona> list = personaS.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id){
        if(!personaS.existsById(id)){
            return new ResponseEntity(new Mensaje ("No existe id"), HttpStatus.BAD_REQUEST);
        }
        
        Persona perso = personaS.getOne(id).get();
        return new ResponseEntity(perso, HttpStatus.OK);
    }
    
    /*@DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!personaS.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe ID"), HttpStatus.NOT_FOUND);
        }
        personaS.delete(id);
        return new ResponseEntity(new Mensaje("Persona eliminada"), HttpStatus.OK);
    }*/
    
    /*@PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoPersona dtoPerso){
        if(StringUtils.isBlank(dtoPerso.getNombre())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);           
        }
        if(personaS.existsByNombre(dtoPerso.getNombre())){
            return new ResponseEntity(new Mensaje("El nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        Persona perso = new Persona (
            dtoPerso.getNombre(), dtoPerso.getDescripcion()
        );
        personaS.save(perso);
        return new ResponseEntity(new Mensaje("Persona creada"), HttpStatus.OK);
    }*/
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoPersona dtoPerso){
        if(!personaS.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe ID"), HttpStatus.NOT_FOUND);
        }
        if(personaS.existsByNombre(dtoPerso.getNombre()) && personaS.getByNombre(dtoPerso.getNombre()).get().getId() != id){
            return new ResponseEntity(new Mensaje ("Nombre repetido"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoPerso.getNombre())){
            return new ResponseEntity(new Mensaje("El campo está vacío"), HttpStatus.BAD_REQUEST);
        }
        
        /*VERIFICAR TODOS LOS CAMPOS*/
        
        Persona perso = personaS.getOne(id).get();
        
        perso.setNombre(dtoPerso.getNombre());
        perso.setApellido(dtoPerso.getApellido());
        perso.setEdad(dtoPerso.getEdad());
        perso.setAcerca(dtoPerso.getAcerca());
        perso.setImgperfil(dtoPerso.getAcerca());
        
        personaS.save(perso);
        
        return new ResponseEntity(new Mensaje("Persona actualizada"), HttpStatus.OK);
    }
}
