package com.example.todobackend.schedules;

import com.example.todobackend.repository.ReminderRepository;
import com.example.todobackend.configuration.services.FirebaseMessagingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SendReminderNotification {

    @Autowired
    private ReminderRepository reminderRepository;

    @Autowired
    private FirebaseMessagingService firebaseMessagingService;

//    @Scheduled(cron="0 0/30 * * * * ?")
//    public void reportCurrentTime() {
//        List<Reminder> reminders = reminderRepository.findAllByDate(new Date()); // [ Reminder, Reminder, Reminder ]
//        for(Reminder reminder: reminders) {
//            Item item = reminder.getItem();
//            try {
//                firebaseMessagingService.sendNotification(item, "");
//            } catch (FirebaseMessagingException ex) {
//
//            }
//        }
//    }
}
