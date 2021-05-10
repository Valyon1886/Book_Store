package com.bookstore.Heaven.s.Door.BookStore.repo;

import java.util.List;

import com.bookstore.Heaven.s.Door.BookStore.Models.Librarian;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface LibratianRepo extends CrudRepository<Librarian, Long>{
    @Query(value = "SELECT c FROM Librarian c " +
            "WHERE c.name = :keyword" +
            " OR c.author = :keyword" +
            " OR c.description = :keyword")
    public Iterable<Librarian> search(String keyword);
}
