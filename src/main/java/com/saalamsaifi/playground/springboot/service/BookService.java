package com.saalamsaifi.playground.springboot.service;

import java.util.Optional;

import com.saalamsaifi.playground.springboot.model.Book;

public interface BookService {
	Iterable<Book> findAll();

	Book create(Book book);

	Optional<Book> find(String isbn);
}
