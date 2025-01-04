package com.casestudy.webapp.database.dao;

import com.casestudy.webapp.database.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdersDAO extends JpaRepository<Orders, Long> {
    List<Orders> findByCustomerId(int customerId);

    Orders findById(int orderId);
}
