package com.alexlasota.online_shop_interaction_service.model;

import lombok.Data;

@Data
public class OrderAttributeDTO {
    private Long id;
    private String name;
    private String attributeValue;
}
