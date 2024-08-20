package com.artflake.artgallery.service;

import com.artflake.artgallery.dto.ExhibitionDto;
import com.artflake.artgallery.exception.ApiResponse;

import java.util.List;

public interface ExhibitionService {
    List<ExhibitionDto> getAllExhibitions();

    ExhibitionDto getExhibitionById(Long id);

    ApiResponse createExhibition(ExhibitionDto exhibitionDto);

    ApiResponse updateExhibition(Long id, ExhibitionDto exhibitionDto);

    ApiResponse deleteExhibition(Long id);
}
