package com.example.restfullwebservice.controller;

import com.example.restfullwebservice.model.HelloWorldBean;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequestMapping("/hello-world")
public class HelloWorldController {

    private final MessageSource messageSource;

    public HelloWorldController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping("hello")
    public HelloWorldBean helloWorld() {
        return new HelloWorldBean("hello world");
    }

    @GetMapping("good-morning")
    public HelloWorldBean goodMorning() {
        Locale locale = LocaleContextHolder.getLocale();
        String message = messageSource.getMessage("good.morning.message", null, "Default Message", locale);
        return new HelloWorldBean(message);
    }
}
