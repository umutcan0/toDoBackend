package com.example.todobackend.controller;

import com.example.todobackend.configuration.WebSecurityConfig;
import com.example.todobackend.configuration.jwt.JwtUtils;
import com.example.todobackend.entity.Item;
import com.example.todobackend.entity.ItemList;
import com.example.todobackend.entity.User;
import com.example.todobackend.exception.ItemListWithIdNotFoundException;
import com.example.todobackend.exception.ItemWithIdNotFoundException;
import com.example.todobackend.exception.ItemWithNameNotFoundException;
import com.example.todobackend.log.InfoLogger;
import com.example.todobackend.repository.ItemListRepository;
import com.example.todobackend.repository.ItemRepository;
import com.example.todobackend.repository.TokenRepository;
import com.example.todobackend.repository.UserRepository;
import com.example.todobackend.requests.ItemCreateRequest;
import com.example.todobackend.requests.ItemUpdateRequest;
import com.example.todobackend.responses.ItemCreateResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/item")
public class ItemController {
    private static final Logger logger = LoggerFactory.getLogger(ItemController.class);
    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ItemListRepository itemListRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private JwtUtils jwtUtils;

    @GetMapping("/todos") // Gets all
    public ResponseEntity<List<Item>> getAllTodos() {
        return new ResponseEntity<>(itemRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/todos/{name}") //GetWithName
    public ResponseEntity<List<Item>> getTodoByName(@PathVariable("name") String name) {
        logger.debug(name);
        return new ResponseEntity<>(itemRepository.findByNameContaining(name).orElseThrow(() -> {
            throw new ItemWithNameNotFoundException(name);
        }), HttpStatus.OK);
    }
    @InfoLogger("Item olusturuldu")
    @PostMapping("/todos/create")

    public ResponseEntity<ItemCreateResponse> createItem(@RequestHeader(HttpHeaders.AUTHORIZATION) String authToken, @Valid @RequestBody ItemCreateRequest itemCreateRequest) { // name description CreateTodoRequest (name desc, itemlistId)
        String username = jwtUtils.getUserNameFromJwtToken(authToken);
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));

        return new ResponseEntity<>(itemListRepository.findById(itemCreateRequest.getItemList_id()).map(itemList -> {
            Item resp = itemRepository.save(itemCreateRequest.createItem(user, itemList)); // id date , item
            return new ItemCreateResponse("Item olusturuldu", resp.getId());
        }).orElseThrow(() -> new ItemWithIdNotFoundException(itemCreateRequest.getItemList_id())), HttpStatus.OK);
    }
    @InfoLogger("Item guncellendi")
    @PutMapping("/todos/update/{id}")
    public ResponseEntity<Item> updateTodo(@RequestBody ItemUpdateRequest itemUpdateRequest) {
/*
        return new ResponseEntity<>(itemRepository.save(item), HttpStatus.OK);
*/

        return new ResponseEntity<>(itemRepository.findById(itemUpdateRequest.getId()).map(existingItem -> {
                    existingItem.setName(itemUpdateRequest.getName());
                    return itemRepository.save(existingItem);
                })
                .orElseThrow(() -> new ItemListWithIdNotFoundException(itemUpdateRequest.getId())), HttpStatus.OK);
    }
    @InfoLogger("Item silindi")
    @DeleteMapping("/todos/delete/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable("id") Long id, @RequestHeader(HttpHeaders.ACCEPT_LANGUAGE) Locale locale) { // her Long bir longtur ama her long bir Long degildir
        itemRepository.deleteById(id); // Sorgu geldigi zaman zaten frontend tarafinda id bulundugu icin var/yok bakmaya gerek yok
        return new ResponseEntity<>(messageSource.getMessage("{validation.delete}",null, locale),HttpStatus.NO_CONTENT); // ?ASK
    }
    @InfoLogger("Tum itemlar silindi")
    @DeleteMapping("/todos/deleteAll")
    public ResponseEntity<String> deleteAllTodos(@RequestHeader(HttpHeaders.ACCEPT_LANGUAGE) Locale locale) {
        itemRepository.deleteAll();
        return new ResponseEntity<>(messageSource.getMessage("{validation.allDelete}",null, locale), HttpStatus.NO_CONTENT); // ?ASK
    }
    @PutMapping("/todos/check/{id}") // Burada tikli ise şu mesajı tik yoksa şu mesajı ver şeklinde bir şey yapılsın mı
    public ResponseEntity<Item> updateChecked(@PathVariable("id") Long id) {
        Item checkChange = itemRepository.findById(id).orElseThrow(() -> {
            throw new ItemWithIdNotFoundException(id);
        });
        return new ResponseEntity<>(itemRepository.save(checkChange.setChecked()), HttpStatus.OK);
    }
}