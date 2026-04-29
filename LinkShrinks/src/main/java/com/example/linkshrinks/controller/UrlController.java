package com.example.linkshrinks.controller;

import com.example.linkshrinks.Service.UrlService;
import com.example.linkshrinks.dto.ShortUrlRequest;
import com.example.linkshrinks.dto.ShortUrlResponse;
import com.example.linkshrinks.dto.StatsResponse;
import com.example.linkshrinks.entity.UrlMapping;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
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
    public ShortUrlResponse shortenUrl(@Valid @RequestBody ShortUrlRequest request) {
        UrlMapping mapping = urlService.createShortUrl(request.getOriginalUrl());
        String shortUrl = "http://localhost:8080/" + mapping.getShortCode();
        return new ShortUrlResponse(shortUrl, mapping.getOriginalUrl());



    }

    @GetMapping("/r/{shortCode}")
    public ResponseEntity<Void> redirectToOriginal(@PathVariable String shortCode) {

        UrlMapping mapping = urlService.getOriginalUrl(shortCode);
        String originalUrl = mapping.getOriginalUrl();

        return ResponseEntity.status(302)
                .header("Location", originalUrl)
                .build();
    }

    @GetMapping("/stats/{shortCode}")
    public StatsResponse getStats(@PathVariable String shortCode) {

        UrlMapping mapping = urlService.getStats(shortCode);

        return new StatsResponse(
                mapping.getShortCode(),
                mapping.getOriginalUrl(),
                mapping.getClickCount()
        );
    }
}

