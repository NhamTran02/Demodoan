package com.example.demodoan.service;

import com.example.demodoan.dto.request.UserLoginDTO;
import com.example.demodoan.dto.response.TokenResponse;
import jakarta.servlet.http.HttpServletRequest;

public interface AuthenticationService {
    TokenResponse login(UserLoginDTO loginDTO);

    TokenResponse refresh(HttpServletRequest request);

    String logout(HttpServletRequest request);
}
