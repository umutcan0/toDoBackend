package com.example.todobackend.configuration.services;

import com.example.todobackend.entity.Item;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import org.springframework.stereotype.Service;

@Service
public class FirebaseMessagingService {
    private final FirebaseMessaging firebaseMessaging;

    public FirebaseMessagingService(FirebaseMessaging firebaseMessaging) {
        this.firebaseMessaging = firebaseMessaging;
    }

    public String sendNotification(Item item, String token) throws FirebaseMessagingException { // firebase cloud messaging token

        Notification notification = Notification
                .builder()
                .setTitle(item.getName())
                .setBody(item.getDescription())
                .build();

        Message message = Message
                .builder()
                .setToken(token)
                .setNotification(notification)
                .build();

        return firebaseMessaging.send(message);
    }
}
