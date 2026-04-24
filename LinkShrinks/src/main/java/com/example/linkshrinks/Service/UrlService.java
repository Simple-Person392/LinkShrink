package com.example.linkshrinks.Service;

import com.example.linkshrinks.entity.UrlMapping;
import com.example.linkshrinks.exception.InvalidUrlException;
import com.example.linkshrinks.exception.UrlAlreadyExistsException;
import com.example.linkshrinks.exception.UrlNotFoundException;
import com.example.linkshrinks.repository.URLRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static org.springframework.data.util.ClassUtils.ifPresent;

@Service
public class UrlService {
    private final URLRepository urlRepository;

    public UrlService(URLRepository urlRepository){
        this.urlRepository = urlRepository;
    }
    public UrlMapping createShortUrl(String originalUrl) {
        if(!originalUrl.contains("http")){
            throw new InvalidUrlException("Url must contain http or https");
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
    public String getOriginalUrl(String shortCode) {

        UrlMapping mapping = urlRepository.findByShortCode(shortCode)
                .orElseThrow(()-> new UrlNotFoundException("Short URL not found"));

        if (mapping == null) {

            return null;

        }

        return mapping.getOriginalUrl();
    }
}
