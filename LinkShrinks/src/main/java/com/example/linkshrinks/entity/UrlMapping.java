package com.example.linkshrinks.entity;
import jakarta.persistence.*;
@Entity
public class UrlMapping {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String originalUrl;
        private String shortCode;
    public UrlMapping() {
    }
    public UrlMapping(String originalUrl, String shortCode) {
        this.originalUrl = originalUrl;
        this.shortCode = shortCode;
    }
        public Long getId() {
        return id;
    }
        public String getOriginalUrl() {
        return originalUrl;
    }
        public String getShortCode() {

        return shortCode;
    }
        public void setId(Long id) {
        this.id = id;
    }
        public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }
        public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }
}
