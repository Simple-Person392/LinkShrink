package com.example.analyticsservice.controller;

import com.example.analyticsservice.service.AnalyticsService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/analytics")
public class AnalyticsController {
    private final AnalyticsService service;
    public AnalyticsController(AnalyticsService service){
        this.service=service;
    }
    @PostMapping("/click/{shortCode}")

    public void trackClick(@PathVariable String shortCode) {

        service.trackClick(shortCode);

    }
}
