package com.alexlasota.online_shop_interaction_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private Long id;
    private String name;
    private BigDecimal basePrice;
    private BigDecimal finalPrice;
    private String type;
    private Set<ProductAttributeDTO> attributes = new HashSet<>();

    public ProductDTO(Long id, String name, BigDecimal price, String type) {
        this.id = id;
        this.name = name;
        this.basePrice = price;
        this.finalPrice = price;
        this.type = type;
    }
}