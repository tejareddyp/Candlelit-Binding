package com.casestudy.webapp.database.dao;

import com.casestudy.webapp.database.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdersDAO extends JpaRepository<Orders, Long> {

    Orders findById(Integer Id);


}
