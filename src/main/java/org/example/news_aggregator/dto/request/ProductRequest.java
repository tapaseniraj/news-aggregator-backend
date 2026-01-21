package org.example.news_aggregator.dto.request;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ProductRequest {

    private String category;
    private String name;
    private String uses;
    private String ingre;

    private List<String> weights;
    private List<BigDecimal> prices;

    private MultipartFile image;
}