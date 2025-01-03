package com.casestudy.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PurchaseHistoryController {

    @GetMapping("/purchaseHistory")
    public ModelAndView purchaseHistory() {
        ModelAndView response = new ModelAndView();

        response.setViewName("purchaseHistory");

        return response;
    }
}
