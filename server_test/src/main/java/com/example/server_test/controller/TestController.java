package com.example.server_test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/test")
public class TestController {

    @GetMapping("/get-test")
    public String test() {
        "this is a test String from 8085 server"
    }
}
