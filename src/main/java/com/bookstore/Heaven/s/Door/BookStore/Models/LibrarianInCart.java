package com.bookstore.Heaven.s.Door.BookStore.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LibrarianInCart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name, author, description;
    private String date;

    public LibrarianInCart() {
    }

    public LibrarianInCart(Long id, String name, String author, String description, String date, int number) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.description = description;
        this.date = date;
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    private int number;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }





}
