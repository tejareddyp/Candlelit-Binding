package com.casestudy.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProfileController {

    @GetMapping("/profile")
    public ModelAndView profile() {
        ModelAndView response = new ModelAndView();

        response.setViewName("profile");

        return response;
    }
}
