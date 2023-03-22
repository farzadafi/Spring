package com.example.restfullwebservice.controller;

import com.example.restfullwebservice.model.HelloWorldBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello-world")
public class HelloWorldController {

    @GetMapping("hello")
    public HelloWorldBean helloWorld() {
        return new HelloWorldBean("hello world");
    }
}
