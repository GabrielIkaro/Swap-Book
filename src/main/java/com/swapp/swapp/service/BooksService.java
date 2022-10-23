package com.swapp.swapp.service;

import org.springframework.stereotype.Service;

import com.swapp.swapp.model.Books;
import com.swapp.swapp.repository.BooksRepository;

@Service
public class BooksService{

    private final BooksRepository books_repository;

    public BooksService(BooksRepository books_repository){
        this.books_repository = books_repository;
    }

    public Books registerBook(String titulo, String autor, String isbn){
        if(titulo != null && autor != null){
            Books book = new Books();
            book.setTitulo(titulo);
            book.setAutor(autor);
            book.setISBN(isbn);
            return books_repository.save(book);
        }else{
            return null;
        }
    }   
}
