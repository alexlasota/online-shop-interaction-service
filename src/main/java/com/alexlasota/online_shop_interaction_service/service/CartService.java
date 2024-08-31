package com.alexlasota.online_shop_interaction_service.service;

import com.alexlasota.online_shop_interaction_service.client.CartClient;
import com.alexlasota.online_shop_interaction_service.model.CartDTO;
import com.alexlasota.online_shop_interaction_service.model.CartItemDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartClient cartClient;

    public CartDTO createCart() {
        return cartClient.createCart();
    }

    public CartDTO addItemToCart(Long cartId, CartItemDTO itemDTO) {
        return cartClient.addItemToCart(cartId, itemDTO);
    }
}