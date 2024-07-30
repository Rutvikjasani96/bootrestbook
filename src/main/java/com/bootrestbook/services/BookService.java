package com.bootrestbook.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bootrestbook.dao.BookRepository;
import com.bootrestbook.etities.Book;

@Component
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    // static List<Book> booksList = new ArrayList<>();

    // static {
    //     booksList.add(new Book(1, "Java Learning", "RJ"));
    //     booksList.add(new Book(2, "Python Learning", "Sen"));
    //     booksList.add(new Book(3, "Spring Boot Learning", "Rutvik Jasani"));
    //     booksList.add(new Book(4, "Flutter Learning", "IIT"));
    //     booksList.add(new Book(5, "Dart Learning", "NIT"));
    // }

    // Get All the Books
    public List<Book> getAllBooks() {
        List<Book> allBooks = (List<Book>) bookRepository.findAll();
        return allBooks;
    }

    // Find any one Book by Id
    public Book getBookbyId(int id) {
        Book book = null;
        try {
            // book = booksList.stream().filter(bk -> bk.getId() == id).findFirst().get();
            book = bookRepository.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;
    }

    // Add New Book
    public Book addBook(Book book) {
        // booksList.add(book);
        Book save = bookRepository.save(book);
        return save;
    }

    // Delete Book
    public void deleteBook(int deleteId) {
        // booksList = booksList.stream().filter(book -> book.getId() != deleteId).collect(Collectors.toList());
        bookRepository.deleteById(deleteId);
    }

    // update Book
    public Book updateBook(Book book, int updateId) {
        // booksList = booksList.stream().map(bk -> {
        //     if (bk.getId() == updateId) {
        //         bk = book;
        //     }
        //     return bk;
        // }).collect(Collectors.toList());
        book.setId(updateId);
        Book save = bookRepository.save(book);
        return save;
    }

}
