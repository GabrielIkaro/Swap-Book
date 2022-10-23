package com.swapp.swapp.repository;

import com.swapp.swapp.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BooksRepository extends JpaRepository<Books, Integer>{
    
    Optional<Books> findByTituloAndAutor(String titulo, String autor);
}
