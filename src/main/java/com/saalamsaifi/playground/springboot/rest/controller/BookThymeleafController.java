package com.saalamsaifi.playground.springboot.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.saalamsaifi.playground.springboot.service.BookService;

@Controller
public class BookThymeleafController {
	@Autowired
	private BookService bookService;

	@GetMapping("/books.html")
	public String all(Model model) {
		model.addAttribute("books", bookService.findAll());
		return "books/list";
	}

	@GetMapping(value = "/books.html", params = "isbn")
	public String get(@RequestParam("isbn") String isbn, Model model) {
		bookService.find(isbn).ifPresent(book -> model.addAttribute("book", book));
		return "books/details";
	}

	@GetMapping("/books/500")
	public void error() {
		throw new NullPointerException("Dummy NullPointerException.");
	}
	
	@GetMapping("/books/404")
	public ResponseEntity<Object> notFound() {
		return ResponseEntity.notFound().build();
	}

}
