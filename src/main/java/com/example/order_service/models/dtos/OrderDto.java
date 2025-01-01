package com.example.order_service.models.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Singular;

import java.util.List;

@Getter
@Setter
@Builder
public class OrderDto {
    @Singular
    private List<ItemDto> items;
}
