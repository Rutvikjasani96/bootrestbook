package com.bootrestbook.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bootrestbook.etities.Book;
import com.bootrestbook.services.BookService;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;
    
    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks(){
        List<Book> list = bookService.getAllBooks();
        if(list.size()<=0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(list));
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") Integer id){
        Book book = bookService.getBookbyId(id);
        if(book==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(book));
    }


    @PostMapping("/books")
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        Book bk = null;
        try {
            bk = bookService.addBook(book);
            return ResponseEntity.of(Optional.of(bk));
        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/books/{deleteId}")
    public ResponseEntity<Void> deleteBook(@PathVariable("deleteId") Integer deleteId){
        try {
            bookService.deleteBook(deleteId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/books/{updateId}")
    public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable("updateId") Integer updateId){
        try {
            bookService.updateBook(book, updateId);
            return ResponseEntity.of(Optional.of(book));
        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
