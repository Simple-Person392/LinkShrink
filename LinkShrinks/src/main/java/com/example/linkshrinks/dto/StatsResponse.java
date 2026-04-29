package com.example.linkshrinks.dto;

public class StatsResponse {
        private String shortCode;
        private String originalUrl;
        private long clickCount;

        public StatsResponse(String shortCode, String originalUrl, long clickCount) {
            this.shortCode = shortCode;
            this.originalUrl = originalUrl;
            this.clickCount = clickCount;
        }
}
