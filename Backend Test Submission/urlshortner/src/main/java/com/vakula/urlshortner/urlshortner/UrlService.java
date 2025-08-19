package com.vakula.urlshortner.urlshortner;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Service;

@Service
public class UrlService {

	private final Map<String, UrlMapping> urlStore = new ConcurrentHashMap<>();

    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int SHORT_CODE_LENGTH = 7; // Length of the generated short code

    private static final int DEFAULT_VALIDITY_MINUTES = 30;
    
    public UrlMapping generateShortUrl(String longUrl, Integer validityMinutes) {
        if (longUrl == null || longUrl.trim().isEmpty()) {
            throw new IllegalArgumentException("Long URL cannot be null or empty.");
        }

        String shortCode;
        int maxRetries = 5; // Max attempts to generate a unique short code
        for (int i = 0; i < maxRetries; i++) {
            shortCode = generateUniqueShortCode();
            if (!urlStore.containsKey(shortCode)) { // Check for uniqueness in the in-memory map
                UrlMapping urlMapping = new UrlMapping();
                urlMapping.setLongUrl(longUrl);
                urlMapping.setShortCode(shortCode);
                urlMapping.setCreatedAt(LocalDateTime.now());

                int minutes = (validityMinutes != null && validityMinutes > 0) ? validityMinutes : DEFAULT_VALIDITY_MINUTES;
                urlMapping.setExpiresAt(urlMapping.getCreatedAt().plusMinutes(minutes));
                urlMapping.setClickCount(0L);

                urlStore.put(shortCode, urlMapping); // Store in-memory
                return urlMapping;
            }
        }
		return null;
    }

	private String generateUniqueShortCode() {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder(SHORT_CODE_LENGTH);
        ThreadLocalRandom random = ThreadLocalRandom.current();
        for (int i = 0; i < SHORT_CODE_LENGTH; i++) {
            sb.append(ALPHABET.charAt(random.nextInt(ALPHABET.length())));
        }
        return sb.toString();
	}

    
    
}
