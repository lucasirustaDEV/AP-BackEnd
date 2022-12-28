package com.ABML.ABML.repository;

import com.ABML.ABML.model.Skill;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SkillRepository extends JpaRepository<Skill, Integer>{
    Optional<Skill> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
    
}
