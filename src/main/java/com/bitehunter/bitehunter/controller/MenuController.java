/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitehunter.bitehunter.controller;

import com.bitehunter.bitehunter.dao.MenuDetailsDAO;
import com.bitehunter.bitehunter.model.Meal;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Ludowica
 */
@Controller
public class MenuController {

    @Autowired
    private MenuDetailsDAO menuDetailsDAO;

    @RequestMapping(value = "/update_menu", method = RequestMethod.POST)
    public ModelAndView updateMenu(
            ModelAndView model,
            @RequestParam("restaurantId") String restaurantId) {

        model.addObject("restaurantId", restaurantId);//pass restaurant id
        model.setViewName("update_menu");//pass view to display
        return model;
    }

    @RequestMapping(value = "/update_menu_save", method = RequestMethod.POST)
    public ModelAndView updateMenuSave(
            ModelAndView model,
            @RequestParam("menu") String menu,  //get json array as string 
            @RequestParam("restaurantId") String restaurantId
    ) {

        try {
            //convert json array into meal objects and add to list
            ObjectMapper mapper = new ObjectMapper();
            List<Meal> listMeal = mapper.readValue(menu, new TypeReference<List<Meal>>() {
            });

            //execute database update passing restaurant id and meal list
            menuDetailsDAO.updateMenu(Integer.parseInt(restaurantId), listMeal);

            model.setViewName("admin_homepage");//pass view to display
        } catch (IOException ex) {
        }

        return model;
    }
}
