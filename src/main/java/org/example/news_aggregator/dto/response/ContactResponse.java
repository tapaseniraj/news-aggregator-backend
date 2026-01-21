package org.example.news_aggregator.dto.response;

import lombok.Data;

@Data
public class ContactResponse {
    private String id;
    private String fn;
    private String ln;
    private String email;
    private String mob;
}
