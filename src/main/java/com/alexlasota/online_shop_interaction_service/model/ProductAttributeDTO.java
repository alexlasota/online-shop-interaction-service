package com.alexlasota.online_shop_interaction_service.model;

import lombok.Data;
import java.math.BigDecimal;
@Data
public class ProductAttributeDTO {
    private Long id;
    private String attributeName;
    private String attributeValue;
    private BigDecimal priceModifier;
}