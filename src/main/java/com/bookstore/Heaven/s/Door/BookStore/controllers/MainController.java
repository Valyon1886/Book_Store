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

/**
 * Главный класс-контроллер в основном отвечает за межстраничную навигацию
 */

@Controller
public class MainController {

    @Autowired
    private LibratianRepo libratianRepo;

    @Autowired
    private LibrarianInCartRepo librarianInCartRepo;

    /**
     * Отображает домашнюю страницу сайта
     * @param model Шаблон интернет страницы
     * @return home.html Страница домашняя
     */

    @GetMapping("/home")
    public String greeting(Model model) {
        model.addAttribute("title", "Главная страница");
        return "home";
    }

    /**
     * Пасхалка (Why you glory my lord?)
     * @param model Шаблон интернет страницы
     * @return home.html Страница домашняя
     */
    @GetMapping("/home/wygml")                                                                                                   //Why you glory my lord?
    public String lord(Model model) {
        model.addAttribute("title", "Добро пожаловать в Ад");
        return "home";
    }

    /**
     * Отображает список авторов книг
     * @param model Шаблон интернет страницы
     * @return authers.html Страница со всеми авторами книг
     */
    @GetMapping("/authers")
    public String who(Model model) {
        model.addAttribute("title", "Авторы");
        Iterable<Librarian> library = libratianRepo.findAll();
        //ArrayList<String> av = new ArrayList<String>();

        String[] av = new String[] {"Абдул Альхазред", "Пьетро ди Абано", "*не указано*", "Маккензи Бэкон", "Гонориус Фиванский"};

        model.addAttribute("library", av);
        return "authers";
    }

    /**
     * Пасхалка Nani?
     * @param model Шаблон интернет страницы
     * @return nani.html Страница отсылочная
     */

    @GetMapping("/home/nani")
    public String nani(Model model) {
        model.addAttribute("title", "Nani?");
        return "nani";
    }

    /**
     * Экран оповещающий о совершении покупки
     * @param model Шаблон интернет страницы
     * @return Thanks.html Страница с благодарностью
     */

    @GetMapping("/Thanks")
    public String thanks(Model model) {
        model.addAttribute("title", "Спасибо за покупку!");
        return "Thanks";
    }


    /**
     * Функция поиска по каталогу с книгами
     * @param search Поисковое выражение
     * @param model Шаблон интернет страницы
     * @return search.html Страница с результатом поиска
     */

    @RequestMapping("/search")
    public String SearchBook(@RequestParam String search, Model model) {
        model.addAttribute("title", "Результат поиска");
        Iterable<Librarian> library1 = libratianRepo.search(search);
        //Librarian l = new Librarian(6L, "Маккензи Бэкон", "1899", "«По записям безумца» в деталях описывает тексты больного из приюта, который потратил 2 года в палате на то, чтобы заполнить каждый сантиметр огромного дневника своими дикими размышлениями и безумными стихами.", "По записям безумца", 1, "/img/forbooksfront/mad.png");
        //library1.equals(l);
        model.addAttribute("library", library1);
        return "search";
    }

    /**
     * Функция добавления в корзину
     * @param id Идентификатор (Primary key)
     * @param name Наименование книги
     * @param description Описание
     * @param author Имя автора книги
     * @param date Дата написания книги
     * @param number Унифицированый номер
     * @param model Шаблон интернет страницы
     * @return reg.html Страница - авторизации
     */

    @PostMapping("/reg")
    public String AddToCart(@RequestParam Long id, @RequestParam String name,
                            @RequestParam String description, @RequestParam String author,
                            @RequestParam String date, @RequestParam int number, Model model) {
        model.addAttribute("title", "Авторизация");

        Iterable<LibrarianInCart> library = librarianInCartRepo.findAll();
        model.addAttribute("library", library);
        return "reg";
    }


    /**
     * Выводит все книги автора
     * @param author Фамилия/Имя/Отчество/иной_идентификатор автора
     * @param model Шаблон интернет страницы
     * @return book-author.html Страница со всеми книгами автора
     */

    @GetMapping("/authers/{author}")
    public String AllBookOfAuthor(@PathVariable(value = "author") String author, Model model) {
        model.addAttribute("title", author);
        Iterable<Librarian> library1 = libratianRepo.search(author);
        model.addAttribute("library", library1);
        return "book-author";
    }


}
