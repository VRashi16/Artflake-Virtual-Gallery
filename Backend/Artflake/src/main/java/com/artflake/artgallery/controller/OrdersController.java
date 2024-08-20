package com.artflake.artgallery.controller;

import com.artflake.artgallery.dto.OrdersDto;
import com.artflake.artgallery.exception.ApiResponse;
import com.artflake.artgallery.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @GetMapping
    public ResponseEntity<List<OrdersDto>> getAllOrders() {
        List<OrdersDto> orders = ordersService.getAllOrders();
        return ResponseEntity.status(HttpStatus.OK).body(orders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdersDto> getOrderById(@PathVariable("id") Long id) {
        OrdersDto order = ordersService.getOrderById(id);
        return ResponseEntity.status(HttpStatus.OK).body(order);
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createOrder(@RequestBody OrdersDto ordersDto) {
        ApiResponse response = ordersService.createOrder(ordersDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateOrder(@PathVariable("id") Long id, @RequestBody OrdersDto ordersDto) {
        ApiResponse response = ordersService.updateOrder(id, ordersDto);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteOrder(@PathVariable("id") Long id) {
        ApiResponse response = ordersService.deleteOrder(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
