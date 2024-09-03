package com.alexlasota.online_shop_interaction_service.service;

import com.alexlasota.online_shop_interaction_service.client.ProductClient;
import com.alexlasota.online_shop_interaction_service.model.ProductDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductClient productClient;

    public List<ProductDTO> getAllProducts() {
        return productClient.getAllProducts();
    }

    public List<ProductDTO> getProductsByType(String type) {
        return productClient.getProductsByType(type);
    }

    public Map<String, Set<String>> getProductConfigurations(String type) {
        return productClient.getProductConfigurations(type);
    }
    public ProductDTO getProductDetails(Long id) {
        return productClient.getProductById(id);
    }
}
