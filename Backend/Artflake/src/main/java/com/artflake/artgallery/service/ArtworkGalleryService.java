package com.artflake.artgallery.service;

import com.artflake.artgallery.dto.ArtworkGalleryDto;
import com.artflake.artgallery.exception.ApiResponse;

import java.util.List;

public interface ArtworkGalleryService {

    List<ArtworkGalleryDto> getAllArtworkGalleries();

    ApiResponse createArtworkGallery(ArtworkGalleryDto artworkGalleryDTto);

    ApiResponse deleteArtworkGallery(Long artworkId, Long galleryId);

}
