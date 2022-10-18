package com.example.todobackend.repository;

import com.example.todobackend.entity.ERole;
import com.example.todobackend.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByType(ERole type);

}
