package com.swapp.swapp.controller;

import org.apache.catalina.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PerfilController {

    @GetMapping("/perfil")
    public String getRegisterPage(Model model) {
        model.addAttribute("userDetails", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return "perfil";
    }

}
