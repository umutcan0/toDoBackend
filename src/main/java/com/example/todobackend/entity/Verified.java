package com.example.todobackend.entity;


import javax.persistence.*;

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
    private Long verificationSlug= (long) ((Math.random() * (1 - 10000)) + 1);

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    public Verified(Boolean send, Long verificationSlug,Boolean approved, User user){
        this.send=send;
        this.verificationSlug=verificationSlug;
        this.approved = approved;
        this.user=user;
    }

    public Verified() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getSend() {
        return send;
    }

    public void setSend(Boolean send) {
        this.send = send;
    }

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    public User getUser() {return user;}

    public void setUser(User user) {this.user = user;}

    public Long getVerificationSlug() {return verificationSlug;}

    public void setVerificationSlug(Long verificationSlug) {this.verificationSlug = verificationSlug;}
}
