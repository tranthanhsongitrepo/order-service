package com.example.order_service.controllers;

import com.example.order_service.models.OrderEntity;
import com.example.order_service.models.dtos.OrderDto;
import com.example.order_service.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderEntity> createOrder(@RequestBody OrderDto orderDto) {
        return new ResponseEntity<>(orderService.createOrder(orderDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderEntity> getOrder(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.getOrder(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderEntity> updateOrder(@PathVariable Long id, @RequestBody OrderEntity orderEntity) {
        return ResponseEntity.ok(orderService.updateOrder(id, orderEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("")
    public ResponseEntity<Page<OrderEntity>> listOrders(@RequestParam Integer page, @RequestParam Integer pageLimit) {
        return ResponseEntity.ok(orderService.listOrders(page, pageLimit));
    }
}