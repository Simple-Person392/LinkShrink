package com.example.linkshrinks.controller;

import org.springframework.web.bind.annotation.*;

@RestController

public class UrlController {

    @GetMapping("/")

    public String home() {

        return "URL Shortener App is running 🚀";

    }
    @GetMapping("/short")

    public String shortener() {

        return "URL Shortener App is running 🚀";

    }
}

