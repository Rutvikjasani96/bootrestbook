package com.bootrestbook.dao;

import org.springframework.data.repository.CrudRepository;

import com.bootrestbook.etities.Book;

public interface BookRepository extends CrudRepository<Book, Integer>{
    public Book findById(int id);
}
