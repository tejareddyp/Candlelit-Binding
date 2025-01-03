package com.casestudy.webapp.controller;

import com.casestudy.webapp.database.dao.UserDAO;
import com.casestudy.webapp.database.entity.User;
import com.casestudy.webapp.form.SignUpFormBean;
import com.casestudy.webapp.security.AuthenticatedUserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private AuthenticatedUserService authenticatedUserService;

    @GetMapping("/login/login")
    public ModelAndView theLoginPage() {
        ModelAndView response = new ModelAndView();

        response.setViewName("login/login");

        return response;
    }

    @GetMapping("/login/createAccount")
    public ModelAndView signup() {
        ModelAndView response = new ModelAndView();

        response.setViewName("login/create");

        return response;
    }

    //we are doing this as a post and not a get
    @PostMapping("/login/createAccount")
    public ModelAndView signupSubmit(@Valid SignUpFormBean form, BindingResult bindingResult, HttpSession session) {
        ModelAndView response = new ModelAndView();

        response.setViewName("login/create");

        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getAllErrors());
            response.setViewName("login/create");
            response.addObject("bindingResult", bindingResult);
            response.addObject("form", form);

        } else {

            User user = new User();

            user.setEmail(form.getEmail());


            //first we need to encrypt the password before saving it to database
            String encryptedPassword = passwordEncoder.encode(form.getPassword());


            user.setPassword(encryptedPassword);

            user.setFirstName(form.getFirstname());

            user.setLastName(form.getLastname());

            user.setUsername(form.getUsername());

            userDAO.save(user);



            authenticatedUserService.changeLoggedInUsername(session, form.getUsername(),form.getPassword());


            response.setViewName("redirect:/");


        }

        return response;

    }


}
