package com.swapp.swapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.swapp.swapp.GoogleBooksAPI.GeolocationAPI;
import com.fasterxml.jackson.databind.JsonNode;
import com.swapp.swapp.model.Users;
import com.swapp.swapp.service.UsersService;

@Controller
public class PerfilController {

    @Autowired
    UsersService usersService;

    @GetMapping("/perfil")
    public String getRegisterPage(Model model) {
        model.addAttribute("userDetails", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return "perfil";
    }

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
    public String getLocation(Model model, @RequestParam("oi") String oi, HttpServletRequest request){
        String name = request.getUserPrincipal().getName();
        Users u = usersService.findUser(name);
        u = usersService.setLocation(u, oi);

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
        model.addAttribute("oi", oi);

        return "geolocation";
    }

}
