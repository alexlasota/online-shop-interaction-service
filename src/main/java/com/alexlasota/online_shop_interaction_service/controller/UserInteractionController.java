package com.alexlasota.online_shop_interaction_service.controller;

import com.alexlasota.online_shop_interaction_service.model.CartDTO;
import com.alexlasota.online_shop_interaction_service.model.CartItemDTO;
import com.alexlasota.online_shop_interaction_service.model.OrderDTO;
import com.alexlasota.online_shop_interaction_service.model.ProductDTO;
import com.alexlasota.online_shop_interaction_service.service.CartService;
import com.alexlasota.online_shop_interaction_service.service.OrderService;
import com.alexlasota.online_shop_interaction_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserInteractionController {
    private final ProductService productService;
    private final CartService cartService;
    private final OrderService orderService;

    @GetMapping("/products")
    public ResponseEntity<List<ProductDTO>> getProducts(@RequestParam(required = false) String type) {
        List<ProductDTO> products = (type != null) ? productService.getProductsByType(type) : productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @PostMapping("/cart")
    public ResponseEntity<CartDTO> createCart() {
        return ResponseEntity.ok(cartService.createCart());
    }

    @PostMapping("/cart/{cartId}/items")
    public ResponseEntity<CartDTO> addToCart(@PathVariable Long cartId, @RequestBody CartItemDTO itemDTO) {
        return ResponseEntity.ok(cartService.addItemToCart(cartId, itemDTO));
    }

    @PostMapping("/orders")
    public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderDTO orderDTO) {
        return ResponseEntity.ok(orderService.createOrder(orderDTO));
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<OrderDTO> getOrder(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.getOrderById(id));
    }
    @GetMapping("/products/{id}")
    public ResponseEntity<ProductDTO> getProductDetails(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProductDetails(id));
    }
}