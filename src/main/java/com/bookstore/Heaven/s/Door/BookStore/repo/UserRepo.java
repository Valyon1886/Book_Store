package com.bookstore.Heaven.s.Door.BookStore.repo;

import com.bookstore.Heaven.s.Door.BookStore.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Long> {
}
