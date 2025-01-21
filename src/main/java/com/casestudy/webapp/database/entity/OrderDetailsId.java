package com.casestudy.webapp.database.entity;

import jakarta.persistence.Embeddable;
import lombok.*;
import org.apache.logging.log4j.util.Cast;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailsId implements Serializable {
    private Integer orderId;
    private Integer productId;


    // hashCode and equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        //Cast the input object (`o`) to the expected type (`OrderDetailsId`)
        OrderDetailsId that = (OrderDetailsId) o;
        return Objects.equals(orderId, that.orderId) && Objects.equals(productId, that.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, productId);
    }
}

