package com.example.todobackend.repository;

import com.example.todobackend.entity.Item;
import com.example.todobackend.entity.ItemList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ItemListRepository extends JpaRepository<ItemList, Long> {
    Optional<List<ItemList>> findByNameContaining(String name);
    Optional<List<ItemList>> findAllByOwnerId(Long id);
}
