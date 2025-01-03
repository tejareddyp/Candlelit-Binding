package com.casestudy.webapp.database.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@Table( name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "id")
    private Integer id;

    @ManyToMany
    @JoinTable(
            name = "order_details",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private Set<Products> products = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn( name = "customer_id", insertable = false, updatable = false)
    @ToString.Exclude
    private User user;


    @Column( name = "customer_id")
    private Integer customerId;

    @Column( name = "order_date", columnDefinition = "DATE")
    private Date orderDate;

    @Column( name = "shipped_date", columnDefinition = "DATE")
    private Date shippedDate;

    @Column( name = "status")
    private String status;

    @Column( name = "total_price", columnDefinition = "DECIMAL")
    private double totalPrice;

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


}
