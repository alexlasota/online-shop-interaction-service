package com.alexlasota.online_shop_interaction_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItemDTO {
    private Long id;
    private Long productId;
    private Integer quantity;
    private BigDecimal price;

    public CartItemDTO(Long productId, Integer quantity, BigDecimal price) {
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }
}
