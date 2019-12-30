package com.saalamsaifi.playground.springboot;

import java.util.Collection;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.saalamsaifi.playground.springboot.model.Book;
import com.saalamsaifi.playground.springboot.model.Calculator;
import com.saalamsaifi.playground.springboot.service.BookService;
import com.saalamsaifi.playground.springboot.service.Operation;

@SpringBootApplication
public class SpringBootPlaygroundApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootPlaygroundApplication.class, args);
	}

	@Bean
	public ApplicationRunner calculationRunner(Calculator calculator) {
		return args -> {
			calculator.calculate(137, 21, '+');
			calculator.calculate(137, 21, '*');
		};
	}

	@Bean
	public Calculator calulator(Collection<Operation> operations) {
		return new Calculator(operations);
	}

	@Bean
	public ApplicationRunner booksInitializer(BookService bookService) {
		return args -> {
			bookService.create(new Book("9780061120084", "To Kill a Mockingbird", "Harper Lee"));
			bookService.create(new Book("9780451524935", "1984", "George Orwell"));
			bookService.create(new Book("9780618260300", "The Hobbit", "J.R.R. Tolkien"));
		};
	}

}
