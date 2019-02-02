/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitehunter.bitehunter.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jevin
 */
public class RestaurantDetails {

    private String restaurantName;
    private String restaurantImage;
    private String timeOpen;
    private String timeClose;
    private int tableCount;
    
    private List<RestaurantTable> listRestuarantTable = new ArrayList<RestaurantTable>();
    private List<Meal> listRestuarantMenu = new ArrayList<Meal>();

    private String fileName;
    private String restaurantDescription;
    
        
    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getRestaurantImage() {
        return restaurantImage;
    }

    public void setRestaurantImage(String restaurantImage) {
        this.restaurantImage = restaurantImage;
    }

    public List<RestaurantTable> getListRestuarantTable() {
        return listRestuarantTable;
    }

    public void setListRestuarantTable(List<RestaurantTable> listRestuarantTable) {
        this.listRestuarantTable = listRestuarantTable;
    }

    public List<Meal> getListRestuarantMenu() {
        return listRestuarantMenu;
    }

    public void setListRestuarantMenu(List<Meal> listRestuarantMenu) {
        this.listRestuarantMenu = listRestuarantMenu;
    }

    public String getTimeOpen() {
        return timeOpen;
    }

    public void setTimeOpen(String timeOpen) {
        this.timeOpen = timeOpen;
    }

    public String getTimeClose() {
        return timeClose;
    }

    public void setTimeClose(String timeClose) {
        this.timeClose = timeClose;
    }

    public int getTableCount() {
        return tableCount;
    }

    public void setTableCount(int tableCount) {
        this.tableCount = tableCount;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getRestaurantDescription() {
        return restaurantDescription;
    }

    public void setRestaurantDescription(String restaurantDescription) {
        this.restaurantDescription = restaurantDescription;
    }

    
    
}
