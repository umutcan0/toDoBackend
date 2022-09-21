package com.example.todobackend.repository;

import com.example.todobackend.entity.Item;
import com.example.todobackend.entity.Reminder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;


public interface ReminderRepository extends JpaRepository<Reminder, Long> {

    Optional<List<Reminder>> findAllByItemId(Long item_id); // findAllByItemID ____ ==> snake case aBasdCsdfsdf => camelCase
    List<Reminder> findAllByDate(Date date); // select DATE from reminders where date=date

}


//public T returnSomething(T abc){ // Generic
//    ...
//    return abc;
//}
//