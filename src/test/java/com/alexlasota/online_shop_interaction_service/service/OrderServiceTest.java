package com.alexlasota.online_shop_interaction_service.service;

import com.alexlasota.online_shop_interaction_service.client.OrderClient;
import com.alexlasota.online_shop_interaction_service.model.OrderDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
public class OrderServiceTest {

    @Mock
    private OrderClient orderClient;

    @InjectMocks
    private OrderService orderService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createOrder() {
        OrderDTO orderDTO = new OrderDTO();
        OrderDTO expectedOrder = new OrderDTO();
        when(orderClient.createOrder(orderDTO)).thenReturn(expectedOrder);

        OrderDTO result = orderService.createOrder(orderDTO);

        assertEquals(expectedOrder, result);
        verify(orderClient).createOrder(orderDTO);
    }

    @Test
    void getOrderById() {
        Long orderId = 1L;
        OrderDTO expectedOrder = new OrderDTO();
        when(orderClient.getOrderById(orderId)).thenReturn(expectedOrder);

        OrderDTO result = orderService.getOrderById(orderId);

        assertEquals(expectedOrder, result);
        verify(orderClient).getOrderById(orderId);
    }
}
