package com.swapp.swapp.controller;

import com.swapp.swapp.model.*;
import com.swapp.swapp.service.UsersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UserController {

    @Autowired
    private UsersService usersService;
    
    @GetMapping("/register")
    public String getRegisterPage(Model model) {
        model.addAttribute("registerRequest", new Users());
        return "register_page";
    }

    @GetMapping("/login")
    public String getLoginPage(Model model) {
        model.addAttribute("loginRequest", new Users());
        return "login_page";
    }
    
}
