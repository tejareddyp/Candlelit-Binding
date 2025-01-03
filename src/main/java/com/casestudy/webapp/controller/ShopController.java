package com.casestudy.webapp.controller;

import com.casestudy.webapp.database.dao.ProductsDAO;
import com.casestudy.webapp.database.entity.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ShopController {

    @Autowired
    ProductsDAO productsDAO;


    @GetMapping("/shop")
    public ModelAndView shop() {
        ModelAndView response = new ModelAndView();

        List<Products> productsList = productsDAO.findAllProducts();
        response.addObject("productsList", productsList);

        response.setViewName("shop");
        return response;
    }

}
