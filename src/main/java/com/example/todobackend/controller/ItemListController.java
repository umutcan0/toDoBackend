package com.example.todobackend.controller;

import com.example.todobackend.configuration.jwt.JwtUtils;
import com.example.todobackend.configuration.services.UserDetailsImpl;
import com.example.todobackend.entity.ItemList;
import com.example.todobackend.entity.Reminder;
import com.example.todobackend.exception.*;
import com.example.todobackend.repository.ItemListRepository;
import com.example.todobackend.repository.ItemRepository;
import com.example.todobackend.repository.ReminderRepository;
import com.example.todobackend.repository.UserRepository;
import com.example.todobackend.requests.ItemListCreateRequest;
import com.example.todobackend.requests.ItemListUpdateRequest;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/itemlist")
public class ItemListController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ItemListRepository itemListRepository;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private MessageSource messageSource;


    @GetMapping("/{id}") // Get single reminder /reminder/adasdasd
    public ResponseEntity<ItemList> getByItemListId(@PathVariable("id") Long id) { // ItemList id'sine gore cekme
        return new ResponseEntity<>(
                itemListRepository.findById(id).orElseThrow(() -> new ItemListWithIdNotFoundException(id)),
                HttpStatus.OK);
    }

    @GetMapping("/owner/{owner_id}") // JWT token ile yapilacak
    public ResponseEntity<List<ItemList>> getAllItemListsByOwnerId(@PathVariable("owner_id") Long owner_id) {
        return new ResponseEntity<>(
                itemListRepository.findAllByOwnerId(owner_id).orElseThrow(() -> new UserWithIdNotFoundException(owner_id))
                , HttpStatus.OK);
    }
    @GetMapping("/search/{name}") // Get all reminders by item id
    public ResponseEntity<List<ItemList>> getAllItemListsByName(@PathVariable("name")String name) {
        return new ResponseEntity<>(
                itemListRepository.findByNameContaining(name).orElseThrow(() -> new ItemListWithNameNotFoundException(name))
                , HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<ItemList> createItemList(@RequestHeader(HttpHeaders.AUTHORIZATION) String authToken, @RequestBody ItemListCreateRequest itemListCreateRequest) { // @RequestHeader( value="Authorization")
        String username = jwtUtils.getUserNameFromJwtToken(authToken); //umut, 1, umut@gmail.com // authToken -> "Bearer sdfjghsdfhgksdfgsdfg"
        // her bir jwtToken bir authorization tokenidir
        // authentication -> bi siteye giris yapmak
        // authorization -> bi sitede yetkiye sahip olmak

        // itemlist adi gonderilecek
        // itemlist adi 2 ile 40 karakter
        ItemList itemList = itemListCreateRequest.getAsItemList();
        return new ResponseEntity<>(userRepository.findByUsername(username).map(user -> {
            itemList.setOwner(user);
            return itemListRepository.save(itemList);
        })
                .orElseThrow(() -> new UsernameNotFoundException(username))
                , HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<ItemList> updateItemList(@RequestBody ItemListUpdateRequest itemListUpdateRequest) { // id, date
        return new ResponseEntity<>(itemListRepository.findById(itemListUpdateRequest.getId()).map(existingItemList -> {
                    existingItemList.setListName(itemListUpdateRequest.getListName());
            return itemListRepository.save(existingItemList);
        })
                .orElseThrow(() -> new ItemListWithIdNotFoundException(itemListUpdateRequest.getId())), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteItemList(@PathVariable("id") Long id, @RequestHeader(HttpHeaders.ACCEPT_LANGUAGE) Locale locale) {//HTTP status string yapld neden
        itemListRepository.deleteById(id);
        return new ResponseEntity<>(messageSource.getMessage("{validation.delete}",null, locale), HttpStatus.NO_CONTENT); // ?AS
    }
}