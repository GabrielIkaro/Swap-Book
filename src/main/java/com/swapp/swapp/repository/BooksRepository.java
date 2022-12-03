package com.swapp.swapp.repository;

import com.swapp.swapp.model.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BooksRepository extends JpaRepository<Books, Integer>{
    
    Optional<Books> findByTitulo(String titulo);

    Optional<Books> findByCategoria(String categoria);

    Page<Books> findAllByUser(Users user, Pageable pageable);
}
