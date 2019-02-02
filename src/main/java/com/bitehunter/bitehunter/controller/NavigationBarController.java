/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitehunter.bitehunter.controller;

import java.io.IOException;
import org.springframework.stereotype.Controller;
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
public class NavigationBarController {


    @RequestMapping(value = "/manage_reservations", method = RequestMethod.GET)
    public ModelAndView manageReservations(ModelAndView model) throws IOException {
        model.setViewName("manage_reservations");
        return model;
    }
}
