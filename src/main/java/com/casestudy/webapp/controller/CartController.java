package com.casestudy.webapp.controller;

import com.casestudy.webapp.database.dao.ProductsDAO;
import com.casestudy.webapp.database.entity.Products;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CartController {

    @Autowired
    private ProductsDAO productsDAO;

    @GetMapping("/cart")
    public ModelAndView cartPage() {
        ModelAndView response = new ModelAndView();

        List<Products> productsList = productsDAO.findAllProducts();
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        String productsJson = gson.toJson(productsList);

        response.addObject("productsList", productsJson);

        response.setViewName("cart");
        return response;

    }
}
