package com.alexlasota.online_shop_interaction_service.service;

import com.alexlasota.online_shop_interaction_service.client.ProductClient;
import com.alexlasota.online_shop_interaction_service.model.ProductDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ProductServiceTest {

    @Mock
    private ProductClient productClient;

    @InjectMocks
    private ProductService productService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllProducts() {
        List<ProductDTO> expectedProducts = Arrays.asList(new ProductDTO(), new ProductDTO());
        when(productClient.getAllProducts()).thenReturn(expectedProducts);

        List<ProductDTO> result = productService.getAllProducts();

        assertEquals(expectedProducts, result);
        verify(productClient).getAllProducts();
    }

    @Test
    void getProductsByType() {
        String type = "electronics";
        List<ProductDTO> expectedProducts = Arrays.asList(new ProductDTO(), new ProductDTO());
        when(productClient.getProductsByType(type)).thenReturn(expectedProducts);

        List<ProductDTO> result = productService.getProductsByType(type);

        assertEquals(expectedProducts, result);
        verify(productClient).getProductsByType(type);
    }

    @Test
    void getProductConfigurations() {
        String type = "computer";
        Map<String, Set<String>> expectedConfigurations = new HashMap<>();
        expectedConfigurations.put("CPU", new HashSet<>(Arrays.asList("i5", "i7")));
        when(productClient.getProductConfigurations(type)).thenReturn(expectedConfigurations);

        Map<String, Set<String>> result = productService.getProductConfigurations(type);

        assertEquals(expectedConfigurations, result);
        verify(productClient).getProductConfigurations(type);
    }

    @Test
    void getProductDetails() {
        Long productId = 1L;
        ProductDTO expectedProduct = new ProductDTO();
        when(productClient.getProductById(productId)).thenReturn(expectedProduct);

        ProductDTO result = productService.getProductDetails(productId);

        assertEquals(expectedProduct, result);
        verify(productClient).getProductById(productId);
    }
}