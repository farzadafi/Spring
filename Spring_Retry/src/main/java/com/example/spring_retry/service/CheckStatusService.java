package com.example.spring_retry.service;

import com.example.spring_retry.exception.TestException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public class CheckStatusService {

    @Retryable(value = TestException.class,maxAttempts = 4,backoff = @Backoff(2000))
    public String checkStatus(){
        System.out.println("This is a try for connect to server! 🥴");
        throw new TestException("this is a test Exception");
    }

    @Recover
    public String recover(){
        return "Oops the server exploded 💥";
    }
}
