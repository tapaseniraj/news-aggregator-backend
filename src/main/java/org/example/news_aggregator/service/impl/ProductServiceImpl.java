package org.example.news_aggregator.service.impl;

import org.example.news_aggregator.document.Product;
import org.example.news_aggregator.dto.request.ProductRequest;
import org.example.news_aggregator.dto.request.ProductUpdateRequest;
import org.example.news_aggregator.dto.response.ProductResponse;
import org.example.news_aggregator.mapper.ProductMapper;
import org.example.news_aggregator.repository.ProductRepository;
import org.example.news_aggregator.service.CloudinaryService;
import org.example.news_aggregator.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repository;
    private final CloudinaryService cloudinaryService;

    // GET BY ID
    @Override
    public ProductResponse getProductById(String id) {
        Product product = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        return ProductMapper.toResponse(product);
    }
    // GET Popular Product
    @Override
    public List<ProductResponse> getPopularProduct() {
        return repository.findAll()
                .stream().filter(Product::isPopular)
                .map(ProductMapper::toResponse)
                .collect(Collectors.toList());
    }

    // GET ALL
    @Override
    public List<ProductResponse> getAllProducts() {
        return repository.findAll()
                .stream()
                .map(ProductMapper::toResponse)
                .collect(Collectors.toList());
    }

    // UPDATE
    @Override
    public ProductResponse updateProduct(String id, ProductRequest request) {

        Product product = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        product.setCategory(request.getCategory());
        product.setName(request.getName());
        product.setUses(request.getUses());
        product.setIngre(request.getIngre());
        product.setWeights(request.getWeights());
        product.setPrices(request.getPrices());

        if (request.getImage() != null && !request.getImage().isEmpty()) {
            if (product.getImageUrl() != null) {
                cloudinaryService.deleteImage(product.getImageUrl());
            }
            product.setImageUrl(
                    cloudinaryService.uploadImage(request.getImage())
            );
        }

        return ProductMapper.toResponse(repository.save(product));
    }


    @Override
    public ProductResponse addProduct(ProductRequest request) {

        Product product = ProductMapper.toEntity(request);
        if (request.getImage() != null && !request.getImage().isEmpty()) {
            product.setImageUrl(
                    cloudinaryService.uploadImage(request.getImage())
            );
        }

        return ProductMapper.toResponse(repository.save(product));
    }

    // DELETE
    @Override
    public void deleteProduct(String id) {

        Product product = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        if (product.getImageUrl() != null) {
            cloudinaryService.deleteImage(product.getImageUrl());
        }

        repository.deleteById(id);
    }
}
