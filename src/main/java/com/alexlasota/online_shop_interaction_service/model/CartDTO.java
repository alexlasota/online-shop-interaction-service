package com.alexlasota.online_shop_interaction_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDTO {
    private Long id;
    private LocalDateTime createdAt;
    private BigDecimal totalPrice;
    private List<CartItemDTO> items;

    public CartDTO(Long id, List<CartItemDTO> items, BigDecimal totalPrice) {
        this.id = id;
        this.items = items;
        this.totalPrice = totalPrice;
        this.createdAt = LocalDateTime.now(); // Ustawiamy bieżący czas
    }
}
