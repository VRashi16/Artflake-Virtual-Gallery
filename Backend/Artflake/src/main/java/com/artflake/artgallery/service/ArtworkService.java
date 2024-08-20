package com.artflake.artgallery.service;

import com.artflake.artgallery.dto.ArtworkDto;
import com.artflake.artgallery.exception.ApiResponse;

import java.util.List;

public interface ArtworkService {
    List<ArtworkDto> getAllArtworks();

    ArtworkDto getArtworkById(Long id);

    List<ArtworkDto> getArtworksByArtistId(Long artistId);

    ApiResponse createArtwork(ArtworkDto artworkDto);

    ApiResponse updateArtwork(Long id, ArtworkDto artworkDto);

    ApiResponse deleteArtwork(Long id);
}
