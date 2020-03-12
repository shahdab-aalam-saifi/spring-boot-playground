package com.saalamsaifi.playground.springboot.rest.controller;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import com.saalamsaifi.playground.springboot.service.OrderService;

@RestController
public class OrderController {
  @Autowired
  private OrderService orderService;

  @GetMapping("/orders")
  public SseEmitter orders() {
    var emitter = new SseEmitter();
    var executor = Executors.newSingleThreadExecutor();
    executor.execute(() -> {
      var orders = orderService.findAll();
      try {
        for (var order : orders) {
          randomDelay();
          var eventBuilder = SseEmitter.event();
          emitter.send(
              eventBuilder.data(order).name("order-created").id(String.valueOf(order.hashCode())));
        }
        emitter.complete();
      } catch (IOException e) {
        emitter.completeWithError(e);
      }
    });
    executor.shutdown();
    return emitter;
  }

  private void randomDelay() {
    try {
      Thread.sleep(ThreadLocalRandom.current().nextInt(150));
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }
}
