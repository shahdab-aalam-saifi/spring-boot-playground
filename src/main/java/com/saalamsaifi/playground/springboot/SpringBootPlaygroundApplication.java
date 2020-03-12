package com.saalamsaifi.playground.springboot;

import com.saalamsaifi.playground.springboot.errorhandling.CustomizedErrorAttributes;
import com.saalamsaifi.playground.springboot.model.Book;
import com.saalamsaifi.playground.springboot.model.Calculator;
import com.saalamsaifi.playground.springboot.service.BookService;
import com.saalamsaifi.playground.springboot.service.Operation;
import java.util.Collection;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

@SpringBootApplication
public class SpringBootPlaygroundApplication implements WebMvcConfigurer {
  public static void main(String[] args) {
    SpringApplication.run(SpringBootPlaygroundApplication.class, args);
  }

  // @Bean
  public ApplicationRunner calculationRunner(Calculator calculator) {
    return args -> {
      calculator.calculate(137, 21, '+');
      calculator.calculate(137, 21, '*');
    };
  }

  // @Bean
  public Calculator calulator(Collection<Operation> operations) {
    return new Calculator(operations);
  }

  @Bean
  public CustomizedErrorAttributes errorAttributes() {
    return new CustomizedErrorAttributes();
  }

  //  @Bean
  public ApplicationRunner booksInitializer(BookService bookService) {
    return args -> {
      bookService.create(new Book("9780061120084", "To Kill a Mockingbird", "Harper Lee"));
      bookService.create(new Book("9780451524935", "1984", "George Orwell"));
      bookService.create(new Book("9780618260300", "The Hobbit", "J.R.R. Tolkien"));
    };
  }

  // @Bean
  public LocaleResolver localeResolver() {
    return new AcceptHeaderLocaleResolver();
  }

  @Override
  public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
    WebMvcConfigurer.super.configureAsyncSupport(configurer);
    configurer.setTaskExecutor(mvcTaskExecutor());
  }

  @Bean
  public ThreadPoolTaskExecutor mvcTaskExecutor() {
    ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
    taskExecutor.setThreadNamePrefix("mvc-task-");
    return taskExecutor;
  }
}
