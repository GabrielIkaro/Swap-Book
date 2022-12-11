package com.swapp.swapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.swapp.swapp.model.*;
import com.swapp.swapp.service.BooksService;
import com.swapp.swapp.service.SwipeService;
import com.swapp.swapp.service.UsersService;

@Controller
public class mainPage {

    @Autowired
    UsersService usersService;

    @Autowired
    BooksService booksService;

    @Autowired
    SwipeService swipeService;

    @GetMapping("/perfil")
    public String getRegisterPage(Model model, HttpServletRequest request) {
        model.addAttribute("userDetails", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        String name = request.getUserPrincipal().getName();
        Users u = usersService.findUser(name);
        if (u.getZip() == null){
            Books bo = new Books();
            bo.setEditora(new EditoraModel());
            bo.setCategoria(new CategoriaModel());
            bo.setLingua(new LinguaModel());
            bo.setAutor(new AutorModel());
            model.addAttribute("livro", bo);
            return "perfil";
        }

        List<Books> c = booksService.findClo(u);
        if(!c.isEmpty()){
            Books b = c.get(0);
            model.addAttribute("livro", b);
         }else{
            Books bo = new Books();
            bo.setEditora(new EditoraModel());
            bo.setCategoria(new CategoriaModel());
            bo.setLingua(new LinguaModel());
            bo.setAutor(new AutorModel());
            model.addAttribute("livro", bo);
        }
        return "perfil";
    }

    @PostMapping("/reaction")
    public String getReaction(Model model, HttpServletRequest request, @RequestParam("bookID") String bookID, @RequestParam("action") String action){
        
        if (bookID.equals("")){
            return getRegisterPage(model, request);
        }

        int temp = Integer.parseInt(bookID);
        Books b = booksService.findById(temp);

        String name = request.getUserPrincipal().getName();
        Users u = usersService.findUser(name);

        if (action.equals("like")){
            swipeService.saveSwipe(b, u, true);;
        }
        if(action.equals("dislike")){
            swipeService.saveSwipe(b, u, false);
        }

        return getRegisterPage(model, request);
    }
    
}
