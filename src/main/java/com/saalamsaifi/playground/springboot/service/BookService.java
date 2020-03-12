package com.saalamsaifi.playground.springboot.service;

import com.saalamsaifi.playground.springboot.model.Book;
import java.util.Optional;

public interface BookService {
  Iterable<Book> findAll();

  Book create(Book book);

  Optional<Book> find(String isbn);
}
