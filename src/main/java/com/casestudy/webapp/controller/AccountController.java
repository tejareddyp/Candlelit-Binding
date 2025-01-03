package com.casestudy.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AccountController {

    @GetMapping("/account")
    public ModelAndView account() {
        ModelAndView response = new ModelAndView();

        response.setViewName("account");

        return response;
    }
}
