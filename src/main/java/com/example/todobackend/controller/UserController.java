package com.example.todobackend.controller;

import com.example.todobackend.entity.Item;
import com.example.todobackend.entity.User;
import com.example.todobackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
//    @Autowired
//    private UserRepository userRepository;
//
//    @GetMapping("/users") // Gets all
//    public ResponseEntity<List<User>> getAllUsers() {
//        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
//    }
//
//    @GetMapping("/user/{name}") //GetWithName
//    public ResponseEntity<List<User>> getUserByName(@PathVariable("name") String name) {
//        return new ResponseEntity<>(userRepository.findByNameContaining(name).orElseThrow(() -> new UserNotFoundException(name)), HttpStatus.OK);
//    }
//    @PostMapping("/user/create")
//    public ResponseEntity<User> createUser(@RequestBody User user) { // name description
//        return new ResponseEntity<>(userRepository.save(user), HttpStatus.CREATED);
//    }
//    @PutMapping("/user/update/{id}")
//    public ResponseEntity<User> updateTodo(@RequestBody User user) {
//        return new ResponseEntity<>(userRepository.save(user), HttpStatus.OK);
//    }
//
//    @DeleteMapping("/user/delete/{id}")
//    public ResponseEntity<HttpStatus> deleteTodo(@PathVariable("id") Long id) { // her Long bir longtur ama her long bir Long degildir
//        userRepository.deleteById(id); // Sorgu geldigi zaman zaten frontend tarafinda id bulundugu icin var/yok bakmaya gerek yok
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // ?ASK
//    }
//    @DeleteMapping("/user/deleteAll")
//    public ResponseEntity<HttpStatus> deleteAllTodos() {
//        userRepository.deleteAll();
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // ?ASK
//    }
//    @PutMapping("/user/check/{id}")
//    public ResponseEntity<User> updateChecked(@PathVariable("id") Long id) {
//        Item checkChange = userRepository.findById(id).orElseThrow(() -> new ItemNotFoundException(id.toString()));
//        return new ResponseEntity<>(userRepository.save(checkChange.setChecked()), HttpStatus.OK);
//    }
}

// /register
// /login