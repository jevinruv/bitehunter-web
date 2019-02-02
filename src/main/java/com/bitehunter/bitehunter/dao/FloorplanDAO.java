/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitehunter.bitehunter.dao;

import com.bitehunter.bitehunter.model.RestaurantTable;
import java.util.List;

/**
 *
 * @author Jevin
 */
public interface FloorplanDAO {

    public void updateFloorplan(int restaurantId, List<RestaurantTable> listRestaurantTables);
}
