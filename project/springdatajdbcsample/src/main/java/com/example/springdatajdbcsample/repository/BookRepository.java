package com.example.springdatajdbcsample.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.springdatajdbcsample.entity.Book;

public interface BookRepository extends CrudRepository<Book, Integer>{

}
