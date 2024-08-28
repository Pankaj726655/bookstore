package com.pankaj.bookstore.controller;

import com.pankaj.bookstore.model.Book;
import com.pankaj.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class HomeController {

    @Autowired
    private BookService bookService;

    @GetMapping(path = "books", produces = "application/json")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @PostMapping("load")
    public String load(){
        return bookService.load();
    }

    @GetMapping(path = "book/{bookId}")
    public Book getBook(@PathVariable("bookId") int bookId){
        return bookService.getBook(bookId);
    }

    @PostMapping(path = "book")
    public Book addBook(@RequestBody Book book){
        bookService.addBook(book);
        return bookService.getBook(book.getBookId());
    }

    @DeleteMapping(path = "book/{bookId}")
    public String deleteBook(@PathVariable("bookId") int bookId){
        bookService.deleteBook(bookId);
        return "Deleted!";
    }

    @GetMapping(path = "book/keyword/{keyword}")
    public List<Book> searchBook(@PathVariable String keyword){
        return bookService.search(keyword);
    }

    @PostMapping(path = "book/sell/{bookName}")
    public void sellBook(@PathVariable("bookName") String bookName){
        bookService.sellBook(bookName);
    }
}
