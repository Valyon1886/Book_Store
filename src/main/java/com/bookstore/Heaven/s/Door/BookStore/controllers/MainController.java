package com.bookstore.Heaven.s.Door.BookStore.controllers;

import com.bookstore.Heaven.s.Door.BookStore.Models.Librarian;
import com.bookstore.Heaven.s.Door.BookStore.Models.LibrarianInCart;
import com.bookstore.Heaven.s.Door.BookStore.repo.LibrarianInCartRepo;
import com.bookstore.Heaven.s.Door.BookStore.repo.LibratianRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;
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
        Iterable<Librarian> library = libratianRepo.findAll();
        //ArrayList<String> av = new ArrayList<String>();

        String[] av = new String[] {"Абдул Альхазред", "Пьетро ди Абано", "*не указано*", "Маккензи Бэкон", "Гонориус Фиванский"};

        model.addAttribute("library", av);
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
        Iterable<Librarian> library1 = libratianRepo.search(search);
        Librarian l = new Librarian(6L, "Маккензи Бэкон", "1899", "«По записям безумца» в деталях описывает тексты больного из приюта, который потратил 2 года в палате на то, чтобы заполнить каждый сантиметр огромного дневника своими дикими размышлениями и безумными стихами.", "По записям безумца", 1, "/img/forbooksfront/mad.png");
        library1.equals(l);
        model.addAttribute("library", library1);
        return "search";
    }

    @PostMapping("/reg")
    public String AddToCart(@RequestParam Long id, @RequestParam String name,
                            @RequestParam String description, @RequestParam String author,
                            @RequestParam String date, @RequestParam int number, Model model) {
        model.addAttribute("title", "Корзина");

        Iterable<LibrarianInCart> library = librarianInCartRepo.findAll();
        model.addAttribute("library", library);
        return "reg";
    }



    @GetMapping("/authers/{author}")
    public String AllBookOfAuthor(@PathVariable(value = "author") String author, Model model) {
        model.addAttribute("title", author);
        Iterable<Librarian> library1 = libratianRepo.search(author);
        model.addAttribute("library", library1);
        return "book-author";
    }


}
