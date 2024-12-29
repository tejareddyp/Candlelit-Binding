package com.casestudy.webapp.database.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table( name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column( name = "first_name")
    private String firstName;

    @Column( name = "last_name")
    private String lastName;

    @Column( name = "email")
    private String email;

    @Column( name = "password")
    private String password;

    @Column( name = "address_line1")
    private String addressLine1;

    @Column( name = "address_line2")
    private String addressLine2;

    @Column( name = "city")
    private String city;

    @Column( name = "state")
    private String state;

    @Column( name = "zip")
    private Integer zip;

    @Column( name = "phone")
    private String phone;

    @Column( name = "username")
    private String userName;
}
