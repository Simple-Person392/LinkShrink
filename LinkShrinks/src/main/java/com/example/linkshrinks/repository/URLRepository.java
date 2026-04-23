package com.example.linkshrinks.repository;

import com.example.linkshrinks.entity.UrlMapping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface URLRepository extends JpaRepository<UrlMapping, Long> {
    UrlMapping findByShortCode(String shortCode);
}
