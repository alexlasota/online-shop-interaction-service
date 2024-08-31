//package com.alexlasota.online_shop_interaction_service.controller;
//
//import static org.hamcrest.Matchers.*;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//import java.util.*;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.apache.catalina.security.SecurityConfig;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.context.annotation.Import;
//import org.springframework.http.MediaType;
//import org.springframework.security.test.context.support.WithMockUser;
//import org.springframework.test.web.servlet.MockMvc;
//
//import com.alexlasota.online_shop_interaction_service.model.CartDTO;
//import com.alexlasota.online_shop_interaction_service.model.CartItemDTO;
//import com.alexlasota.online_shop_interaction_service.model.OrderDTO;
//import com.alexlasota.online_shop_interaction_service.model.ProductDTO;
//import com.alexlasota.online_shop_interaction_service.service.CartService;
//import com.alexlasota.online_shop_interaction_service.service.OrderService;
//import com.alexlasota.online_shop_interaction_service.service.ProductService;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//@ExtendWith(MockitoExtension.class)
//@Import(SecurityConfig.class)
//public class UserInteractionControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @MockBean
//    private ProductService productService;
//
//    @MockBean
//    private CartService cartService;
//
//    @MockBean
//    private OrderService orderService;
//
//    @Test
//    @WithMockUser(roles = "USER")
//    void getProducts_ReturnsAllProducts() throws Exception {
//        List<ProductDTO> products = Arrays.asList(new ProductDTO(), new ProductDTO());
//        when(productService.getAllProducts()).thenReturn(products);
//
//        mockMvc.perform(get("/api/user/products")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", hasSize(2)));
//    }
//
//    @Test
//    @WithMockUser(roles = "USER")
//    void getProducts_WithType_ReturnsFilteredProducts() throws Exception {
//        List<ProductDTO> products = Arrays.asList(new ProductDTO());
//        when(productService.getProductsByType("electronics")).thenReturn(products);
//
//        mockMvc.perform(get("/api/user/products?type=electronics")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", hasSize(1)));
//    }
//
//    @Test
//    @WithMockUser(roles = {"USER", "CART_WRITE"})
//    void createCart_ReturnsCreatedCart() throws Exception {
//        CartDTO cartDTO = new CartDTO();
//        cartDTO.setId(1L);
//        when(cartService.createCart()).thenReturn(cartDTO);
//
//        mockMvc.perform(post("/api/user/cart")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id").value(1L));
//    }
//
//    @Test
//    @WithMockUser(roles = {"USER", "CART_WRITE"})
//    void addToCart_ReturnsUpdatedCart() throws Exception {
//        CartItemDTO itemDTO = new CartItemDTO();
//        CartDTO updatedCart = new CartDTO();
//        updatedCart.setId(1L);
//        when(cartService.addItemToCart(1L, itemDTO)).thenReturn(updatedCart);
//
//        mockMvc.perform(post("/api/user/cart/1/items")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(itemDTO)))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id").value(1L));
//    }
//
//    @Test
//    @WithMockUser(roles = {"USER", "ORDER_WRITE"})
//    void createOrder_ReturnsCreatedOrder() throws Exception {
//        OrderDTO orderDTO = new OrderDTO();
//        OrderDTO createdOrder = new OrderDTO();
//        createdOrder.setId(1L);
//        when(orderService.createOrder(orderDTO)).thenReturn(createdOrder);
//
//        mockMvc.perform(post("/api/user/orders")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(orderDTO)))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id").value(1L));
//    }
//
//    @Test
//    @WithMockUser(roles = "USER")
//    void getOrder_ReturnsOrder() throws Exception {
//        OrderDTO orderDTO = new OrderDTO();
//        orderDTO.setId(1L);
//        when(orderService.getOrderById(1L)).thenReturn(orderDTO);
//
//        mockMvc.perform(get("/api/user/orders/1")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id").value(1L));
//    }
//
//    @Test
//    @WithMockUser(roles = "USER")
//    void getProductDetails_ReturnsProductDetails() throws Exception {
//        ProductDTO productDTO = new ProductDTO();
//        productDTO.setId(1L);
//        when(productService.getProductDetails(1L)).thenReturn(productDTO);
//
//        mockMvc.perform(get("/api/user/products/1")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id").value(1L));
//    }
//}