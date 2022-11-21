package com.swapp.swapp.service;

import java.time.Year;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.swapp.swapp.model.Books;
import com.swapp.swapp.model.CategoriaModel;
import com.swapp.swapp.model.EditoraModel;
import com.swapp.swapp.model.LinguaModel;
import com.swapp.swapp.model.Users;
import com.swapp.swapp.repository.BooksRepository;

@Service
public class BooksService{

    private final BooksRepository books_repository;

    public BooksService(BooksRepository books_repository){
        this.books_repository = books_repository;
    }

/*     public Books fillBook(String titulo, String publicacao, String editora, String lingua, String categoria, String isbn){
        Books book = new Books();

        LinguaService l = new LinguaService(null);
        book.setLingua(l.LinguaFactory(lingua));
        book.setTitulo(titulo);
        book.setIsbn(publicacao);

        return book;
    } */

    public Books registerBook(Users user, String titulo, String isbn, Date publicacao, String lingua, String categoria,
                                String editora){
        if(titulo != null && publicacao != null && lingua != null){
            Books book = new Books();

            LinguaService l = new LinguaService(null);
            LinguaModel lin = l.LinguaFactory(lingua);

            lin.setBookslist(List.of(book));
            book.setLingua(lin);


            CategoriaService cat = new CategoriaService(null);
            CategoriaModel c = cat.CategoriaFactory(categoria);

            c.setBookslist(List.of(book));
            book.setCategoria(c);


            EditoraService edi = new EditoraService(null);
            EditoraModel e = edi.EditoraFactory(editora);

            e.setBookslist(List.of(book));
            book.setEditora(e);

            user.setBookslist(List.of(book));
            book.setUser(user);

            book.setTitulo(titulo);
            book.setPublicacao(publicacao);
            book.setIsbn(isbn);
            return books_repository.save(book);
        }else{
            return null;
        }
    }   
}
