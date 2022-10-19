package com.example.todobackend.repository;

import com.example.todobackend.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Long> {
    Optional<Token> findTokenByUser_Username(String username);
}
