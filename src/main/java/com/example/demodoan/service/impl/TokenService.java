package com.example.demodoan.service.impl;

import com.example.demodoan.exception.ErrorCode;
import com.example.demodoan.exception.ResourceNotFoundException;
import com.example.demodoan.model.Token;
import com.example.demodoan.repository.TokenRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public record TokenService(TokenRepository tokenRepository) {
    public long save(Token token) {
        Optional<Token> optional =tokenRepository.findByUsername(token.getUsername());
        if (optional.isEmpty()) {
            tokenRepository.save(token);
            return token.getId();
        }else {
            Token currentToken = optional.get();
            currentToken.setAccessToken(token.getAccessToken());
            currentToken.setRefressToken(token.getRefressToken());
            tokenRepository.save(currentToken);
            return currentToken.getId();
        }
    }
    public String delete(Token token) {
        tokenRepository.delete(token);
        return "Deleted!";
    }
    public Token getByUsername(String username) {
        return tokenRepository.findByUsername(username).orElseThrow(()-> new ResourceNotFoundException(ErrorCode.TOKEN_NOT_EXISTS));
    }
}
