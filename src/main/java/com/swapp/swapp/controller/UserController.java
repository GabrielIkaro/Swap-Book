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

    @PostMapping("/register")
    public String register(@ModelAttribute Users user){
        System.out.println("register request:" + user);
        Users registereduser = usersService.registerUser(user.getLogin(), user.getPassword(), user.getEmail());
        if(registereduser == null){
            return "./";
        }else{
            return "redirect:login";
        }
    }

    @PostMapping("/login")
    public String login(@ModelAttribute Users user, Model model){
        Users authenticateduser = usersService.authenticate(user.getLogin(), user.getPassword());

        if(authenticateduser != null){
            return "redirect:newbook";
        }else{
            return "error_page";
        }
    }
    
}
