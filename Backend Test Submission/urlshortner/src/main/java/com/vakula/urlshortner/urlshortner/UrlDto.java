package com.vakula.urlshortner.urlshortner;

import java.time.LocalDateTime;

public class UrlDto {

	private String longUrl;
    private String shortUrl; // Used for response
    private Integer validityMinutes; // Used for request (optional)
    private Long clickCount; // Used for stats response
    private LocalDateTime createdAt; // Used for stats response
    private LocalDateTime expiresAt; // Used for stats response

    // Default constructor
    public UrlDto() {
    }

    // Constructor for request
    public UrlDto(String longUrl, Integer validityMinutes) {
        this.longUrl = longUrl;
        this.validityMinutes = validityMinutes;
    }

    // Constructor for response (example)
    public UrlDto(String longUrl, String shortUrl, Integer validityMinutes, Long clickCount, LocalDateTime createdAt, LocalDateTime expiresAt) {
        this.longUrl = longUrl;
        this.shortUrl = shortUrl;
        this.validityMinutes = validityMinutes;
        this.clickCount = clickCount;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
    }

    // Getters and Setters
    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public Integer getValidityMinutes() {
        return validityMinutes;
    }

    public void setValidityMinutes(Integer validityMinutes) {
        this.validityMinutes = validityMinutes;
    }

    public Long getClickCount() {
        return clickCount;
    }

    public void setClickCount(Long clickCount) {
        this.clickCount = clickCount;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(LocalDateTime expiresAt) {
        this.expiresAt = expiresAt;
    }
}
