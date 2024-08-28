package com.pankaj.bookstore.repo;

import com.pankaj.bookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer> {
    List<Book> findByBookNameContainingOrBookDescContaining(String keyword, String keyword1);

    public Book findByBookName(String bookName);
}
