package com.swapp.swapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.swapp.swapp.GoogleBooksAPI.LivroRequest;
import com.swapp.swapp.model.AutorModel;
import com.swapp.swapp.model.Books;
import com.swapp.swapp.model.CategoriaModel;
import com.swapp.swapp.model.EditoraModel;
import com.swapp.swapp.model.LinguaModel;
import com.swapp.swapp.service.BooksService;

@Controller
public class BookController {

    @Autowired
    BooksService s;

    @GetMapping("/newbook")
    public String getRegisterPage(Model model) {
        Books b = new Books();
        b.setEditora(new EditoraModel());
        b.setCategoria(new CategoriaModel());
        b.setLingua(new LinguaModel());
        b.setAutor(new AutorModel());
        model.addAttribute("book", b);
        return "livro_registro";
    }

    @PostMapping("/newbook")
    public String register(@ModelAttribute Books l, Model model, @RequestParam("action") String action){
        if (action.equals("search_isbn")){
            Books b = s.findByIsbn(l.getIsbn());
            model.addAttribute("book", b);
            return "livro_registro";
        }

        //l.getBookDetails("157231995X");
        model.addAttribute("book", l);

        return "livro_registro";
    }
}