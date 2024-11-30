package com.femas.belajar.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false, name = "name")
    private String name;

    @Column(nullable = false, name = "email")
    private String email;
}
