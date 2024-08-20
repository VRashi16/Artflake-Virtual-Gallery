package com.artflake.artgallery.serviceimpl;

import com.artflake.artgallery.dto.ExhibitionDto;
import com.artflake.artgallery.exception.ApiResponse;
import com.artflake.artgallery.exception.ResourceNotFoundException;
import com.artflake.artgallery.model.Exhibition;
import com.artflake.artgallery.model.Gallery;
import com.artflake.artgallery.repository.ExhibitionRepository;
import com.artflake.artgallery.repository.GalleryRepository;
import com.artflake.artgallery.service.ExhibitionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ExhibitionServiceImpl implements ExhibitionService {

    @Autowired
    private ExhibitionRepository exhibitionRepository;

    @Autowired
    private GalleryRepository galleryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ExhibitionDto> getAllExhibitions() {
        List<Exhibition> exhibitions = exhibitionRepository.findAll();
        return exhibitions.stream()
                .map(exhibition -> modelMapper.map(exhibition, ExhibitionDto.class))
                .toList();
    }

    @Override
    public ExhibitionDto getExhibitionById(Long id) {
        Exhibition exhibition = exhibitionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Exhibition not found"));
        return modelMapper.map(exhibition, ExhibitionDto.class);
    }

    @Override
    public ApiResponse createExhibition(ExhibitionDto exhibitionDto) {
        Gallery gallery = galleryRepository.findById(exhibitionDto.getGalleryId())
                .orElseThrow(() -> new ResourceNotFoundException("Gallery not found"));

        Exhibition exhibition = modelMapper.map(exhibitionDto, Exhibition.class);
        exhibition.setGallery(gallery);

        exhibitionRepository.save(exhibition);
        return new ApiResponse("Inserted exhibition successfully");
    }

    @Override
    public ApiResponse updateExhibition(Long id, ExhibitionDto exhibitionDto) {
        Exhibition exhibition = exhibitionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Exhibition not found"));

        Gallery gallery = galleryRepository.findById(exhibitionDto.getGalleryId())
                .orElseThrow(() -> new ResourceNotFoundException("Gallery not found"));

        modelMapper.map(exhibitionDto, exhibition);
        exhibition.setGallery(gallery);

        exhibitionRepository.save(exhibition);
        return new ApiResponse("Updated exhibition successfully");
    }

    @Override
    public ApiResponse deleteExhibition(Long id) {
        if (exhibitionRepository.existsById(id)) {
            exhibitionRepository.deleteById(id);
            return new ApiResponse("Deleted exhibition successfully");
        } else {
            throw new ResourceNotFoundException("Exhibition not found");
        }
    }
}
