package org.example.news_aggregator.dto.response;

import lombok.Data;

@Data
public class UserLoginResponse {
    private String token;

    private long expiresIn;

}
