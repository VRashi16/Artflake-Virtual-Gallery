package com.artflake.artgallery.dto;

public class CartRequest {
    private Long userId;
    private Long artworkId;

    public CartRequest() {
    }

    public CartRequest(Long userId, Long artworkId) {
        this.userId = userId;
        this.artworkId = artworkId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getArtworkId() {
        return artworkId;
    }

    public void setArtworkId(Long artworkId) {
        this.artworkId = artworkId;
    }
}
