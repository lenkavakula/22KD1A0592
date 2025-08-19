package com.vakula.urlshortner.urlshortner;

import java.time.LocalDateTime;

public class UrlMapping {

	private String longUrl;
    private String shortCode;
    private LocalDateTime createdAt;
    private LocalDateTime expiresAt;
    private Long clickCount;

    // Default constructor
    public UrlMapping() {}

    // Constructor for creating a new mapping
    public UrlMapping(String longUrl, String shortCode, LocalDateTime createdAt, LocalDateTime expiresAt, Long clickCount) {
        this.longUrl = longUrl;
        this.shortCode = shortCode;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
        this.clickCount = clickCount;
    }

    // --- Getters and Setters ---
    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
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

    public Long getClickCount() {
        return clickCount;
    }

    public void setClickCount(Long clickCount) {
        this.clickCount = clickCount;
    }

    @Override
    public String toString() {
        return "UrlMapping{" +
               "longUrl='" + longUrl + '\'' +
               ", shortCode='" + shortCode + '\'' +
               ", createdAt=" + createdAt +
               ", expiresAt=" + expiresAt +
               ", clickCount=" + clickCount +
               '}';
    }
}
