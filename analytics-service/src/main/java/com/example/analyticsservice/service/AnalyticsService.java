package com.example.analyticsservice.service;

import com.example.analyticsservice.entity.ClickEvent;
import com.example.analyticsservice.repository.ClickEventRepository;
import org.springframework.stereotype.Service;

@Service
public class AnalyticsService {
    private final ClickEventRepository repository;

    public AnalyticsService(ClickEventRepository repository) {

        this.repository = repository;

    }

    public void trackClick(String shortCode) {

        ClickEvent event = new ClickEvent();

        event.setShortCode(shortCode);

        repository.save(event);

    }
    public Long getClickCount(String shortCode) {
        return repository.countByShortCode(shortCode);
    }
}
