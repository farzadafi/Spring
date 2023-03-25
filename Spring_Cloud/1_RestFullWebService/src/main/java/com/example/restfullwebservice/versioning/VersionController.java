package com.example.restfullwebservice.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionController {

    //based on url
    @GetMapping("/v1/person")
    public PersonV1 getPersonV1BasedOnUrl() {
        return new PersonV1("Farzad Afshar");
    }

    @GetMapping("/v1/person")
    public PersonV2 getPersonV2BasedOnUrl() {
        return new PersonV2("Farzad", "Afshar");
    }

    //****
    //based on Request param
    @GetMapping(path = "/person", params = "version=1")
    public PersonV1 getPersonV1BasedOnRequestParam() {
        return new PersonV1("Farzad Afshar");
    }

    @GetMapping(path = "/person", params = "version=2")
    public PersonV2 getPersonV2BasedOnRequestParam() {
        return new PersonV2("Farzad", "Afshar");
    }
}
