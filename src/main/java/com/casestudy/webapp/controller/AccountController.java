package com.casestudy.webapp.controller;

import com.casestudy.webapp.database.dao.OrderDetailsDAO;
import com.casestudy.webapp.database.dao.OrdersDAO;
import com.casestudy.webapp.database.dao.UserDAO;
import com.casestudy.webapp.database.entity.OrderDetails;
import com.casestudy.webapp.database.entity.Orders;
import com.casestudy.webapp.database.entity.User;
import com.casestudy.webapp.security.AuthenticatedUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AccountController {

    private final OrderDetailsDAO orderDetailsDAO;
    private final UserDAO userDAO;
    private final OrdersDAO ordersDAO;

    public AccountController(OrderDetailsDAO orderDetailsDAO, UserDAO userDAO, OrdersDAO ordersDAO) {
        this.orderDetailsDAO = orderDetailsDAO;
        this.userDAO = userDAO;
        this.ordersDAO = ordersDAO;
    }

    @GetMapping("/account")
    public ModelAndView account() {
        ModelAndView response = new ModelAndView();
        AuthenticatedUserService authenticatedUserService = new AuthenticatedUserService();
        String username = authenticatedUserService.getCurrentUsername();
        User user = userDAO.findByUsernameIgnoreCase(username);

        List<OrderDetails> orderDetailsList = orderDetailsDAO.findOrderDetailsByUserId(user.getId());
        System.out.println(orderDetailsList);

        List<Orders> ordersList = ordersDAO.findByCustomerId(user.getId());
        System.out.println(ordersList);

        response.setViewName("account");

        return response;
    }
}
