package com.saalamsaifi.playground.springboot.rest.controller;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
  @Autowired private TaskExecutor taskExecutor;

  @GetMapping("/hello")
  public CompletableFuture<String> hello() {
    return CompletableFuture.supplyAsync(
        () -> {
          randomDelay();
          return "Hello World";
        },
        taskExecutor);
  }

  private void randomDelay() {
    try {
      Thread.sleep(ThreadLocalRandom.current().nextInt(5000));
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }
}
