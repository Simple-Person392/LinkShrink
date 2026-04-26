package com.example.linkshrinks.controller;

import com.example.linkshrinks.Service.UrlService;
import com.example.linkshrinks.dto.ShortUrlRequest;
import com.example.linkshrinks.dto.ShortUrlResponse;
import com.example.linkshrinks.entity.UrlMapping;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
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
    @ResponseBody
    public ShortUrlResponse shortenUrl(@Valid @RequestBody ShortUrlRequest request) {
        UrlMapping mapping = urlService.createShortUrl(request.getOriginalUrl());
        String shortUrl = "http://localhost:8080/" + mapping.getShortCode();
        return new ShortUrlResponse(shortUrl, mapping.getOriginalUrl());



    }

    @GetMapping("/r/{shortCode}")
    public String redirectToOriginal(@PathVariable String shortCode) {
        UrlMapping mapping = urlService.getOriginalUrl(shortCode);
        String originalUrl = mapping.getOriginalUrl();
        return "redirect:" + originalUrl;
    }

    @GetMapping("/stats/{shortCode}")
    @ResponseBody
    public UrlMapping getStats(@PathVariable String shortCode) {
        return urlService.getStats(shortCode);   // 👈 calling new method
    }
}

