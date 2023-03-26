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

    @GetMapping("/v2/person")
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

    //****
    //based on Request Header -> add this key and value to header
    @GetMapping(path = "/person/header", headers = "X-API-VERSION=1")
    public PersonV1 getPersonV1BasedOnRequestHeader() {
        return new PersonV1("Farzad Afshar");
    }

    @GetMapping(path = "/person/header", headers = "X-API-VERSION=2")
    public PersonV1 getPersonV2BasedOnRequestHeader() {
        return new PersonV1("Farzad Afshar");
    }

    //****
    //based on Request Accept Header -> add this key to Accept header : Accept=value
    @GetMapping(path = "/person/accept", headers = "application/vnd.company.app-v1+json")
    public PersonV1 getPersonV1BasedOnAcceptHeader() {
        return new PersonV1("Farzad Afshar");
    }

    @GetMapping(path = "/person/accept", headers = "application/vnd.company.app-v2+json")
    public PersonV1 getPersonV2BasedOnAcceptHeader() {
        return new PersonV1("Farzad Afshar");
    }
}
