package com.example.ecommerce.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class SampleController {

    @GetMapping("/sayHello")
    public String sayHello() {
        return "Hello Everyone!";
    }

    @GetMapping("/sayBye/{name}")
    public String sayBye(@PathVariable("name") String name) {
        return "Bye, " + name;
    }
}
