/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitehunter.bitehunter.controller;

import com.bitehunter.bitehunter.model.User;
import java.io.IOException;
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
public class SideBarController {

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView loadHome(ModelAndView model, @ModelAttribute User user) throws IOException {

        String page = null;

        switch (user.getUserType()) {

            case "admin":
                page = "admin_homepage";
                break;

            case "chef":
                page = "chef_homepage";
                break;

            case "manager":
                page = "manager_homepage";
                break;
        }

        model.setViewName(page);
        return model;
    }
}
