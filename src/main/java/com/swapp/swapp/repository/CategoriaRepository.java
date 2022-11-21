package com.swapp.swapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swapp.swapp.model.*;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaModel, Integer> {
    
    public boolean existsByNome(String name);
    Optional<CategoriaModel> findByNome(String name);
}
