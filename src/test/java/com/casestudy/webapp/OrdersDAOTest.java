package com.casestudy.webapp;

import com.casestudy.webapp.database.dao.OrdersDAO;
import com.casestudy.webapp.database.entity.Orders;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OrdersDAOTest {

    @Autowired
    private OrdersDAO ordersDAO;

    @Test
    public void testFindById() {

        int orderId = 1;

        Orders order = ordersDAO.findById(orderId);

        Assertions.assertEquals(orderId,order.getId());
        Assertions.assertEquals(7, order.getCustomerId());
        Assertions.assertEquals("a",order.getName());

    }
}
