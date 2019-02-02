/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitehunter.bitehunter.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Jevin
 */
public class RestaurantTable {

    @JsonProperty("tableID")
    private String tableId;
    @JsonProperty("topMargin")
    private String topMargin;
    @JsonProperty("leftMargin")
    private String leftMargin;



    public RestaurantTable() {
    }

    public RestaurantTable(String tableId, String topMargin, String leftMargin) {
        this.tableId = tableId;
        this.topMargin = topMargin;
        this.leftMargin = leftMargin;
    }

    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    public String getTopMargin() {
        return topMargin;
    }

    public void setTopMargin(String topMargin) {
        this.topMargin = topMargin;
    }

    public String getLeftMargin() {
        return leftMargin;
    }

    public void setLeftMargin(String leftMargin) {
        this.leftMargin = leftMargin;
    }
    
}
