package ru.javabegin.testoauth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/internal")
    public String add(){
        return "add";
    }

    @GetMapping("/view")
    public String view(){
        return "view";
    }
}
