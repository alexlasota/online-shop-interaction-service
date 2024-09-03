package com.alexlasota.online_shop_interaction_service.client;

import com.alexlasota.online_shop_interaction_service.model.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;
import java.util.Set;

@FeignClient(name = "product-service", url = "${product.service.url}")
public interface ProductClient {
    @GetMapping("/api/products")
    List<ProductDTO> getAllProducts();

    @GetMapping("/api/products/{id}")
    ProductDTO getProductById(@PathVariable Long id);

    @GetMapping("/api/products/type/{type}")
    List<ProductDTO> getProductsByType(@PathVariable String type);

    @GetMapping("/api/products/configurations/{type}")
    Map<String, Set<String>> getProductConfigurations(@PathVariable String type);
}