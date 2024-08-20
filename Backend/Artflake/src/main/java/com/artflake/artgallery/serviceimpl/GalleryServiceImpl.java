package com.artflake.artgallery.serviceimpl;

import com.artflake.artgallery.dto.GalleryDto;
import com.artflake.artgallery.exception.ApiResponse;
import com.artflake.artgallery.exception.ResourceNotFoundException;
import com.artflake.artgallery.model.Gallery;
import com.artflake.artgallery.repository.GalleryRepository;
import com.artflake.artgallery.service.GalleryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GalleryServiceImpl implements GalleryService {

    @Autowired
    private GalleryRepository galleryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<GalleryDto> getAllGalleries() {
        List<Gallery> galleries = galleryRepository.findAll();
        return galleries.stream()
                .map(gallery -> modelMapper.map(gallery, GalleryDto.class))
                .toList();
    }

    @Override
    public GalleryDto getGalleryById(Long id) {
        Gallery gallery = galleryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Gallery not found"));
        return modelMapper.map(gallery, GalleryDto.class);
    }

    @Override
    public ApiResponse createGallery(GalleryDto galleryDto) {
        Gallery gallery = modelMapper.map(galleryDto, Gallery.class);
        galleryRepository.save(gallery);
        return new ApiResponse("Inserted gallery successfully");
    }

    @Override
    public ApiResponse updateGallery(Long id, GalleryDto galleryDto) {
        Gallery gallery = galleryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Gallery not found"));
        modelMapper.map(galleryDto, gallery);
        galleryRepository.save(gallery);
        return new ApiResponse("Updated gallery successfully");
    }

    @Override
    public ApiResponse deleteGallery(Long id) {
        if (galleryRepository.existsById(id)) {
            galleryRepository.deleteById(id);
            return new ApiResponse("Deleted gallery successfully");
        } else {
            throw new ResourceNotFoundException("Gallery not found");
        }
    }
}
