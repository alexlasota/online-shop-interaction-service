package com.alexlasota.online_shop_interaction_service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDTO {
    private Long id;
    private LocalDateTime orderDate;
    private OrderStatus status;
    private BigDecimal totalPrice;
    private Long userId;
    private List<OrderItemDTO> items;
    private List<OrderAttributeDTO> attributes;
    
    public OrderDTO(Long id, LocalDateTime orderDate, OrderStatus status, BigDecimal totalPrice, Long userId) {
        this.id = id;
        this.orderDate = orderDate;
        this.status = status;
        this.totalPrice = totalPrice;
        this.userId = userId;
        this.items = new ArrayList<>();
        this.attributes = new ArrayList<>();
    }

    public <E> OrderDTO(long l, LocalDateTime now, OrderStatus orderStatus, BigDecimal bigDecimal, long l1, ArrayList<E> es) {
    }
}
