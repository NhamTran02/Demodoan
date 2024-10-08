package com.example.demodoan.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TokenResponse {
    private String accsesToken;
    private String refreshToken;
    private Long userId;

}
