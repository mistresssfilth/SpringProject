package com.mistressfilth.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class MainController {

    @GetMapping("/")
    public String main(){
        return "index";
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
