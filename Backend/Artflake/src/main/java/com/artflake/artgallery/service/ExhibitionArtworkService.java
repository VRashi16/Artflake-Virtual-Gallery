package com.artflake.artgallery.service;

import com.artflake.artgallery.dto.ExhibitionArtworkDto;
import com.artflake.artgallery.exception.ApiResponse;

import java.util.List;

public interface ExhibitionArtworkService {

    List<ExhibitionArtworkDto> getAllExhibitionArtworks();

    ApiResponse createExhibitionArtwork(ExhibitionArtworkDto exhibitionArtworkDto);

    ApiResponse deleteExhibitionArtwork(Long exhibitionId, Long artworkId);
}
