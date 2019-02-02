/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitehunter.bitehunter.dao;

import com.bitehunter.bitehunter.model.User;

/**
 * Defines DAO operations for the User model.
 *
 * @author Jevin
 */
public interface UserDAO {

    User isUserExist(User user);

    User findUserById(String id);
}
