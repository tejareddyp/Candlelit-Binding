package com.casestudy.webapp.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StaticController {

    @GetMapping("/about")
    public ModelAndView about() {
        ModelAndView response = new ModelAndView();
        response.setViewName("about");
        return response;

    }


    @GetMapping("/contact")
    public ModelAndView contact() {
        ModelAndView response = new ModelAndView();
        response.setViewName("contact");
        return response;

    }

    @GetMapping("/")
    public ModelAndView homePage() {
        ModelAndView response = new ModelAndView();
        response.setViewName("home");
        return response;

    }

    @GetMapping("/orderPlaced")
    public ModelAndView orderPlaced() {
        ModelAndView response = new ModelAndView();
        response.setViewName("orderPlaced");
        return response;
    }

    @GetMapping("/logoutSuccess")
    public ModelAndView logoutSuccess() {
        ModelAndView response = new ModelAndView();
        response.setViewName("logoutSuccess");
        return response;
    }
}

