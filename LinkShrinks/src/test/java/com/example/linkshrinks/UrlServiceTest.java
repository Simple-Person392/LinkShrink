package com.example.linkshrinks;
import com.example.linkshrinks.dto.ShortUrlRequest;
import com.example.linkshrinks.entity.UrlMapping;
import com.example.linkshrinks.repository.URLRepository;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import com.example.linkshrinks.Service.UrlService;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.*;


import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.Optional;


public class UrlServiceTest {

    @Mock
    private URLRepository urlRepository;
    @InjectMocks
    private  UrlService urlService;
    public UrlServiceTest() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void shouldGenerateShortCodeWhenCustomCodeNotProvided() {

        // Step 1: create request

        ShortUrlRequest request = new ShortUrlRequest();

        request.setOriginalUrl("https://google.com");

        // Step 2: define mock behavior

        when(urlRepository.findByOriginalUrl(anyString()))

                .thenReturn(Optional.empty());
        when(urlRepository.save(any()))
        .thenAnswer(invocation -> invocation.getArgument(0));

        // Step 3: call service

        UrlMapping result = urlService.createShortUrl("https://google.com");

        // Step 4: verify result

        assertNotNull(result);

        assertNotNull(result.getShortCode());

        assertEquals("https://google.com", result.getOriginalUrl());

    }


}
