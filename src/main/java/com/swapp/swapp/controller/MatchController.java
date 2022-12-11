package com.swapp.swapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.authentication.UserServiceBeanDefinitionParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.swapp.swapp.model.Match;
import com.swapp.swapp.model.Users;
import com.swapp.swapp.service.MatchService;
import com.swapp.swapp.service.UsersService;

@Controller
public class MatchController {
    
    @Autowired
    MatchService matchService;

    @Autowired
    UsersService usersService;

    @GetMapping("/matchs")
    public String getMatchPage(Model model, HttpServletRequest request) {
        String name = request.getUserPrincipal().getName();
        Users u = usersService.findUser(name);
        model.addAttribute("userDetails", u);

        List<Match> m = matchService.getAll(u);

        model.addAttribute("matchs", m);
        
        return "matchs";
    }
}
