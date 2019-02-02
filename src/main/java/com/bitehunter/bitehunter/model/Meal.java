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
public class Meal {

    @JsonProperty("mealId")
    private String mealId;
    @JsonProperty("mealName")
    private String mealName;
    @JsonProperty("mealPrice")
    private String mealPrice;
    @JsonProperty("mealImage")
    private String mealImage;
    @JsonProperty("mealDescription")
    private String mealDescription;

    public String getMealId() {
        return mealId;
    }

    public void setMealId(String mealId) {
        this.mealId = mealId;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public String getMealPrice() {
        return mealPrice;
    }

    public void setMealPrice(String mealPrice) {
        this.mealPrice = mealPrice;
    }

    public String getMealImage() {
        return mealImage;
    }

    public void setMealImage(String mealImage) {
        this.mealImage = mealImage;
    }

    public String getMealDescription() {
        return mealDescription;
    }

    public void setMealDescription(String mealDescription) {
        this.mealDescription = mealDescription;
    }


    
    
    
}
