package com.artflake.artgallery.service;

import com.artflake.artgallery.dto.GalleryDto;
import com.artflake.artgallery.exception.ApiResponse;

import java.util.List;

public interface GalleryService {
    List<GalleryDto> getAllGalleries();

    GalleryDto getGalleryById(Long id);

    ApiResponse createGallery(GalleryDto galleryDto);

    ApiResponse updateGallery(Long id, GalleryDto galleryDto);

    ApiResponse deleteGallery(Long id);
}
