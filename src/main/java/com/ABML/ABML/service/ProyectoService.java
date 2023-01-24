package com.ABML.ABML.service;

import com.ABML.ABML.model.Proyecto;
import com.ABML.ABML.repository.ProyectoRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProyectoService {
       @Autowired
       ProyectoRepository proyectoR;
       
    public List<Proyecto> list(){
        return proyectoR.findAll();
    }
    
    public Optional<Proyecto> getOne(int id){
        return proyectoR.findById(id);
    }
    
    public Optional<Proyecto> getByNombre(String nombre){
        return proyectoR.findByNombre(nombre);
    }
    
    public void save (Proyecto proy){
        proyectoR.save(proy);
    }
    
    public void delete(int id){
        proyectoR.deleteById(id);
    }
    
    public boolean existsById(int id){
        return proyectoR.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return proyectoR.existsByNombre(nombre);
    }       
    
}
