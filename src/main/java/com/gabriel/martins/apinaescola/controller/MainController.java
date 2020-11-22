package com.gabriel.martins.apinaescola.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class MainController {

    @RequestMapping("/")
    public String homeAPI() {
        return "Welcome to NaEscola API!";
    }
}
