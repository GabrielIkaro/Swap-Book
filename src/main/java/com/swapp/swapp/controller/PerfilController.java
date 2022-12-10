package com.swapp.swapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.swapp.swapp.model.Users;
import com.swapp.swapp.service.BooksService;
import com.swapp.swapp.service.UsersService;

@Controller
public class PerfilController {

    @Autowired
    UsersService usersService;

    @Autowired
    BooksService booksService;

    @GetMapping("/user")
    public String getUserProfile(Model model,  HttpServletRequest request){
        String name = request.getUserPrincipal().getName();
        Users u = usersService.findUser(name);
        model.addAttribute("books", u.getBookslist());
        model.addAttribute("userDetails", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        model.addAttribute("booksquantity", u.getBookNumbers());
        return "user";
    }

    @GetMapping("/geo")
    public String getGeoPage(Model model, HttpServletRequest request){
        String name = request.getUserPrincipal().getName();
        Users u = usersService.findUser(name);
        if (u.getZip() == null){
            model.addAttribute("zipcode", "Você não possui uma localização ainda, insira abaixo.");

        }else{
            model.addAttribute("zipcode", "Sua localização atual é: " + u.getZip());
        }
        model.addAttribute("userDetails", u);
        return "geolocation";
    }

    @PostMapping("/geo")
    public String getLocation(Model model, @RequestParam("zip") String zip, HttpServletRequest request){
        String name = request.getUserPrincipal().getName();
        Users u = usersService.findUser(name);
        u = usersService.setLocation(u, zip);

        if (u != null){
            System.out.println("Latitude: " + u.getLat());
            System.out.println("Longitude: " + u.getLongi());
        }

        if (u.getZip() == null){
            model.addAttribute("zipcode", "Você não possui uma localização ainda, insira abaixo.");

        }else{
            model.addAttribute("zipcode", "Sua localização atual é: " + u.getZip());
        }

        model.addAttribute("userDetails", u);
        model.addAttribute("oi", zip);

        return "geolocation";
    }

    @GetMapping("/edit")
    public String getEditionPage(Model model, HttpServletRequest request){
        String name = request.getUserPrincipal().getName();
        Users u = usersService.findUser(name);
        model.addAttribute("userDetails", u);
        return "user_edit";
    }

    @PostMapping("/edit")
    public String getEdition(Model model, @RequestParam("username") String username, @RequestParam("email") String email, @RequestParam("password") String pswd, @RequestParam("max_dis") String max_dis, HttpServletRequest request){
        String name = request.getUserPrincipal().getName();
        Users u = usersService.findUser(name);

        u.setLogin(username);
        u.setEmail(email);
        u.setPassword(pswd);
        u.setMax_dis(Double.parseDouble(max_dis));

        model.addAttribute("userDetails", u);
        
        return "user_edit";
    }
}
