package com.artflake.artgallery.serviceimpl;

import com.artflake.artgallery.dto.UserGalleryDto;
import com.artflake.artgallery.exception.ApiResponse;
import com.artflake.artgallery.model.UserGallery;
import com.artflake.artgallery.model.UserGalleryId;
import com.artflake.artgallery.repository.UserGalleryRepository;
import com.artflake.artgallery.service.UserGalleryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserGalleryServiceImpl implements UserGalleryService{

    @Autowired
    private UserGalleryRepository userGalleryRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<UserGalleryDto> getAllUserGalleries() {
        return userGalleryRepository.findAll().stream()
                .map(userGallery -> modelMapper.map(userGallery, UserGalleryDto.class))
                .collect(Collectors.toList());
    }

    public ApiResponse createUserGallery(UserGalleryDto userGalleryDto) {
        UserGallery userGallery = modelMapper.map(userGalleryDto, UserGallery.class);
        userGallery = userGalleryRepository.save(userGallery);
        modelMapper.map(userGallery, UserGalleryDto.class);
        return new ApiResponse("User gallery created");
    }

    public ApiResponse deleteUserGallery(Long userId, Long galleryId) {
        UserGalleryId id = new UserGalleryId(userId, galleryId);
        userGalleryRepository.deleteById(id);
        return new ApiResponse("User gallery deleted");
    }
}
