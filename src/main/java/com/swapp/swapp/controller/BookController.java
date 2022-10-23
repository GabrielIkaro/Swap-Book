package com.swapp.swapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {
    @GetMapping("/newbook")
    public String getNewBookPage() {
        return "newbook_page";
    }
}