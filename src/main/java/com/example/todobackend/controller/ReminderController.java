package com.example.todobackend.controller;


import com.example.todobackend.configuration.jwt.JwtUtils;
import com.example.todobackend.entity.Reminder;
import com.example.todobackend.entity.Token;
import com.example.todobackend.exception.ItemWithIdNotFoundException;
import com.example.todobackend.exception.ReminderWithIdNotFoundException;
import com.example.todobackend.log.InfoLogger;
import com.example.todobackend.repository.ItemRepository;
import com.example.todobackend.repository.ReminderRepository;
import com.example.todobackend.repository.TokenRepository;
import com.example.todobackend.requests.ReminderCreateRequest;
import com.example.todobackend.requests.ReminderUpdateRequest;
import com.example.todobackend.responses.ReminderCreateResponse;
import com.example.todobackend.responses.ReminderUpdateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reminder")
public class ReminderController {

    @Autowired
    private ReminderRepository reminderRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private TokenRepository tokenRepository;

    @Autowired
    private JwtUtils jwtUtils;

    @GetMapping("/{id}") // Get single reminder /reminder/adasdasd
    public ResponseEntity<Reminder> getReminder(@PathVariable("id") Long id) {
        return new ResponseEntity<>(reminderRepository.findById(id).orElseThrow(() -> new ReminderWithIdNotFoundException(id)), HttpStatus.OK);
    }

    @InfoLogger("Kullanici tum reminderlarini cekildi")
    @GetMapping("/todo/{item_id}") // Get all reminders by item id
    public ResponseEntity<List<Reminder>> getAllRemindersByItemId(@PathVariable("item_id") Long item_id) {
        return new ResponseEntity<>(reminderRepository.findAllByItemId(item_id).orElseThrow(() -> new ItemWithIdNotFoundException(item_id)), HttpStatus.OK);
    }

    @PostMapping("/create") // /reminder/adasdasd
    public ResponseEntity<ReminderCreateResponse> createReminder(@RequestHeader(HttpHeaders.AUTHORIZATION) String authToken, @RequestBody ReminderCreateRequest reminderCreateRequest) { // date
        String username = jwtUtils.getUserNameFromJwtToken(authToken);
        Token token = tokenRepository.findTokenByUser_Username(username).orElseThrow(); //!TODO

        return new ResponseEntity<>(itemRepository.findById(reminderCreateRequest.getItem_id()).map(item -> {
            Reminder resp = reminderRepository.save(reminderCreateRequest.createReminder(token, item)); // id date , item
            return new ReminderCreateResponse("Reminder olusturuldu", resp.getId());
            // return reminderRepository.save(reminderCreateRequest.createReminder(token, item)); // id date , item
        }).orElseThrow(() -> new ItemWithIdNotFoundException(reminderCreateRequest.getItem_id())), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<ReminderUpdateResponse> updateReminder(@RequestBody ReminderUpdateRequest reminderUpdateRequest) { // id, date
        return new ResponseEntity<>(reminderRepository.findById(reminderUpdateRequest.getId()).map(date -> { //map date olarak update edildi.
            date.setDate(reminderUpdateRequest.getDate());
            Reminder resp = reminderRepository.save(date);
            return new ReminderUpdateResponse("Reminder guncellendi", resp.getId());
            //return reminderRepository.save(date);
        }).orElseThrow(() -> new ReminderWithIdNotFoundException(reminderUpdateRequest.getId())), HttpStatus.OK);//neden burada .getıd deniyorda 47. satırda .getid denmiyor
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteReminder(@PathVariable("id") Long id) {
        reminderRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // ?AS
    }
}

//alt+j alt alta olan kelimelerin tümünü seçme kısayolu