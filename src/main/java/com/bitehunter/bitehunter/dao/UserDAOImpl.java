/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitehunter.bitehunter.dao;

import com.bitehunter.bitehunter.model.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

/**
 *
 * @author Jevin
 */
public class UserDAOImpl implements UserDAO {

    private JdbcTemplate jdbcTemplate;

    public UserDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public User isUserExist(User user) {
        String sql = "SELECT * FROM user WHERE username= ? AND password= ?";
        return jdbcTemplate.query(sql, new Object[]{
            user.getUsername(),
            user.getPassword()},
                new ResultSetExtractor<User>() {

            @Override
            public User extractData(ResultSet rs) {
                try {
                    if (rs.next()) {
                        User user = new User();
                        user.setId(rs.getString("user_id"));
                        user.setUsername(rs.getString("username"));
                        user.setUserType(rs.getString("user_type"));
                        user.setLocation(rs.getString("location"));
                        return user;
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("ERROR " + ex);
                }
                return null;
            }
        });
    }

    @Override
    public User findUserById(String id) {
        String sql = "SELECT * FROM users WHERE user_id=" + id;
        return jdbcTemplate.query(sql, new ResultSetExtractor<User>() {

            @Override
            public User extractData(ResultSet rs) throws SQLException, DataAccessException {
                if (rs.next()) {
                    User user = new User();
                    user.setId(rs.getString("user_id"));
                    user.setUsername("username");
                    user.setPassword("password");
                    user.setUserType("user_type");
                    user.setLocation("location");
                    return user;
                }
                return null;
            }
        });
    }

}
