package com.tech.spcours.pos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/status"})
public class HomeController {

    @GetMapping
    public String healthCheck() {
        return "application is up and running";
    }
}
