package com.artflake.artgallery.service;

import com.artflake.artgallery.dto.OrdersDto;
import com.artflake.artgallery.exception.ApiResponse;

import java.util.List;

public interface OrdersService {
    List<OrdersDto> getAllOrders();

    OrdersDto getOrderById(Long id);

    ApiResponse createOrder(OrdersDto ordersDto);

    ApiResponse updateOrder(Long id, OrdersDto ordersDto);

    ApiResponse deleteOrder(Long id);
}
