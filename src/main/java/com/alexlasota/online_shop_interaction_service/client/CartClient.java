package com.alexlasota.online_shop_interaction_service.client;

import com.alexlasota.online_shop_interaction_service.model.CartDTO;
import com.alexlasota.online_shop_interaction_service.model.CartItemDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "cart-service", url = "${cart.service.url}")
public interface CartClient {
    @PostMapping("/api/v1/carts")
    CartDTO createCart();

    @GetMapping("/api/v1/carts/{id}")
    CartDTO getCart(@PathVariable Long id);

    @PostMapping("/api/v1/carts/{cartId}/items")
    CartDTO addItemToCart(@PathVariable Long cartId, @RequestBody CartItemDTO itemDTO);
}
