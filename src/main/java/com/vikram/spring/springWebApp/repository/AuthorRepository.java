package com.vikram.spring.springWebApp.repository;

import org.springframework.data.repository.CrudRepository;

import com.vikram.spring.springWebApp.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long>{

}
