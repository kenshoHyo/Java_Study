package com.example.springdatajdbcsample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.springdatajdbcsample.entity.Book;
import com.example.springdatajdbcsample.repository.BookRepository;

@SpringBootApplication
public class SpringdatajdbcsampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringdatajdbcsampleApplication.class, args)
		.getBean(SpringdatajdbcsampleApplication.class).execute();
	}

	@Autowired
	BookRepository repository;

	private void execute(){
		executeInsert();
		executeSelect();
	}

	private void executeInsert(){
		Book book = new Book(2, "本3");
		book = repository.save(book);
		System.out.println("登録したデータ："+ book);
	}

	private void executeSelect(){
		Iterable<Book> books = repository.findAll();
		for(Book book_list : books){
			System.out.println(book_list);
		}
	}
}
