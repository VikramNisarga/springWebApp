package com.vikram.spring.springWebApp.repository;

import org.springframework.data.repository.CrudRepository;

import com.vikram.spring.springWebApp.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}
