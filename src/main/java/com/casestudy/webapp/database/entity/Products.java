package com.casestudy.webapp.database.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@Table( name = "products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "id")
    private Integer id;

    @ManyToMany(mappedBy = "products")
    private Set<Orders> orders = new HashSet<>();

    @Column( name = "name")
    private String name;

    @Column( name = "stock")
    private String stock;

    @Column( name = "price", columnDefinition = "DECIMAL")
    private double price;
}
