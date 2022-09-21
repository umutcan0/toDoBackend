package com.example.todobackend.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole type;



    public Role(ERole type) {
        this.type = type;
    }

    public Role() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ERole getType() {
        return type;
    }

    public void setType(ERole type) {
        this.type = type;
    }

}
