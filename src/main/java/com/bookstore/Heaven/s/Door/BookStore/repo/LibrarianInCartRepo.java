package com.bookstore.Heaven.s.Door.BookStore.repo;

import com.bookstore.Heaven.s.Door.BookStore.Models.Librarian;
import com.bookstore.Heaven.s.Door.BookStore.Models.LibrarianInCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface LibrarianInCartRepo extends JpaRepository<LibrarianInCart, Long> {

}
