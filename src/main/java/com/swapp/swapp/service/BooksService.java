package com.swapp.swapp.service;

import java.time.Year;

import org.springframework.stereotype.Service;

import com.swapp.swapp.model.Books;
import com.swapp.swapp.repository.BooksRepository;

@Service
public class BooksService{

    private final BooksRepository books_repository;

    public BooksService(BooksRepository books_repository){
        this.books_repository = books_repository;
    }

    public Books registerBook(String titulo, String isbn, Year publicacao){
        if(titulo != null && publicacao != null){
            Books book = new Books();
            book.setTitulo(titulo);
            book.setPublicacao(publicacao);
            book.setIsbn(isbn);
            return books_repository.save(book);
        }else{
            return null;
        }
    }   
}
