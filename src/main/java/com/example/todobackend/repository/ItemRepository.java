package com.example.todobackend.repository;

import com.example.todobackend.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Long> {
    // T findAny( T anything) { anything  }

    Optional<List<Item>> findByNameContaining(String name);
}
