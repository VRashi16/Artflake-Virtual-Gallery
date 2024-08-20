package com.artflake.artgallery.service;
import com.artflake.artgallery.dto.UserGalleryDto;
import com.artflake.artgallery.exception.ApiResponse;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface UserGalleryService {

   List<UserGalleryDto> getAllUserGalleries();

    ApiResponse createUserGallery(UserGalleryDto userGalleryDto);

    ApiResponse deleteUserGallery(Long userId, Long galleryId);
}
