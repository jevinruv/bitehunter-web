/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitehunter.bitehunter.dao;

import com.bitehunter.bitehunter.model.Meal;
import java.util.List;

/**
 *
 * @author Jevin
 */
public interface MenuDetailsDAO {

    public void updateMenu(int restaurantId, List<Meal> listMeal);
}
