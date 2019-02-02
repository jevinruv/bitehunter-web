/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitehunter.bitehunter.controller;

import com.bitehunter.bitehunter.dao.FloorplanDAO;
import com.bitehunter.bitehunter.model.RestaurantTable;
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
 * @author Jevin
 */
@Controller
public class FloorplanController {

    @Autowired
    private FloorplanDAO floorplanDAO;

    @RequestMapping(value = "/update_floorplan", method = RequestMethod.POST)
    public ModelAndView updateFloorplan(
            ModelAndView model,
            @RequestParam("restaurantId") String restaurantId
    ) {

        model.addObject("restaurantId", restaurantId);   //pass restaurant id
        model.setViewName("update_floorplan");  //pass view to display
        return model;
    }

    @RequestMapping(value = "/update_floorplan_save", method = RequestMethod.POST)
    public ModelAndView updateFloorplanSave(
            ModelAndView model,
            @RequestParam("floorplan") String floorplan,    //get json array as string
            @RequestParam("restaurantId") String restaurantId
    ) {

        try {
            //convert json array into restaurant objects and add to list
            ObjectMapper mapper = new ObjectMapper();
            List<RestaurantTable> listRestaurantTables 
			= mapper.readValue(floorplan, new TypeReference<List<RestaurantTable>>() {
            });

            //execute database update passing restaurant id and restaurant table list
            floorplanDAO.updateFloorplan(Integer.parseInt(restaurantId), listRestaurantTables);

            model.setViewName("admin_homepage"); //pass view to display
        } catch (IOException ex) {
            System.out.println(ex);
        }

        return model;
    }
}
