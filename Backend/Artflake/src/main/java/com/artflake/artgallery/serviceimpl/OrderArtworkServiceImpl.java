package com.artflake.artgallery.serviceimpl;

import com.artflake.artgallery.dto.OrderArtworkDto;
import com.artflake.artgallery.exception.ApiResponse;
import com.artflake.artgallery.model.OrderArtwork;
import com.artflake.artgallery.model.OrderArtworkId;
import com.artflake.artgallery.repository.OrderArtworkRepository;
import com.artflake.artgallery.service.OrderArtworkService;
import com.artflake.artgallery.service.OrdersService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderArtworkServiceImpl implements OrderArtworkService {

    @Autowired
    private OrderArtworkRepository orderArtworkRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<OrderArtworkDto> getAllOrderArtworks() {
        return orderArtworkRepository.findAll().stream()
                .map(orderArtwork -> modelMapper.map(orderArtwork, OrderArtworkDto.class))
                .collect(Collectors.toList());
    }

    public ApiResponse createOrderArtwork(OrderArtworkDto orderArtworkDto) {
        OrderArtwork orderArtwork = modelMapper.map(orderArtworkDto, OrderArtwork.class);
        orderArtwork = orderArtworkRepository.save(orderArtwork);
        modelMapper.map(orderArtwork, OrderArtworkDto.class);
        return new ApiResponse("Order Artwork created");
    }

    public ApiResponse deleteOrderArtwork(Long orderId, Long artworkId) {
        OrderArtworkId id = new OrderArtworkId(orderId, artworkId);
        orderArtworkRepository.deleteById(id);
        return new ApiResponse("Order Artwork deleted");
    }
}
