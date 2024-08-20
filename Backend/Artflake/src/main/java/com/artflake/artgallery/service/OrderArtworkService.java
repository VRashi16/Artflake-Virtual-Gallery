package com.artflake.artgallery.service;

import com.artflake.artgallery.dto.OrderArtworkDto;
import com.artflake.artgallery.exception.ApiResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public interface OrderArtworkService {

    List<OrderArtworkDto> getAllOrderArtworks();

    ApiResponse createOrderArtwork(OrderArtworkDto orderArtworkDto);

    ApiResponse deleteOrderArtwork(Long orderId, Long artworkId);
}
