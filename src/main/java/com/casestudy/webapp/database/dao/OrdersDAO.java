package com.casestudy.webapp.database.dao;

import com.casestudy.webapp.database.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersDAO extends JpaRepository<Orders, Long> {
}
