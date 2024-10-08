package com.example.demodoan.repository;

import com.example.demodoan.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {
    boolean existsByAccessToken(String accessToken);
    Optional<Token> findByEmail(String email);

}
