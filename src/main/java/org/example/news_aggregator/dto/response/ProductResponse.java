package org.example.news_aggregator.dto.response;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ProductResponse {
    private String id;
    private String category;
    private String uses;
    private String ingre;
    private String name;
    private String imageUrl;
    private List<String> weights;
    private List<BigDecimal> prices;


}
