package org.example.news_aggregator.service;

import org.example.news_aggregator.dto.request.ProductRequest;
import org.example.news_aggregator.dto.response.ProductResponse;

import java.util.List;


public interface ProductService {
    ProductResponse addProduct(ProductRequest request);

    ProductResponse getProductById(String id);

    List<ProductResponse> getPopularProduct();

    List<ProductResponse> getAllProducts();

    ProductResponse updateProduct(String id, ProductRequest request);

    void deleteProduct(String id);
}
