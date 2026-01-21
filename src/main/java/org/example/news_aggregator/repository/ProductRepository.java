package org.example.news_aggregator.repository;

import org.example.news_aggregator.document.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
