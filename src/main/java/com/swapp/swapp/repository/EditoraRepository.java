package com.swapp.swapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swapp.swapp.model.EditoraModel;

public interface EditoraRepository extends JpaRepository<EditoraModel, Integer> {
    public boolean existsByNome(String nome);
    Optional<EditoraModel> findByNome(String nome);
}
