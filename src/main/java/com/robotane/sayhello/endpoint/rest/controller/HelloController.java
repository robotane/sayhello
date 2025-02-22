package com.robotane.sayhello.endpoint.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  @GetMapping("/hello")
  public String helloWorld() {
    return "Hey! Hello!";
  }
}
