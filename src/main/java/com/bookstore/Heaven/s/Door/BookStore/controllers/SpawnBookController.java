package com.bookstore.Heaven.s.Door.BookStore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SpawnBookController {
    @GetMapping("/books")
    public String SpawnBook(Model model) {
        model.addAttribute("title", "Бестселлеры");
        return "AllBooks";
    }
}
