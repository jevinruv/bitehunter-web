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
public class LogoutController {

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView table(ModelAndView model, @ModelAttribute User user) throws IOException {

        user = null;
        user = new User();
        model.addObject("user", user);
        model.setViewName("index");
        return model;
    }

}
