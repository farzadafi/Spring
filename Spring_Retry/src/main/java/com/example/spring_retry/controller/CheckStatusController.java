package com.example.spring_retry.controller;

import com.example.spring_retry.service.CheckStatusService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/checkStatus")
@AllArgsConstructor
public class CheckStatusController {

    private CheckStatusService checkStatusService;

    @GetMapping("/test")
    public String checkStatus(){
        return checkStatusService.checkStatus();
    }
}
