package com.artflake.artgallery.serviceimpl;

import com.artflake.artgallery.dto.OrdersDto;
import com.artflake.artgallery.exception.ApiResponse;
import com.artflake.artgallery.exception.ResourceNotFoundException;
import com.artflake.artgallery.model.Orders;
import com.artflake.artgallery.model.OrderStatus;
import com.artflake.artgallery.repository.OrdersRepository;
import com.artflake.artgallery.service.OrdersService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<OrdersDto> getAllOrders() {
        List<Orders> orders = ordersRepository.findAll();
        return orders.stream()
                .map(order -> modelMapper.map(order, OrdersDto.class))
                .toList();
    }

    @Override
    public OrdersDto getOrderById(Long id) {
        Orders order = ordersRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found"));
        return modelMapper.map(order, OrdersDto.class);
    }

    @Override
    public ApiResponse createOrder(OrdersDto ordersDto) {
        Orders order = modelMapper.map(ordersDto, Orders.class);
        ordersRepository.save(order);
        return new ApiResponse("Inserted order successfully");
    }

    @Override
    public ApiResponse updateOrder(Long id, OrdersDto ordersDto) {
        Orders order = ordersRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found"));
        modelMapper.map(ordersDto, order);
        ordersRepository.save(order);
        return new ApiResponse("Updated order successfully");
    }

    @Override
    public ApiResponse deleteOrder(Long id) {
        if (ordersRepository.existsById(id)) {
            ordersRepository.deleteById(id);
            return new ApiResponse("Deleted order successfully");
        } else {
            throw new ResourceNotFoundException("Order not found");
        }
    }
}
