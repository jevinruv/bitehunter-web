/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitehunter.bitehunter.dao;

import com.bitehunter.bitehunter.model.Meal;
import com.bitehunter.bitehunter.model.RestaurantDetails;
import com.bitehunter.bitehunter.model.RestaurantTable;
import java.util.List;

/**
 *
 * @author Jevin
 */
public interface RestaurantDetailsDAO {

    int saveRestaurant(RestaurantDetails restaurantDetails);

    int addRestaurantDetails(RestaurantDetails restaurantDetails);

    int addFloorplan(int restaurantId, List<RestaurantTable> restaurantTables);

    int addMenu(int restaurantId, List<Meal> meals);
}
