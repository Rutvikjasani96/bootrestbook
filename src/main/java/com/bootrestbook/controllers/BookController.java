package com.bootrestbook.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bootrestbook.etities.Book;
import com.bootrestbook.services.BookService;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;
    
    @GetMapping("/books")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable("id") Integer id){
        return bookService.getBookbyId(id);
    }
}
