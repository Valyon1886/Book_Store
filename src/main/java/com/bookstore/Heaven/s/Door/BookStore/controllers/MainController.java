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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    private LibratianRepo libratianRepo;

    @Autowired
    private LibrarianInCartRepo librarianInCartRepo;

    @GetMapping("/home")
    public String greeting(Model model) {
        model.addAttribute("title", "Главная страница");
        return "home";
    }

    @GetMapping("/home/wygml")                                                                                                   //Why you glory my lord?
    public String lord(Model model) {
        model.addAttribute("title", "Добро пожаловать в Ад");
        return "home";
    }

    @GetMapping("/authers")
    public String who(Model model) {
        model.addAttribute("title", "Авторы");
        return "authers";
    }

    @GetMapping("/home/nani")
    public String nani(Model model) {
        model.addAttribute("title", "Nani?");
        return "nani";
    }

    @GetMapping("/Thanks")
    public String thanks(Model model) {
        model.addAttribute("title", "Спасибо за покупку!");
        return "Thanks";
    }

    @RequestMapping("/search")
    public String SearchBook(@RequestParam String search, Model model) {
        model.addAttribute("title", "Результат поиска");
        //List<Customer> result = customerService.search(keyword);
        Iterable<Librarian> library1 = libratianRepo.search(search);
        model.addAttribute("library", library1);
        return "AllBooks";
    }

    @PostMapping("/Thanks")
    public String AddToCart(@RequestParam Long id, @RequestParam String name,
                            @RequestParam String description, @RequestParam String author,
                            @RequestParam String date, @RequestParam int number, Model model) {
        model.addAttribute("title", "Корзина");
        librarianInCartRepo.deleteAll();
        Iterable<LibrarianInCart> library = librarianInCartRepo.findAll();
        model.addAttribute("library", library);

        return "Thanks";
    }
}
