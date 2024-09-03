package com.alexlasota.online_shop_interaction_service.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.*;

import com.alexlasota.online_shop_interaction_service.model.CartItemDTO;
import com.alexlasota.online_shop_interaction_service.model.OrderDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.alexlasota.online_shop_interaction_service.model.CartDTO;
import com.alexlasota.online_shop_interaction_service.model.ProductDTO;
import com.alexlasota.online_shop_interaction_service.service.CartService;
import com.alexlasota.online_shop_interaction_service.service.OrderService;
import com.alexlasota.online_shop_interaction_service.service.ProductService;

public class UserInteractionControllerTest {

    @Mock
    private ProductService productService;
    @Mock
    private CartService cartService;
    @Mock
    private OrderService orderService;

    @InjectMocks
    private UserInteractionController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getProductsWithoutType() {
        List<ProductDTO> expectedProducts = Arrays.asList(new ProductDTO(), new ProductDTO());
        when(productService.getAllProducts()).thenReturn(expectedProducts);

        ResponseEntity<List<ProductDTO>> response = controller.getProducts(null);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(expectedProducts, response.getBody());
        verify(productService).getAllProducts();
    }

    @Test
    void getProductsWithType() {
        String type = "electronics";
        List<ProductDTO> expectedProducts = Arrays.asList(new ProductDTO(), new ProductDTO());
        when(productService.getProductsByType(type)).thenReturn(expectedProducts);

        ResponseEntity<List<ProductDTO>> response = controller.getProducts(type);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(expectedProducts, response.getBody());
        verify(productService).getProductsByType(type);
    }

    @Test
    void createCart() {
        CartDTO expectedCart = new CartDTO();
        when(cartService.createCart()).thenReturn(expectedCart);

        ResponseEntity<CartDTO> response = controller.createCart();

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(expectedCart, response.getBody());
        verify(cartService).createCart();
    }

    @Test
    void addToCart() {
        Long cartId = 1L;
        CartItemDTO itemDTO = new CartItemDTO();
        CartDTO expectedCart = new CartDTO();
        when(cartService.addItemToCart(cartId, itemDTO)).thenReturn(expectedCart);

        ResponseEntity<CartDTO> response = controller.addToCart(cartId, itemDTO);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(expectedCart, response.getBody());
        verify(cartService).addItemToCart(cartId, itemDTO);
    }

    @Test
    void createOrder() {
        OrderDTO orderDTO = new OrderDTO();
        OrderDTO expectedOrder = new OrderDTO();
        when(orderService.createOrder(orderDTO)).thenReturn(expectedOrder);

        ResponseEntity<OrderDTO> response = controller.createOrder(orderDTO);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(expectedOrder, response.getBody());
        verify(orderService).createOrder(orderDTO);
    }

    @Test
    void getOrder() {
        Long orderId = 1L;
        OrderDTO expectedOrder = new OrderDTO();
        when(orderService.getOrderById(orderId)).thenReturn(expectedOrder);

        ResponseEntity<OrderDTO> response = controller.getOrder(orderId);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(expectedOrder, response.getBody());
        verify(orderService).getOrderById(orderId);
    }

    @Test
    void getProductDetails() {
        Long productId = 1L;
        ProductDTO expectedProduct = new ProductDTO();
        when(productService.getProductDetails(productId)).thenReturn(expectedProduct);

        ResponseEntity<ProductDTO> response = controller.getProductDetails(productId);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(expectedProduct, response.getBody());
        verify(productService).getProductDetails(productId);
    }
}