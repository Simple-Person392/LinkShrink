package com.example.analyticsservice.controller;

import com.example.analyticsservice.service.AnalyticsService;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/count/{shortCode}")
    public Long getClickCount(@PathVariable String shortCode) {
        return service.getClickCount(shortCode);
    }
}
