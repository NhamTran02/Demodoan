package com.example.demodoan.service.impl;

import com.example.demodoan.dto.request.UserLoginDTO;
import com.example.demodoan.dto.response.TokenResponse;
import com.example.demodoan.enums.TokenType;
import com.example.demodoan.exception.ErrorCode;
import com.example.demodoan.exception.ResourceNotFoundException;
import com.example.demodoan.model.Token;
import com.example.demodoan.model.User;
import com.example.demodoan.repository.UserRepository;
import com.example.demodoan.service.AuthenticationService;
import com.example.demodoan.service.JwtService;
import io.micrometer.common.util.StringUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final TokenService tokenService;
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Override
    public TokenResponse login(UserLoginDTO loginDTO) {
        Optional<User> optionalUser=userRepository.findByUsername(loginDTO.getUsername());
        if(optionalUser.isEmpty()){
            throw new ResourceNotFoundException(ErrorCode.INVALID_LOGIN);
        }

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword()));

        String accessToken = jwtService.generateToken(optionalUser.get());
        String refreshToken=jwtService.generateRefreshToken(optionalUser.get());
        //save token to db
        tokenService.save(Token.builder()
                        .username(loginDTO.getUsername())
                        .accessToken(accessToken)
                        .refressToken(refreshToken)
                .build());

        return TokenResponse.builder()
                .accsesToken(accessToken)
                .refreshToken(refreshToken)
                .userId(optionalUser.get().getId())
                .build();
    }

    @Override
    public TokenResponse refresh(HttpServletRequest request) {
        String refreshToken=request.getHeader("x-token");
        if (StringUtils.isBlank(refreshToken)) {
            throw new ResourceNotFoundException(ErrorCode.TOKEN_IS_NOT_BLANK);
        }
        //extract user from token
        final String username=jwtService.extractUsername(refreshToken, TokenType.REFRESH_TOKEN);
        //check it into db
        Optional<User> user=userRepository.findByUsername(username);
        if (!jwtService.isValidate(refreshToken,TokenType.REFRESH_TOKEN,user.get())) {
            throw new ResourceNotFoundException(ErrorCode.TOKEN_IS_INVALID);
        }
        String accessToken=jwtService.generateToken(user.get());
        return TokenResponse.builder()
                .accsesToken(accessToken)
                .refreshToken(refreshToken)
                .userId(user.get().getId())
                .build();
    }

    @Override
    public String logout(HttpServletRequest request) {
        String refreshToken=request.getHeader(AUTHORIZATION);
        if (StringUtils.isBlank(refreshToken)) {
            throw new ResourceNotFoundException(ErrorCode.TOKEN_IS_NOT_BLANK);
        }
        //extract user from token
        final String username=jwtService.extractUsername(refreshToken, TokenType.ACCESS_TOKEN);
        Token currentToken=tokenService.getByUsername(username);
        tokenService.delete(currentToken);
        return "Deleted!";
    }
}
