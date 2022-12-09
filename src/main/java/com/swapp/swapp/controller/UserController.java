package com.swapp.swapp.controller;

import com.swapp.swapp.model.*;
import com.swapp.swapp.service.UsersService;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class UserController {

    @Autowired
    private UsersService usersService;
    
    @GetMapping("/register")
    public String getRegisterPage(Model model) {
        if (!model.containsAttribute("user")){
            model.addAttribute("user", new Users());
        }
        return "register_page";
    }

    @GetMapping("/login")
    public String getLoginPage(Model model) {
        model.addAttribute("loginRequest", new Users());
        return "login_page";
    }

    @PostMapping("/register")
    public String register(@Valid Users user, BindingResult result, Model model, RedirectAttributes redirectAttributes){
        String err = usersService.createUser(user);
        if(!err.isEmpty()){
            ObjectError error = new ObjectError("globalError", err);
            result.addError(error);
        }
        if (result.hasErrors()){
            //redirectAttributes.addFlashAttribute("userEmail", user.getEmail());
            redirectAttributes.addFlashAttribute("user", user);
            redirectAttributes.addFlashAttribute("globalError", err);
            //redirectAttributes.addFlashAttribute(result);
            return "redirect:register";
        }
        return "redirect:login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute Users user, Model model){
        Users authenticateduser = usersService.authenticate(user.getLogin(), user.getPassword());

        if(authenticateduser != null){
            return "redirect:perfil";
        }else{
            return "error_page";
        }
    }
    
}
