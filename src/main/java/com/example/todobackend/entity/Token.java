package com.example.todobackend.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "token_cantodo")
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name= "fcm_token")
    private String fcm_token;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @Column()
    @OneToMany(mappedBy = "token", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Reminder> reminders = new HashSet<>(); // id = 6

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFcm_token() {
        return fcm_token;
    }

    public void setFcm_token(String fcm_token) {
        this.fcm_token = fcm_token;
    }

    public User getUser() {return user;}

    public void setUser(User ownerr) {this.user = user;}
}
