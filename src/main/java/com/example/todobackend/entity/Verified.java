package com.example.todobackend.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "verified_cantodo")
public class Verified {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private Boolean send;
    @Column
    private Boolean approved;
    @Column
    private Long verificationSlug = (long) ((Math.random() * (1 - 10000)) + 1);

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    public Verified(Boolean send, Long verificationSlug, Boolean approved, User user) {
        this.send = send;
        this.verificationSlug = verificationSlug;
        this.approved = approved;
        this.user = user;
    }

    public Verified() {

    }

}
