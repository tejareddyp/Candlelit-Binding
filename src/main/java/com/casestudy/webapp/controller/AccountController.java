package com.casestudy.webapp.controller;

import com.casestudy.webapp.database.dao.OrderDetailsDAO;
import com.casestudy.webapp.database.dao.OrdersDAO;
import com.casestudy.webapp.database.dao.ProductsDAO;
import com.casestudy.webapp.database.dao.UserDAO;
import com.casestudy.webapp.database.entity.OrderDetails;
import com.casestudy.webapp.database.entity.Products;
import com.casestudy.webapp.database.entity.User;
import com.casestudy.webapp.security.AuthenticatedUserService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
public class AccountController {

    private final OrderDetailsDAO orderDetailsDAO;
    private final UserDAO userDAO;
    private final OrdersDAO ordersDAO;
    private final ProductsDAO productsDAO;

    public AccountController(OrderDetailsDAO orderDetailsDAO, UserDAO userDAO, OrdersDAO ordersDAO, ProductsDAO productsDAO) {
        this.orderDetailsDAO = orderDetailsDAO;
        this.userDAO = userDAO;
        this.ordersDAO = ordersDAO;
        this.productsDAO = productsDAO;
    }

    @GetMapping("/account")
    public ModelAndView account() {
        ModelAndView response = new ModelAndView();
        AuthenticatedUserService authenticatedUserService = new AuthenticatedUserService();
        String username = authenticatedUserService.getCurrentUsername();
        User user = userDAO.findByUsernameIgnoreCase(username);

        List<OrderDetails> orderDetailsList = orderDetailsDAO.findOrderDetailsByUserId(user.getId());
        System.out.println(orderDetailsList);

//        List<Orders> ordersList = ordersDAO.findByCustomerId(user.getId());
//        System.out.println(ordersList);

        List<List<String>> pastOrders = new ArrayList<>();
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

        orderDetailsList.forEach(orderDetail -> {
            List<String> pastOrder = new ArrayList<>();
            pastOrder.add(orderDetail.getProduct().getName());
            pastOrder.add(String.valueOf(orderDetail.getOrder().getOrderDate()));
            pastOrder.add(orderDetail.getQuantity().toString());
            pastOrder.add(orderDetail.getPrice().toString());
            pastOrders.add(pastOrder);
        });

        String orderDetailsJson = gson.toJson(pastOrders);
        System.out.println(orderDetailsJson);

        response.setViewName("account");
        response.addObject("orderDetailsJson", orderDetailsJson);
        return response;
    }
}
