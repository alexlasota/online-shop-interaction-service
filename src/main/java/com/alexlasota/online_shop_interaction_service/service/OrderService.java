package com.alexlasota.online_shop_interaction_service.service;

import com.alexlasota.online_shop_interaction_service.client.OrderClient;
import com.alexlasota.online_shop_interaction_service.model.OrderDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderClient orderClient;

    public OrderDTO createOrder(OrderDTO orderDTO) {
        return orderClient.createOrder(orderDTO);
    }

    public OrderDTO getOrderById(Long id) {
        return orderClient.getOrderById(id);
    }
}