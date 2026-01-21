package org.example.news_aggregator.controller;

import org.example.news_aggregator.document.Product;
import org.example.news_aggregator.dto.request.ProductRequest;
import org.example.news_aggregator.dto.request.ProductUpdateRequest;
import org.example.news_aggregator.dto.response.ProductResponse;
import org.example.news_aggregator.repository.ProductRepository;
import org.example.news_aggregator.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    private final ProductService productService;

    // CREATE
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ProductResponse> addProduct(
            @ModelAttribute ProductRequest request
    ) {
        return ResponseEntity.ok(productService.addProduct(request));
    }

    @PatchMapping("/{id}/popular")
    public Product togglePopular(@PathVariable String id, @RequestParam boolean popular) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        product.setPopular(popular);
        return productRepository.save(product);
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(
            @PathVariable String id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    // GET ALL
    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

 // GET ALL Popular Product
    @GetMapping("/popular")
    public ResponseEntity<List<ProductResponse>> getPopularProduct() {
        return ResponseEntity.ok(productService.getPopularProduct());
    }

    // UPDATE
    @PutMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ProductResponse> updateProduct(
            @PathVariable String id,
            @ModelAttribute ProductRequest request) {
        return ResponseEntity.ok(productService.updateProduct(id, request));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }


}
