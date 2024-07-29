package com.bootrestbook.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bootrestbook.etities.Book;

@Component
public class BookService {
    static List<Book> booksList = new ArrayList<>();
    private Book book;

    static{
        booksList.add(new Book(1,"Java Learning","RJ"));
        booksList.add(new Book(2,"Python Learning","Sen"));
        booksList.add(new Book(3,"Spring Boot Learning","Rutvik Jasani"));
        booksList.add(new Book(4,"Flutter Learning","IIT"));
        booksList.add(new Book(5,"Dart Learning","NIT"));
    }

    // Get All the Books
    public List<Book> getAllBooks(){
        return booksList;
    }

    // Find any one Book by Id
    public Book getBookbyId(int id){
        Book book = booksList.stream().filter(bk->bk.getId()==id).findFirst().get();
        return book;
    }
    
}
