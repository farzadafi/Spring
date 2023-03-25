package com.example.restfullwebservice.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionController {

    @GetMapping("/v1/person")
    public PersonV1 getPersonV1() {
        return new PersonV1("Farzad Afshar");
    }
}
