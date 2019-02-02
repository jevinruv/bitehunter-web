/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitehunter.bitehunter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Jevin
 */
@Controller
public class ReservationController {

    @RequestMapping(value = "/view_reservations", method = RequestMethod.POST)
    public ModelAndView viewReservations(
            ModelAndView model, 
            @RequestParam("restaurantId") String restaurantId) {
        
        model.addObject("restaurantId", restaurantId);
        model.setViewName("view_reservations");
        return model;
    }

}
