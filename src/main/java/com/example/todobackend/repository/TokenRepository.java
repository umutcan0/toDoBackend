package com.example.todobackend.repository;

import com.example.todobackend.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<Token, Long> {
    Token findTokenByUser_Username(String username);
}
