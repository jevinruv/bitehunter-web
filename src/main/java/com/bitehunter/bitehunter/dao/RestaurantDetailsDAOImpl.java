/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitehunter.bitehunter.dao;

import com.bitehunter.bitehunter.model.Meal;
import com.bitehunter.bitehunter.model.RestaurantDetails;
import com.bitehunter.bitehunter.model.RestaurantTable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

/**
 *
 * @author Jevin
 */
public class RestaurantDetailsDAOImpl implements RestaurantDetailsDAO {

    private JdbcTemplate jdbcTemplate;

    public RestaurantDetailsDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int addRestaurantDetails(final RestaurantDetails restaurantDetails) {
        final String sql = "INSERT INTO restaurants (restaurant_name, restaurant_image, table_count, time_open, time_close, restaurant_description)"
                + " VALUES (?, ?, ?, ?, ?, ?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {

                PreparedStatement pst = con.prepareStatement(sql, new String[]{"restaurant_id"});
                pst.setString(1, restaurantDetails.getRestaurantName());
                pst.setString(2, restaurantDetails.getRestaurantImage());
                pst.setInt(3, restaurantDetails.getTableCount());
                pst.setString(4, restaurantDetails.getTimeOpen());
                pst.setString(5, restaurantDetails.getTimeClose());
                pst.setString(6, restaurantDetails.getRestaurantDescription());
                return pst;
            }
        }, keyHolder);

        return keyHolder.getKey().intValue(); //return restaurantId
    }

    @Override
    public int addFloorplan(int restaurantId, List<RestaurantTable> restaurantTables) {
        int row = 0;  
                
        for (RestaurantTable restaurantTable : restaurantTables) {

            try {
                // insert
                String sql = "INSERT INTO table_positions (restaurant_id, table_id, top_margin, left_margin)"
                        + " VALUES (?, ?, ?, ?)";

                row = jdbcTemplate.update(sql,
                        restaurantId,
                        restaurantTable.getTableId(),
                        restaurantTable.getTopMargin(),
                        restaurantTable.getLeftMargin()
                );
                
            } catch (DataAccessException er) {
                System.out.println(er);
            }
        }
        return row;
    }

    @Override
    public int addMenu(int restaurantId, List<Meal> meals) {
        int row = 0;

        for (Meal meal : meals) {

            String mealURL = "http://bitehunter.vimly.ml/images/meals/";
            try {
                // insert
                String sql = "INSERT INTO meals (restaurant_id, meal_id, meal_name, meal_price, meal_image, meal_description)"
                        + " VALUES (?, ?, ?, ?, ?, ?)";

                row = jdbcTemplate.update(sql,
                        restaurantId,
                        meal.getMealId(),
                        meal.getMealName(),
                        meal.getMealPrice(),
                        mealURL + meal.getMealImage(),
                        meal.getMealDescription()
                );
            } catch (DataAccessException er) {
                System.out.println(er);
            }
        }
        return row;
    }

    @Override
    public int saveRestaurant(RestaurantDetails restaurantDetails) {
        int restaurantId = addRestaurantDetails(restaurantDetails);

        addFloorplan(restaurantId, restaurantDetails.getListRestuarantTable());
        addMenu(restaurantId, restaurantDetails.getListRestuarantMenu());

        return restaurantId;
    }

}
