package com.ABML.ABML.service;

import com.ABML.ABML.model.Educacion;
import com.ABML.ABML.repository.EducacionRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EducacionService {
    @Autowired
    EducacionRepository rEducacion;
    
    public List<Educacion> list(){
        return rEducacion.findAll(Sort.by(Sort.Direction.DESC, "hasta"));
    }
    
    public Optional<Educacion> getOne(int id){
        return rEducacion.findById(id);
    }
    
    public Optional<Educacion> getByNombreE(String nombreE){
        return rEducacion.findByNombreE(nombreE);
    }
    
    public void save (Educacion educ){
        rEducacion.save(educ);
    }
    
    public void delete(int id){
        rEducacion.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rEducacion.existsById(id);
    }
    
    public boolean existsByNombreE(String nombreE){
        return rEducacion.existsByNombreE(nombreE);
    }
}
