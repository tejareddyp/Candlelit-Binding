package com.casestudy.webapp.database.dao;

import com.casestudy.webapp.database.entity.OrderDetails;
import com.casestudy.webapp.database.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderDetailsDAO extends JpaRepository<Orders, Long> {

    @Query(value = "select od from Orders o left join OrderDetails od on(od.id.orderId = o.id) where o.customerId = :userId")
    List<OrderDetails> findOrderDetailsByUserId(int userId);

}
