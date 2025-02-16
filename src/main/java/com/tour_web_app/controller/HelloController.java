package com.tour_web_app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class HelloController {

    @GetMapping("/test")
    public String index() {
        System.out.println("Hello1");
        return "Hello";
    }
}
