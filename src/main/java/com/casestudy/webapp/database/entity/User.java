package com.casestudy.webapp.database.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
@Table( name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Orders> orders;

    @Column( name = "first_name")
    private String firstName;

    @Column( name = "last_name")
    private String lastName;

    @Column( name = "email", unique = true, nullable = false)
    private String email;

    @Column( name = "password", nullable = false)
    private String password;

    @Column( name = "username",nullable = false,unique = true)
    private String username;


}
