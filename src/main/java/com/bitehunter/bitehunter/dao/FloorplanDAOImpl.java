/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitehunter.bitehunter.dao;

import com.bitehunter.bitehunter.model.RestaurantTable;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Jevin
 */
public class FloorplanDAOImpl implements FloorplanDAO {

    private JdbcTemplate jdbcTemplate;

    public FloorplanDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void updateFloorplan(int restaurantId, List<RestaurantTable> listRestaurantTables) {

        //first delete the restaurant deleteFloorplan
        deleteFloorplan(restaurantId);

        for (RestaurantTable restaurantTable : listRestaurantTables) {

            try {
                // insert
                String sql = "INSERT INTO table_positions (restaurant_id, table_id, top_margin, left_margin)"
                        + " VALUES (?, ?, ?, ?)";

                jdbcTemplate.update(sql,
                        restaurantId,
                        restaurantTable.getTableId(),
                        restaurantTable.getTopMargin(),
                        restaurantTable.getLeftMargin()
                );
            } catch (DataAccessException er) {
                System.out.println(er);
            }
        }
    }

    public void deleteFloorplan(int restaurantId) {
        try {
            jdbcTemplate.update("DELETE FROM table_positions WHERE restaurant_id = ?", new Object[]{restaurantId});

        } catch (DataAccessException er) {
            System.out.println(er);
        }
    }

}
