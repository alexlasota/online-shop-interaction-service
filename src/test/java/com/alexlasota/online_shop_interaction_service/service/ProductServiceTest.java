//package com.alexlasota.online_shop_interaction_service.service;
//
//import com.alexlasota.online_shop_interaction_service.client.ProductClient;
//import com.alexlasota.online_shop_interaction_service.model.ProductDTO;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.math.BigDecimal;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//public class ProductServiceTest {
//
//    @Mock
//    private ProductClient productClient;
//
//    @InjectMocks
//    private ProductService productService;
//
//    @Test
//    void getAllProducts_shouldReturnAllProducts() {
//        List<ProductDTO> expectedProducts = Arrays.asList(
//                new ProductDTO(1L, "Product 1", BigDecimal.valueOf(10), "Type1"),
//                new ProductDTO(2L, "Product 2", BigDecimal.valueOf(20), "Type2")
//        );
//        when(productClient.getAllProducts()).thenReturn(expectedProducts);
//
//        List<ProductDTO> actualProducts = productService.getAllProducts();
//
//        assertEquals(expectedProducts, actualProducts);
//        verify(productClient).getAllProducts();
//    }
//
//    @Test
//    void getProductsByType_shouldReturnProductsOfGivenType() {
//        String type = "Type1";
//        List<ProductDTO> expectedProducts = Collections.singletonList(
//                new ProductDTO(1L, "Product 1", BigDecimal.valueOf(10), "Type1")
//        );
//        when(productClient.getProductsByType(type)).thenReturn(expectedProducts);
//
//        List<ProductDTO> actualProducts = productService.getProductsByType(type);
//
//        assertEquals(expectedProducts, actualProducts);
//        verify(productClient).getProductsByType(type);
//    }
//
//    @Test
//    void getProductDetails_shouldReturnProductDetails() {
//        Long productId = 1L;
//        ProductDTO expectedProduct = new ProductDTO(1L, "Product 1", BigDecimal.valueOf(10), "Type1");
//        when(productClient.getProductById(productId)).thenReturn(expectedProduct);
//
//        ProductDTO actualProduct = productService.getProductDetails(productId);
//
//        assertEquals(expectedProduct, actualProduct);
//        verify(productClient).getProductById(productId);
//    }
//}