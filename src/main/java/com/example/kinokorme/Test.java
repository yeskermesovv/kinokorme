package com.example.kinokorme;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/test")
public class Test {

    @GetMapping
    public String sayHello() {
        return "Hello World!";
    }
}
