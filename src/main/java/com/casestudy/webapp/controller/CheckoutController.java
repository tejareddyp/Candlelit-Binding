package com.casestudy.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CheckoutController {

    @GetMapping("/checkout")
    public ModelAndView checkout() {
        ModelAndView response = new ModelAndView();

        response.setViewName("checkout");

        return response;
    }

    @PostMapping("/checkout")
    public ModelAndView checkoutPage() {
        ModelAndView response = new ModelAndView();
        response.setViewName("checkout");
        return response;
    }
}
