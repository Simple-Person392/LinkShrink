package com.example.linkshrinks.Service;

import com.example.linkshrinks.entity.UrlMapping;
import com.example.linkshrinks.exception.InvalidUrlException;
import com.example.linkshrinks.exception.UrlAlreadyExistsException;
import com.example.linkshrinks.exception.UrlNotFoundException;
import com.example.linkshrinks.repository.URLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;
import java.util.UUID;

import static org.springframework.data.util.ClassUtils.ifPresent;

@Service
public class UrlService {
    private final URLRepository urlRepository;
    @Autowired
    private RestTemplate restTemplate;

    public UrlService(URLRepository urlRepository){
        this.urlRepository = urlRepository;
    }
    public UrlMapping createShortUrl(String originalUrl) {
        if (!(originalUrl.startsWith("http://") || originalUrl.startsWith("https://"))) {
            throw new InvalidUrlException("Invalid URL");
        }

        Optional<UrlMapping> existing = urlRepository.findByOriginalUrl(originalUrl);
        if (existing.isPresent()) {
            return existing.get();
        }

        urlRepository.findByOriginalUrl(originalUrl)
        .ifPresent(url -> {
            throw new UrlAlreadyExistsException("URL already shortened");
        });
        String shortCode = UUID.randomUUID()

                .toString()

                .substring(0, 6);

        UrlMapping urlMapping = new UrlMapping(originalUrl, shortCode);

        return urlRepository.save(urlMapping);

    }
    public UrlMapping getOriginalUrl(String shortCode) {

        UrlMapping mapping = urlRepository.findByShortCode(shortCode)
                .orElseThrow(()-> new UrlNotFoundException("Short URL not found"));

        if (mapping == null) {

            return null;

        }
        mapping.setClickCount(mapping.getClickCount() + 1);
        urlRepository.save(mapping);
        String analyticsUrl = "http://localhost:8082/analytics/click/" + shortCode;

        restTemplate.postForObject(analyticsUrl, null, Void.class);

        return mapping;
    }

    public UrlMapping getStats(String shortCode) {

        return urlRepository.findByShortCode(shortCode)

                .orElseThrow(() -> new UrlNotFoundException("Short URL not found"));
    }
}
