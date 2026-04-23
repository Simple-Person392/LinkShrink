package com.example.linkshrinks.controller;

import com.example.linkshrinks.Service.UrlService;
import com.example.linkshrinks.entity.UrlMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
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
    public UrlMapping shortenUrl(@RequestParam String originalUrl) {

        return urlService.createShortUrl(originalUrl);

    }

    @GetMapping("/{shortCode}")

    public String redirectToOriginal(@PathVariable String shortCode) {

        String originalUrl = urlService.getOriginalUrl(shortCode);

        if (originalUrl == null) {

            return "URL not found";

        }

        return "redirect:" + originalUrl;

    }
}

