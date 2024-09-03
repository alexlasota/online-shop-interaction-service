package com.alexlasota.online_shop_interaction_service.client;

import com.alexlasota.online_shop_interaction_service.model.OrderDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "order-service", url = "${order.service.url}")
public interface OrderClient {
    @PostMapping("/api/v1/orders")
    OrderDTO createOrder(@RequestBody OrderDTO orderDTO);

    @GetMapping("/api/v1/orders/{id}")
    OrderDTO getOrderById(@PathVariable Long id);
}