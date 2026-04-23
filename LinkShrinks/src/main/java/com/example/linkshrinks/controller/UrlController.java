package com.example.linkshrinks.controller;

import com.example.linkshrinks.Service.UrlService;
import com.example.linkshrinks.entity.UrlMapping;
import org.springframework.web.bind.annotation.*;

@RestController
public class UrlController {
    private final UrlService urlService;
    public UrlController(UrlService urlService){
        this.urlService = urlService;
    }

    @GetMapping("/")

    public String home() {

        return "URL Shortener App is running 🚀";

    }
    @GetMapping("/short")

    public String shortener() {

        return "URL Shortener App is running 🚀";

    }
    @PostMapping("/shorten")

    public UrlMapping shortenUrl(@RequestParam String originalUrl) {

        return urlService.createShortUrl(originalUrl);

    }
}

