package com.example.linkshrinks.Service;

import com.example.linkshrinks.entity.UrlMapping;
import com.example.linkshrinks.repository.URLRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class UrlService {
    private final URLRepository urlRepository;

    public UrlService(URLRepository urlRepository){
        this.urlRepository = urlRepository;
    }
    public UrlMapping createShortUrl(String originalUrl) {

        String shortCode = UUID.randomUUID()

                .toString()

                .substring(0, 6);

        UrlMapping urlMapping = new UrlMapping(originalUrl, shortCode);

        return urlRepository.save(urlMapping);

    }
}
