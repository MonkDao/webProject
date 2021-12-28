package com.prototype.first.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageContr {

    @GetMapping("/m")
    public String  mPage (){
        return "m";
    }

    @GetMapping("/mtwo")
    public String  mtwoPage (){
        return "mtwo";
    }

    @GetMapping("/movies")
    public String  moviesPage (){
        return "movies";
    }

    @GetMapping("/errorPage")
    public String  errorPage (){
        return "errorPage";
    }
}