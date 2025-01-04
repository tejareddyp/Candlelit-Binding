package com.casestudy.webapp.database.entity;

import com.google.gson.annotations.Expose;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name = "order_details")
public class OrderDetails {
    @EmbeddedId
    private OrderDetailsId id;

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "order_id", nullable = false)
    @ToString.Exclude
    private Orders order;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id", nullable = false)
    @ToString.Exclude
    private Products product;

    @Expose
    @Column( name = "quantity")
    private Integer quantity;

    @Expose
    @Column( name = "price",columnDefinition = "DECIMAL")
    private Double price;
}
