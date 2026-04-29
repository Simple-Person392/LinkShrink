package com.example.analyticsservice.repository;

import com.example.analyticsservice.entity.ClickEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClickEventRepository extends JpaRepository<ClickEvent, Long> {
}
