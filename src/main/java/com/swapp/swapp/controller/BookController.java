package com.swapp.swapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.swapp.swapp.GoogleBooksAPI.LivroRequest;
import com.swapp.swapp.model.AutorModel;
import com.swapp.swapp.model.Books;
import com.swapp.swapp.model.CategoriaModel;
import com.swapp.swapp.model.EditoraModel;
import com.swapp.swapp.model.LinguaModel;

@Controller
public class BookController {


    @GetMapping("/newbook")
    public String getRegisterPage(Model model) {

        Books b = new Books();
        b.setEditora(new EditoraModel());
        b.setCategoria(new CategoriaModel());
        b.setLingua(new LinguaModel());
        model.addAttribute("book", b);
        return "livro_registro";
    }

    @PostMapping("/newbook")
    public String register(@ModelAttribute Books l, Model model){
        //l.getBookDetails("157231995X");
        System.out.println("oi");
        System.out.println(l.getTitulo());
        System.out.println("autor");
        System.out.println(l.getEditora().getNome());
        model.addAttribute("book", l);

        return "livro_registro";
    }
}