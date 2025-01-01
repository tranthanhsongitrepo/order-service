package com.example.order_service.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
public class ItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;

    private String name;

    private String description;

    @ManyToMany
    @JoinTable(name = "order_items", joinColumns = @JoinColumn(name = "item_id"), inverseJoinColumns = @JoinColumn(name = "order_id"))
    private List<OrderEntity> orderEntity;
}
