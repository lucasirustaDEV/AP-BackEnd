package com.ABML.ABML.service;

import com.ABML.ABML.model.Persona;
import com.ABML.ABML.repository.PersonaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PersonaService {
    @Autowired
    private PersonaRepository personaR;
    
    public List<Persona> list(){
       return personaR.findAll();
    }
    
    public Optional<Persona> getOne(int id){
        return personaR.findById(id);
    }
    
    public Optional<Persona> getByNombre(String nombre){
        return personaR.findByNombre(nombre);
    }
    
    public void save(Persona perso){
        personaR.save(perso);
    }
    
    public void delete(int id){
        personaR.deleteById(id);
    }
    
    public boolean existsById(int id){
        return personaR.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return personaR.existsByNombre(nombre);
    }
        
}
