package com.swapp.swapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.swapp.swapp.model.EditoraModel;

@Repository
public interface EditoraRepository extends JpaRepository<EditoraModel, Integer> {
    public boolean existsByNome(String nome);
    Optional<EditoraModel> findTopByNome(String nome);

    @Query(value = "SELECT DISTINCT p.nome FROM EDITORA_TABLE p WHERE p.nome LIKE %:term% ORDER BY p.nome ASC", nativeQuery = true)
    List<String> findAllNomesByTerm(@Param("term") String term);
}
