package com.example.linkshrinks.dto;

public class ShortUrlResponse {
    private String shortUrl;

    private String originalUrl;
    public ShortUrlResponse(String shortUrl, String originalUrl) {

        this.shortUrl = shortUrl;

        this.originalUrl = originalUrl;

    }

    public String getShortUrl() {

        return shortUrl;

    }
    public String getOriginalUrl() {

        return originalUrl;

    }
}
