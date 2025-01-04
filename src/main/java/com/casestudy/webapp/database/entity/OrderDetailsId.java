package com.casestudy.webapp.database.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
@ToString
public class OrderDetailsId implements Serializable {
    private Integer orderId;
    private Integer productId;

    // Default constructor
    public OrderDetailsId() {}

    // Constructor
    public OrderDetailsId(Integer orderId, Integer productId) {
        this.orderId = orderId;
        this.productId = productId;
    }

    // hashCode and equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetailsId that = (OrderDetailsId) o;
        return Objects.equals(orderId, that.orderId) && Objects.equals(productId, that.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, productId);
    }
}

