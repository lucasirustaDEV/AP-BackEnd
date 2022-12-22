/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ABML.ABML.service;

import com.ABML.ABML.model.Experiencia;
import com.ABML.ABML.repository.ExperienciaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ExperienciaService {
    @Autowired
    ExperienciaRepository experienciaR;
    
    public List<Experiencia> list(){
       return experienciaR.findAll();
    }
    
    public Optional<Experiencia> getOne(int id){
        return experienciaR.findById(id);
    }
    
    public Optional<Experiencia> getByNombreE(String nombreE){
        return experienciaR.findByNombreE(nombreE);
    }
    
    public void save(Experiencia expe){
        experienciaR.save(expe);
    }
    
    public void delete(int id){
        experienciaR.deleteById(id);
    }
    
    public boolean existsById(int id){
        return experienciaR.existsById(id);
    }
    
    public boolean existsByNombreE(String nombreE){
        return experienciaR.existsByNombreE(nombreE);
    }
    
    
}
