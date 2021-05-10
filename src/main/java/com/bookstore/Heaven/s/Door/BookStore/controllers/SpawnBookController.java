package com.bookstore.Heaven.s.Door.BookStore.controllers;

import com.bookstore.Heaven.s.Door.BookStore.Models.Librarian;
import com.bookstore.Heaven.s.Door.BookStore.Models.LibrarianInCart;
import com.bookstore.Heaven.s.Door.BookStore.repo.LibrarianInCartRepo;
import com.bookstore.Heaven.s.Door.BookStore.repo.LibratianRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class SpawnBookController {

    @Autowired
    private LibratianRepo  libratianRepo;


    @GetMapping("/books")
    public String SpawnBook(Model model) {
        model.addAttribute("title", "Список книг");
        Iterable<Librarian> library = libratianRepo.findAll();
        model.addAttribute("library", library);
        return "AllBooks";
    }


}
