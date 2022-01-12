package com.bookstore.Heaven.s.Door.BookStore.Models;

import com.bookstore.Heaven.s.Door.BookStore.Models.LibrarianInCart;
import com.bookstore.Heaven.s.Door.BookStore.repo.LibrarianInCartRepo;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.List;

/**
 * Таблица - содержит информацию о заказах
 */

@Entity
public class User{

    /**
     *  @param id Идентификатор (Primary key)
     *  @param name Имя/Фамилия/Отчество/Иной идентификатор пользователя
     *  @param phone Мобильный телефон пользователя
     *  @param myLibrary Список (названия) книг купленных пользователем
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name, phone;

    public String myLibrary;

    public User() {

    }

    public User(String name, String phone, String myLibrary) {
        //this.id = id;
        this.name = name;
        this.phone = phone;
        this.myLibrary = myLibrary;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getMyLibrary() {
        return myLibrary;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setMyLibrary(String myLibrary) {
        this.myLibrary = myLibrary;
    }
}
