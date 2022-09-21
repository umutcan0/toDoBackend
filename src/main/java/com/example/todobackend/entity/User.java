package com.example.todobackend.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user_cantodo")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name= "name")
    private String name;

    @Column(name= "surname")
    private String surname;

    @Column(name= "email", unique = true)
    private String email;

    @Column(name= "username", unique = true)
    private String username; //

    @Column(name= "password")
    private String password;

    @Column
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Token token;

    @Column
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Verified verified;


    @Column()
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<ItemList> lists = new HashSet<>(); // id = 6


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable (name="user_roles",
        joinColumns=@JoinColumn(name="user_id"),
        inverseJoinColumns=@JoinColumn(name="role_id"))
    private Set<Role> roles=new HashSet<>();

    public User(String username, String email, String password, String name, String surname) {
        this.username = username;
        this.email =email;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }

    public User() {

    }

    public Long getId() {
        return id;
    }

    public String getUsername() {return username;}

    public void setUsername(String username) {this.username = username;}

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surName) {
        this.surname = surName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void setRole(Role role) {
        this.roles.add(role);
    }

    public Verified getVerified() {return verified;}

    public void setVerified(Verified verified) {this.verified = verified;}
}


