package com.example.linkshrinks.Service;

import com.example.linkshrinks.repository.URLRepository;

public class UrlService {
    private final URLRepository urlRepository;

    public UrlService(URLRepository urlRepository){
        this.urlRepository = urlRepository;
    }
}
