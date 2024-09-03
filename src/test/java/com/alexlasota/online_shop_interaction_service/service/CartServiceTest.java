package com.alexlasota.online_shop_interaction_service.service;

import com.alexlasota.online_shop_interaction_service.client.CartClient;
import com.alexlasota.online_shop_interaction_service.client.ProductClient;
import com.alexlasota.online_shop_interaction_service.model.CartDTO;
import com.alexlasota.online_shop_interaction_service.model.CartItemDTO;
import com.alexlasota.online_shop_interaction_service.model.ProductDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
public class CartServiceTest {

    @Mock
    private CartClient cartClient;
    @Mock
    private ProductClient productClient;

    @InjectMocks
    private CartService cartService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createCart() {
        CartDTO expectedCart = new CartDTO();
        when(cartClient.createCart()).thenReturn(expectedCart);

        CartDTO result = cartService.createCart();

        assertEquals(expectedCart, result);
        verify(cartClient).createCart();
    }

    @Test
    void addItemToCart() {
        Long cartId = 1L;
        CartItemDTO itemDTO = new CartItemDTO();
        itemDTO.setProductId(2L);
        itemDTO.setQuantity(1);

        ProductDTO productDTO = new ProductDTO();
        productDTO.setFinalPrice(BigDecimal.TEN);

        CartDTO expectedCart = new CartDTO();

        when(productClient.getProductById(2L)).thenReturn(productDTO);
        when(cartClient.addItemToCart(eq(cartId), any(CartItemDTO.class))).thenReturn(expectedCart);

        CartDTO result = cartService.addItemToCart(cartId, itemDTO);

        assertEquals(expectedCart, result);
        assertEquals(BigDecimal.TEN, itemDTO.getPrice());
        verify(productClient).getProductById(2L);
        verify(cartClient).addItemToCart(eq(cartId), any(CartItemDTO.class));
    }
}
