package com.casestudy.webapp.controller;

import com.casestudy.webapp.database.dao.OrdersDAO;
import com.casestudy.webapp.database.dao.ProductsDAO;
import com.casestudy.webapp.database.dao.UserDAO;
import com.casestudy.webapp.database.entity.*;
import com.casestudy.webapp.form.CheckoutBean;
import com.casestudy.webapp.security.AuthenticatedUserService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class CheckoutController {

    private final ProductsDAO productsDAO;
    private final OrdersDAO ordersDAO;
    private final UserDAO userDAO;

    public CheckoutController(ProductsDAO productsDAO, OrdersDAO ordersDAO, UserDAO userDAO) {
        this.productsDAO = productsDAO;
        this.ordersDAO = ordersDAO;
        this.userDAO = userDAO;
    }

    @GetMapping("/checkout")
    public ModelAndView checkoutPage() {
        ModelAndView response = new ModelAndView();

        response.setViewName("checkout");

        return response;
    }

    @PostMapping("/checkout")
    public ModelAndView checkout(@Valid CheckoutBean form) {
        ModelAndView response = new ModelAndView();
        AuthenticatedUserService authenticatedUserService = new AuthenticatedUserService();
        String username = authenticatedUserService.getCurrentUsername();


        // converting cart from string to 2d array, 1st element is product id and second is quantity
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        Object[][] cart = gson.fromJson(form.getCart(), Object[][].class);

        Orders order = new Orders();
        User customer = userDAO.findByUsernameIgnoreCase(username);
        double totalPrice = 0;
        for (Object[] cartItem : cart) {
            Integer productId = Integer.parseInt(cartItem[0].toString());
            OrderDetailsId orderDetailsId = new OrderDetailsId(order.getId(), productId);
            Products product = productsDAO.findProductsById(productId);
            OrderDetails detail = new OrderDetails();
            detail.setId(orderDetailsId);
            detail.setOrder(order);
            detail.setProduct(product);
            detail.setQuantity((int)Double.parseDouble(cartItem[1].toString()));
            detail.setPrice(product.getPrice());
            totalPrice += product.getPrice() * detail.getQuantity();

            order.getOrderDetails().add(detail);
        }

        order.setUser(customer);
        order.setOrderDate(Date.from(Instant.now()));
        order.setTotalPrice(totalPrice);
        order.setName(form.getName());
        order.setNotes(form.getNotes());
        order.setAddress(form.getAddress());
        order.setCustomerId(customer.getId());

        ordersDAO.save(order);

        response.setViewName("checkout");
        response.addObject("checkoutComplete", "true");

        List<Products> productsList = productsDAO.findAllProducts();
        String productsJson = gson.toJson(productsList);

        response.addObject("productsList", productsJson);
        response.addObject("username", username);
        response.addObject("name", form.getName());
        response.addObject("address", form.getAddress());
        response.addObject("notes", form.getNotes());
        return response;
    }
}
