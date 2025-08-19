package com.vakula.urlshortner.urlshortner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class UrlController {
	
	@Autowired
	private UrlService urlService;

	@PostMapping("/url/shorten")
    public ResponseEntity<UrlDto> shortenUrl(@RequestBody UrlDto urlDto) {
        System.out.println("Received shorten request for: " + urlDto.getLongUrl() + " with validity: " + urlDto.getValidityMinutes() + " minutes.");

        // Call service to create the short URL
        UrlMapping urlMapping = urlService.generateShortUrl(urlDto.getLongUrl(), urlDto.getValidityMinutes());

        // Construct the full short URL including host and port
        String fullShortUrl = "http://localhost:8080/" + urlMapping.getShortCode();
        urlDto.setShortUrl(fullShortUrl);
        urlDto.setLongUrl(urlMapping.getLongUrl());
        urlDto.setCreatedAt(urlMapping.getCreatedAt());
        urlDto.setExpiresAt(urlMapping.getExpiresAt());
        urlDto.setClickCount(urlMapping.getClickCount());

        return new ResponseEntity<>(urlDto, HttpStatus.CREATED);
    }
}
