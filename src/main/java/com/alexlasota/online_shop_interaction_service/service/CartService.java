package com.alexlasota.online_shop_interaction_service.service;

import com.alexlasota.online_shop_interaction_service.client.CartClient;
import com.alexlasota.online_shop_interaction_service.client.ProductClient;
import com.alexlasota.online_shop_interaction_service.model.CartDTO;
import com.alexlasota.online_shop_interaction_service.model.CartItemDTO;
import com.alexlasota.online_shop_interaction_service.model.ProductDTO;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CartService {
    private final CartClient cartClient;
    private final ProductClient productClient;

    @Retryable(value = {FeignException.class}, maxAttempts = 3, backoff = @Backoff(delay = 1000))
    public CartDTO createCart() {
        return cartClient.createCart();
    }

    @Recover
    public CartDTO recoverCreateCart(FeignException e) {
        log.error("Failed to create cart after retries", e);
        throw new RuntimeException("Unable to create cart", e);
    }

    @Retryable(value = {FeignException.class}, maxAttempts = 3, backoff = @Backoff(delay = 1000))
    public CartDTO addItemToCart(Long cartId, CartItemDTO itemDTO) {
        ProductDTO product = productClient.getProductById(itemDTO.getProductId());
        itemDTO.setPrice(product.getFinalPrice());
        return cartClient.addItemToCart(cartId, itemDTO);
    }

    @Recover
    public CartDTO recoverAddItemToCart(FeignException e, Long cartId, CartItemDTO itemDTO) {
        log.error("Failed to add item to cart after retries", e);
        throw new RuntimeException("Unable to add item to cart", e);
    }
}