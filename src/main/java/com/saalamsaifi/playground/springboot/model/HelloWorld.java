package com.saalamsaifi.playground.springboot.model;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class HelloWorld {
	@PostConstruct
	public void sayHello() {
		System.out.println("@PostConstruct::Hello, World!");

	}

	@PreDestroy
	public void sayBye() {
		System.out.println("@PreDestroy::Bye, World!");
	}

}
