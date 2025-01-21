package com.casestudy.webapp.controller;

import com.casestudy.webapp.database.dao.OrderDetailsDAO;

import com.casestudy.webapp.database.dao.UserDAO;
import com.casestudy.webapp.database.entity.OrderDetails;

import com.casestudy.webapp.database.entity.User;
import com.casestudy.webapp.security.AuthenticatedUserService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Slf4j
@Controller
public class AccountController {

    @Autowired
    private OrderDetailsDAO orderDetailsDAO;

    @Autowired
    private UserDAO userDAO;


    @PreAuthorize("isAuthenticated()")
    @GetMapping("/account")
    public ModelAndView account() {
        ModelAndView response = new ModelAndView();
        AuthenticatedUserService authenticatedUserService = new AuthenticatedUserService();
        String username = authenticatedUserService.getCurrentUsername();
        User user = userDAO.findByUsernameIgnoreCase(username);


        List<OrderDetails> orderDetailsList = orderDetailsDAO.findOrderDetailsByUserId(user.getId());


        List<List<String>> pastOrders = new ArrayList<>();
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

        orderDetailsList.stream().forEach(orderDetail -> {
            List<String> pastOrder = new ArrayList<>();
            pastOrder.add(orderDetail.getProduct().getName());
            pastOrder.add(String.valueOf(orderDetail.getOrder().getOrderDate()));
            pastOrder.add(orderDetail.getQuantity().toString());
            pastOrder.add(orderDetail.getPrice().toString());
            pastOrders.add(pastOrder);
        });

        String orderDetailsJson = gson.toJson(pastOrders);

        log.info("Found orders for user: " + orderDetailsJson);

        response.setViewName("account");
        response.addObject("orderDetailsJson", orderDetailsJson);
        return response;
    }
}
