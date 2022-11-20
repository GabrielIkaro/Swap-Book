package com.swapp.swapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.swapp.swapp.GoogleBooksAPI.LivroRequest;

@Controller
public class BookController {


    @GetMapping("/newbook")
    public String getRegisterPage(Model model) {
        model.addAttribute("bookRequest", new LivroRequest());
        return "livro_registro";
    }

    @PostMapping("/newbook")
    public String register(@ModelAttribute LivroRequest l){
        l.getBookDetails("157231995X");
        return "livro_registro";
    }
}