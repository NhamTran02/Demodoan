package com.example.demodoan.service.impl;

import com.example.demodoan.enums.TokenType;
import com.example.demodoan.service.JwtService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.function.Function;

@Service
public class JwtServiceImpl implements JwtService {
    @Value("${jwt.expiryTime}")
    private long exprityTime;

    @Value("${jwt.secretKey}")
    private String secretKey;

    @Value("${jwt.refreshKey}")
    private String refreshKey;

    @Override
    public String generateToken(UserDetails userDetails) {
        return generateToken(new HashMap<>(),userDetails);
    }

    @Override
    public String generateRefreshToken(UserDetails userDetails) {
        return generateRefreshToken(new HashMap<>(),userDetails);
    }

    @Override
    public String extractUsername(String token,TokenType type) {
        return extractClaims(token,type, Claims::getSubject);
    }

    @Override
    public boolean isValidate(String token,TokenType type, UserDetails userDetails) {
        final String username = extractUsername(token,type);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token, type);
    }

    private String generateToken(HashMap<String, Object> claims,UserDetails userDetails) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + exprityTime))
                .signWith(getKey(TokenType.ACCESS_TOKEN),SignatureAlgorithm.HS256)
                .compact();
    }
    private String generateRefreshToken(HashMap<String, Object> claims,UserDetails userDetails) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + (exprityTime*24*14)))
                .signWith(getKey(TokenType.REFRESH_TOKEN),SignatureAlgorithm.HS256)
                .compact();
    }

    private Key getKey(TokenType type) {
        byte[] keyBytes;
        if (TokenType.ACCESS_TOKEN.equals(type)) {
            keyBytes = Decoders.BASE64.decode(secretKey);
        }else {
            keyBytes = Decoders.BASE64.decode(refreshKey);
        }
        return Keys.hmacShaKeyFor(keyBytes);
    }

    private <T> T extractClaims(String token,TokenType type, Function<Claims,T> claimsResolver) {
        final Claims claims=extraAllClaim(token,type);
        return claimsResolver.apply(claims);
    }
    private Claims extraAllClaim(String token,TokenType type) {
        return Jwts.parser().setSigningKey(getKey(type)).build().parseClaimsJws(token).getBody();
    }

    private boolean isTokenExpired(String token,TokenType type) {
        return extractExpiration(token,type).before(new Date());
    }

    private Date extractExpiration(String token,TokenType type) {
        return extractClaims(token,type, Claims::getExpiration);
    }

}
