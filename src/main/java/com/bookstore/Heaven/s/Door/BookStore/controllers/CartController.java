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
public class CartController {
    @Autowired
    private LibratianRepo libratianRepo;
    @Autowired
    private LibrarianInCartRepo librarianInCartRepo;



    @GetMapping("/Cart")
    public String LookingInCart(Model model) {
        model.addAttribute("title", "Корзина");
        Iterable<LibrarianInCart> library = librarianInCartRepo.findAll();
        model.addAttribute("library", library);
        return "Cart";
    }

    @PostMapping("/Cart")
    public String AddToCart(@RequestParam Long id, @RequestParam String name,
                            @RequestParam String description, @RequestParam String author,
                            @RequestParam String date, @RequestParam int number, Model model) {
        model.addAttribute("title", "Корзина");
        if(id == -1){
            librarianInCartRepo.deleteAll();
            Iterable<LibrarianInCart> library = librarianInCartRepo.findAll();
            model.addAttribute("library", library);
        }
        else if(id == -2){
            librarianInCartRepo.deleteAll();
            Iterable<LibrarianInCart> library = librarianInCartRepo.findAll();
            model.addAttribute("library", library);
        }
        else{
            LibrarianInCart book = new LibrarianInCart(id, name, author, description, date, number);
            librarianInCartRepo.save(book);
            Iterable<LibrarianInCart> library = librarianInCartRepo.findAll();
            model.addAttribute("library", library);
        }

        return "Cart";
    }





}
