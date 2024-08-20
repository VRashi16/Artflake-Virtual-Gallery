package com.artflake.artgallery.serviceimpl;

import com.artflake.artgallery.dto.ExhibitionArtworkDto;
import com.artflake.artgallery.exception.ApiResponse;
import com.artflake.artgallery.model.ExhibitionArtwork;
import com.artflake.artgallery.model.ExhibitionArtworkId;
import com.artflake.artgallery.repository.ExhibitionArtworkRepository;
import com.artflake.artgallery.service.ExhibitionArtworkService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ExhibitionArtworkServiceImpl implements ExhibitionArtworkService {

        @Autowired
        private ExhibitionArtworkRepository exhibitionArtworkRepository;

        @Autowired
        private ModelMapper modelMapper;

        public List<ExhibitionArtworkDto> getAllExhibitionArtworks() {
            return exhibitionArtworkRepository.findAll().stream()
                    .map(exhibitionArtwork -> modelMapper.map(exhibitionArtwork, ExhibitionArtworkDto.class))
                    .collect(Collectors.toList());
        }

        public ApiResponse createExhibitionArtwork(ExhibitionArtworkDto exhibitionArtworkDto) {
            ExhibitionArtwork exhibitionArtwork = modelMapper.map(exhibitionArtworkDto, ExhibitionArtwork.class);
            exhibitionArtwork = exhibitionArtworkRepository.save(exhibitionArtwork);
            modelMapper.map(exhibitionArtwork, ExhibitionArtworkDto.class);
            return new ApiResponse("exhibition artwork created");
        }

        public ApiResponse deleteExhibitionArtwork(Long exhibitionId, Long artworkId) {
            ExhibitionArtworkId id = new ExhibitionArtworkId(exhibitionId, artworkId);
            exhibitionArtworkRepository.deleteById(id);
            return new ApiResponse("exhibition artwork deleted");
        }

}
