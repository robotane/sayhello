package com.robotane.sayhello.endpoint.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class HelloController {
  private final HelloService service;

  @GetMapping("/hello")
  public String hello(@RequestParam String name) {
    return service.uploadHelloMessage(name);
  }
}
