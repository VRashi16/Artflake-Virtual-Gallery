package com.artflake.artgallery.serviceimpl;

import com.artflake.artgallery.dto.ArtworkGalleryDto;
import com.artflake.artgallery.exception.ApiResponse;
import com.artflake.artgallery.model.ArtworkGallery;
import com.artflake.artgallery.model.ArtworkGalleryId;
import com.artflake.artgallery.repository.ArtworkGalleryRepository;
import com.artflake.artgallery.service.ArtworkGalleryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArtworkGalleryServiceImpl implements ArtworkGalleryService {

    @Autowired
    private ArtworkGalleryRepository artworkGalleryRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<ArtworkGalleryDto> getAllArtworkGalleries() {
        return artworkGalleryRepository.findAll().stream()
                .map(artworkGallery -> modelMapper.map(artworkGallery, ArtworkGalleryDto.class))
                .collect(Collectors.toList());
    }

    public ApiResponse createArtworkGallery(ArtworkGalleryDto artworkGalleryDto) {
        ArtworkGallery artworkGallery = modelMapper.map(artworkGalleryDto, ArtworkGallery.class);
        artworkGallery = artworkGalleryRepository.save(artworkGallery);
        modelMapper.map(artworkGallery, ArtworkGalleryDto.class);
        return new ApiResponse("Artwork gallery created");
    }

    public ApiResponse deleteArtworkGallery(Long artworkId, Long galleryId) {
        ArtworkGalleryId id = new ArtworkGalleryId(artworkId, galleryId);
        artworkGalleryRepository.deleteById(id);
        return new ApiResponse("Artwork gallery deleted");
    }
}
