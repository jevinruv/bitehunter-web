/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitehunter.bitehunter.dao;

import com.bitehunter.bitehunter.model.Meal;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Jevin
 */
public class MenuDetailsDAOImpl implements MenuDetailsDAO {

    private JdbcTemplate jdbcTemplate;

    public MenuDetailsDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void updateMenu(int restaurantId, List<Meal> listMeal) {
        
        //first delete the restaurant menu
        deleteMenu(restaurantId);
                
        //add new menu
        for (Meal meal : listMeal) {

            try {
                // insert
                String sql = "INSERT INTO meals (restaurant_id, meal_id, meal_name, meal_price, meal_image, meal_description)"
                        + " VALUES (?, ?, ?, ?, ?, ?)";

                jdbcTemplate.update(sql,
                        restaurantId,
                        meal.getMealId(),
                        meal.getMealName(),
                        meal.getMealPrice(),
                        meal.getMealImage(),
                        meal.getMealDescription()
                );
            } catch (DataAccessException er) {
                System.out.println(er);
            }
        }
    }

    public void deleteMenu(int restaurantId) {
        try {
            jdbcTemplate.update("DELETE FROM meals WHERE restaurant_id = ?", new Object[]{restaurantId});

        } catch (DataAccessException er) {
            System.out.println(er);
        }
    }

}
