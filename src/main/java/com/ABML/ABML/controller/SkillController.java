package com.ABML.ABML.controller;

import com.ABML.ABML.dto.DtoSkill;
import com.ABML.ABML.model.Skill;
import com.ABML.ABML.security.controller.Mensaje;
import com.ABML.ABML.service.SkillService;
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
/*@CrossOrigin(origins = {"https://portfolio-lucas-ap.web.app","http://localhost:4200"})*/
/*@CrossOrigin(origins = "https://portfolio-lucas-ap.web.app")*/
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/skill")
public class SkillController {
    @Autowired
    SkillService skillS;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Skill>> list(){
        List<Skill> list = skillS.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoSkill dtoskill){
        if(StringUtils.isBlank(dtoskill.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if (skillS.existsByNombre(dtoskill.getNombre()))
            return new ResponseEntity(new Mensaje("Esa habilidad existe"), HttpStatus.BAD_REQUEST);
        
        Skill skill = new Skill(dtoskill.getNombre(), dtoskill.getPorcentaje());
        skillS.save(skill);
        
        return new ResponseEntity(new Mensaje("Habilidad agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoSkill dtoskill){
        if(!skillS.existsById(id))
            return new ResponseEntity(new Mensaje ("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        if(skillS.existsByNombre(dtoskill.getNombre()) && skillS.getByNombre(dtoskill.getNombre()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa habilidad ya existe"), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(dtoskill.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Skill skill = skillS.getOne(id).get();
        skill.setNombre(dtoskill.getNombre());
        skill.setPorcentaje(dtoskill.getPorcentaje());
        
        skillS.save(skill);
        return new ResponseEntity(new Mensaje("Habilidad actualizada"), HttpStatus.OK);        
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!skillS.existsById(id)){
            return new ResponseEntity(new Mensaje ("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        skillS.delete(id);       
        return new ResponseEntity(new Mensaje("Habilidad eliminada"), HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Skill> getById(@PathVariable("id") int id){
        if(!skillS.existsById(id))
            return new ResponseEntity(new Mensaje("No existen skills"), HttpStatus.NOT_FOUND);
        Skill skill = skillS.getOne(id).get();
        return new ResponseEntity(skill, HttpStatus.OK);
    }

}
