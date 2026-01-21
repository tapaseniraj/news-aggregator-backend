package org.example.news_aggregator.dto.request;

import lombok.Data;

@Data
public class ContactRequest {
    private String fn;
    private String ln;
    private String email;
    private String mob;
}
