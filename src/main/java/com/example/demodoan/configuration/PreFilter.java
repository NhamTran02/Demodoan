package com.example.demodoan.configuration;

import com.example.demodoan.enums.TokenType;
import com.example.demodoan.exception.ErrorCode;
import com.example.demodoan.exception.ResourceNotFoundException;
import com.example.demodoan.repository.TokenRepository;
import com.example.demodoan.service.JwtService;
import com.example.demodoan.service.UserService;
import io.micrometer.common.util.StringUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@Slf4j
public class PreFilter extends OncePerRequestFilter {
    private final JwtService jwtService;
    private UserService userService;
    private TokenRepository tokenRepository;

    @Autowired
    public PreFilter(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService; // Setter injection
    }

    @Autowired
    public void setTokenRepository(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,FilterChain filterChain) throws ServletException, IOException {
        log.info("----------------PreFilter---------------");
        final String authorization = request.getHeader("Authorization");
//        log.info("Authorization: {}",authorization);
        if (StringUtils.isBlank(authorization) || !authorization.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }
        final String token = authorization.substring("Bearer ".length());
//        log.info("Token: {}",token);
        final String username= jwtService.extractUsername(token, TokenType.ACCESS_TOKEN);

        if(!tokenRepository.existsByAccessToken(token)){
            throw new ResourceNotFoundException(ErrorCode.TOKEN_IS_INVALID);
        }

        if (StringUtils.isNotEmpty(username) && SecurityContextHolder.getContext().getAuthentication() == null) {

            UserDetails userDetails=userService.userDetailsService().loadUserByUsername(username);

            if (jwtService.isValidate(token,TokenType.ACCESS_TOKEN, userDetails)) {

                SecurityContext context=SecurityContextHolder.createEmptyContext();
                UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                context.setAuthentication(authenticationToken);
                SecurityContextHolder.setContext(context);

            }
        }

        filterChain.doFilter(request, response);
    }
}
