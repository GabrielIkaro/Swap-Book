package com.swapp.swapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swapp.swapp.model.AutorModel;

@Repository
public interface AutorRepository extends JpaRepository<AutorModel, Integer>{
    public boolean existsByNome(String nome);
    Optional<AutorModel> findByNome(String nome);
}
