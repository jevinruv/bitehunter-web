/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitehunter.bitehunter.controller;

import com.bitehunter.bitehunter.dao.UserDAO;
import com.bitehunter.bitehunter.model.User;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Jevin
 */
@Controller
@SessionAttributes("user")
public class LoginController {

    @Autowired
    private UserDAO userDAO;    //for database transactions

    //load index page
    @RequestMapping(value = "/")
    public ModelAndView loadIndex(ModelAndView model) throws IOException {
        User user = new User();
        model.addObject("user", user);
        model.setViewName("index");
        return model;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView isUserExist(ModelAndView model, @ModelAttribute User loginUser) throws IOException {
        User user = userDAO.isUserExist(loginUser);

        //if user exist
        if (user != null) {

            //set view name depending on the user type
            if (user.getUserType().equalsIgnoreCase("manager")) {
                model.setViewName("manager_homepage");
            } else if (user.getUserType().equalsIgnoreCase("chef")) {
                model.setViewName("chef_homepage");
            } else if (user.getUserType().equalsIgnoreCase("admin")) {
                model.setViewName("admin_homepage");
            }

            //add user session to the model to be passed
            model.addObject("user", user);
        }
        
         //if user does not exist       
        else {
            model.addObject("user", new User());    //add new user object
            model.setViewName("index");
        }

        return model;
    }

    @RequestMapping(value = "not_logged", method = RequestMethod.GET)
    public ModelAndView table(ModelAndView model) throws IOException {
        model.setViewName("error_page_not_logged_in");
        return model;
    }
}
