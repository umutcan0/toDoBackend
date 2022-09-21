package com.example.todobackend.repository;

import com.example.todobackend.entity.Item;
import com.example.todobackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    Optional<User> findByEmail(String email); // sdfkghskdfhg@sdfg.com eger varsa useri gonderiyor / yoksa da .orElseThrow()
    Optional<List<User>> findByNameContaining(String name);

}
