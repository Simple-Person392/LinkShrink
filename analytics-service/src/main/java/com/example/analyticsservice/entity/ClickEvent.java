package com.example.analyticsservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
@Entity
public class ClickEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String shortCode;
    private LocalDateTime timestamp;
    public ClickEvent() {}
    public ClickEvent(String shortCode, LocalDateTime timestamp) {
        this.shortCode = shortCode;
        this.timestamp = timestamp;
    }
    public Long getId() {
        return id;
    }
    public String getShortCode() {
        return shortCode;
    }
    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
