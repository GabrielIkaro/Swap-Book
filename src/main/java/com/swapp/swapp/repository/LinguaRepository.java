package com.swapp.swapp.repository;

import com.swapp.swapp.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LinguaRepository extends JpaRepository<LinguaModel, Integer> {
    
    public boolean existsByNome(String nome);
    Optional<LinguaModel> findTopByNome(String nome);

    @Query(value = "SELECT DISTINCT p.nome FROM LINGUA_TABLE p WHERE p.nome LIKE %:term% ORDER BY p.nome ASC", nativeQuery = true)
    List<String> findAllNomesByTerm(@Param("term") String term);
}
