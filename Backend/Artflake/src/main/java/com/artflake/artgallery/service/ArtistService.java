package com.artflake.artgallery.service;

import com.artflake.artgallery.dto.ArtistDto;
import com.artflake.artgallery.exception.ApiResponse;

import java.util.List;

public interface ArtistService {
    List<ArtistDto> getAllArtists();

    ArtistDto getArtistById(Long id);

    ApiResponse createArtist(ArtistDto artistDto);

    ApiResponse updateArtist(Long id, ArtistDto artistDto);

    ApiResponse deleteArtist(Long id);

}
