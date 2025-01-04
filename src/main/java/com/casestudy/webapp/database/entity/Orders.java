package com.casestudy.webapp.database.entity;

import com.google.gson.annotations.Expose;
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
    @Expose
    private Integer id;

    @ManyToMany
    @JoinTable(
            name = "order_details",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    @ToString.Exclude
    private Set<Products> products = new HashSet<>();

    @ToString.Exclude
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<OrderDetails> orderDetails = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn( name = "customer_id", insertable = false, updatable = false)
    @ToString.Exclude
    private User user;


    @Column( name = "customer_id")
    @Expose
    private Integer customerId;

    @Column( name = "order_date", columnDefinition = "DATE")
    @Expose
    private Date orderDate;

    @Column( name = "total_price", columnDefinition = "DECIMAL")
    @Expose
    private double totalPrice;

    @Column( name = "address")
    @Expose
    private String address;

    @Column( name = "name")
    @Expose
    private String name;

    @Column( name = "notes")
    @Expose
    private String notes;
}
