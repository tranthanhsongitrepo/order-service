package com.example.order_service.models.dtos.mappers;

import com.example.order_service.models.ItemEntity;
import com.example.order_service.models.OrderEntity;
import com.example.order_service.models.dtos.ItemDto;
import com.example.order_service.models.dtos.OrderDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderDtoToOrderMapper {
    OrderEntity mapOrderDtoToOrder(OrderDto orderDto);

    ItemEntity mapItemDtoToItem(ItemDto itemDto);
}
