package com.swapp.swapp.repository;

import com.swapp.swapp.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LinguaRepository extends JpaRepository<LinguaModel, Integer> {
    
    public boolean existsByNome(String nome);
    Optional<LinguaModel> findByNome(String nome);
}
