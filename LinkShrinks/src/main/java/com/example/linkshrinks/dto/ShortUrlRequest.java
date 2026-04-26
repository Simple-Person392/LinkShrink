package com.example.linkshrinks.dto;

import jakarta.validation.constraints.NotBlank;

public class ShortUrlRequest {
    @NotBlank(message = "URL cannot be empty")
    private String originalUrl;
    private String customCode;
    public String getOriginalUrl(){
        return originalUrl;
    }
    public void setOriginalUrl(String originalUrl){
        this.originalUrl = originalUrl;
    }
}
