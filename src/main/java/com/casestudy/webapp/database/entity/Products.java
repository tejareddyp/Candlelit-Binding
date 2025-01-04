package com.casestudy.webapp.database.entity;

import com.google.gson.annotations.Expose;
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
    @Expose
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "id")
    private Integer id;

    @ManyToMany(mappedBy = "products")
    @ToString.Exclude
    private Set<Orders> orders = new HashSet<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private Set<OrderDetails> orderDetails = new HashSet<>();

    @Column( name = "name")
    @Expose
    private String name;

    @Column( name = "stock")
    @Expose
    private String stock;

    @Column( name = "price", columnDefinition = "DECIMAL")
    @Expose
    private double price;
}
