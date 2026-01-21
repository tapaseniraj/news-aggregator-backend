package org.example.news_aggregator.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.List;

@Data
@Document(collection = "products")
public class Product {
    @Id
    private String id;

    private String category;
    private String name;
    private String uses;
    private String ingre;

    // store comma separated OR array (recommended)
    private List<String> weights;
    private  List<BigDecimal> prices;

    private String imageUrl;
    private boolean popular = false;
}
