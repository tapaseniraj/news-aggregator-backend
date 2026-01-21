package org.example.news_aggregator.mapper;

import org.example.news_aggregator.document.Product;
import org.example.news_aggregator.dto.request.ProductRequest;
import org.example.news_aggregator.dto.response.ProductResponse;

public class ProductMapper {
    public static Product toEntity(ProductRequest request) {
        Product product = new Product();
        product.setCategory(request.getCategory());
        product.setName(request.getName());
        product.setUses(request.getUses());
        product.setIngre(request.getIngre());
        product.setWeights(request.getWeights());
        product.setPrices(request.getPrices());
        return product;
    }

    public static ProductResponse toResponse(Product product) {
        ProductResponse response = new ProductResponse();
        response.setId(product.getId());
        response.setCategory(product.getCategory());
        response.setUses(product.getUses());
        response.setIngre(product.getIngre());
        response.setName(product.getName());
        response.setImageUrl(product.getImageUrl());
        response.setWeights(product.getWeights());
        response.setPrices(product.getPrices());
        return response;
    }
}
