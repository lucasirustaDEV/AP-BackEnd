package com.ABML.ABML.service;

import com.ABML.ABML.model.Skill;
import com.ABML.ABML.repository.SkillRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class SkillService {
    @Autowired
    SkillRepository rSkill;
    public List<Skill> list() {
        return rSkill.findAll();
    }
    
    public Optional<Skill> getOne(int id){
        return rSkill.findById(id);
    }
    
    public Optional<Skill> getByNombre(String nombre){
        return rSkill.findByNombre(nombre);
    }
    
    public void save(Skill skill){
        rSkill.save(skill);
    }
    
    public void delete(int id){
        rSkill.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rSkill.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return rSkill.existsByNombre(nombre);
    }
}
