package org.example.news_aggregator.dto.request;

import lombok.Data;

@Data
public class UserLoginRequest {
    private String email;

    private String password;
}
