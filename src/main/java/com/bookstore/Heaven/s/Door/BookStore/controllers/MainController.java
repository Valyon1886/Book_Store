package com.bookstore.Heaven.s.Door.BookStore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping("/")
    public String greeting(Model model) {
        model.addAttribute("title", "Главная страница");
        return "home";
    }

    @GetMapping("/wygml")
    public String lord(Model model) {
        model.addAttribute("title", "Добро пожаловать в Ад");
        return "home";
    }

    @GetMapping("/authers")
    public String who(Model model) {
        model.addAttribute("title", "Авторы");
        return "authers";
    }

}
