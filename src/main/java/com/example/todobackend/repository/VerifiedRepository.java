package com.example.todobackend.repository;

import com.example.todobackend.entity.User;
import com.example.todobackend.entity.Verified;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VerifiedRepository extends JpaRepository<Verified, Long> { //Neden Long
    Optional<Verified> findByVerificationSlug(Long verificationSlug);
}