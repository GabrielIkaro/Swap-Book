package com.swapp.swapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swapp.swapp.model.EditoraModel;

@Repository
public interface EditoraRepository extends JpaRepository<EditoraModel, Integer> {
    public boolean existsByNome(String nome);
    Optional<EditoraModel> findTopByNome(String nome);
}
