package com.example.order_service.services;

import com.example.order_service.exceptions.OrderEntityNotFoundException;
import com.example.order_service.models.OrderEntity;
import com.example.order_service.models.dtos.OrderDto;
import com.example.order_service.models.dtos.mappers.OrderDtoToOrderMapper;
import com.example.order_service.repos.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    private final OrderDtoToOrderMapper orderDtoOrderMapper;

    public OrderEntity createOrder(OrderDto orderDto) {
        OrderEntity orderEntity = orderDtoOrderMapper.mapOrderDtoToOrder(orderDto);
        orderRepository.save(orderEntity);
        return orderEntity;
    }

    public OrderEntity getOrder(Long id) {
        Optional<OrderEntity> orderEntity =  orderRepository.findById(id);

        if (orderEntity.isPresent()) {
            return orderEntity.get();
        }
        else {
            throw new OrderEntityNotFoundException();
        }
    }

    public OrderEntity updateOrder(Long id, OrderEntity orderEntity) {
        orderEntity.setOrderId(id);

        Optional<OrderEntity> orderEntityOptional =  orderRepository.findById(id);

        if (orderEntityOptional.isPresent()) {
            OrderEntity existingOrderEntity = orderEntityOptional.get();
            orderEntity.setOrderId(existingOrderEntity.getOrderId());
            orderRepository.save(existingOrderEntity);
        }
        else {
            throw new OrderEntityNotFoundException();
        }

        return null;
    }

    public void deleteOrder(Long id) {
        Optional<OrderEntity> orderEntityOptional =  orderRepository.findById(id);

        if (orderEntityOptional.isPresent()) {
            OrderEntity existingOrderEntity = orderEntityOptional.get();
            orderRepository.delete(existingOrderEntity);
        }
        else {
            throw new OrderEntityNotFoundException();
        }
    }

    public Page<OrderEntity> listOrders(Integer page, Integer pageLimit) {
        return orderRepository.findAll(PageRequest.of(page, pageLimit));
    }
}