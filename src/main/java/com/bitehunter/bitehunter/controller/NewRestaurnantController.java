/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitehunter.bitehunter.controller;

import com.bitehunter.bitehunter.dao.RestaurantDetailsDAO;
import com.bitehunter.bitehunter.model.Meal;
import com.bitehunter.bitehunter.model.RestaurantDetails;
import com.bitehunter.bitehunter.model.RestaurantTable;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Jevin
 */
@Controller
@SessionAttributes({"restaurantDetails","user"})

public class NewRestaurnantController {

    String mealImagePath = null;
    List<String> listMealImages = new ArrayList<String>();

    @Autowired
    private RestaurantDetailsDAO restaurantDetailsDAO;

    @RequestMapping(value = "/new_restaurant", method = RequestMethod.GET)
    public ModelAndView newRestaurant(ModelAndView model) {

        RestaurantDetails restaurantDetails = new RestaurantDetails();
        model.addObject("restaurantDetails", restaurantDetails);
        model.setViewName("new_restaurant");
        return model;
    }

    @RequestMapping(value = "/new_restaurant_save", method = RequestMethod.POST)
    public ModelAndView newRestaurantSave(
            ModelAndView model,
            @RequestParam("file") MultipartFile file,
            @ModelAttribute RestaurantDetails restaurantDetails) {

        setRestaurantImage(file, restaurantDetails);

        model.setViewName("add_floorplan");
        return model;
    }

    @RequestMapping(value = "/new_restaurant_floorplan_save", method = RequestMethod.POST)
    public ModelAndView newRestaurantFloorplanSave(
            ModelAndView model,
            @ModelAttribute RestaurantDetails restaurantDetails,
            @RequestParam("hiddenArrayField") String name) {

        try {
            ObjectMapper mapper = new ObjectMapper();
            List<RestaurantTable> listRestaurantTable = mapper.readValue(name, new TypeReference<List<RestaurantTable>>() {
            });

            restaurantDetails.setListRestuarantTable(listRestaurantTable); //add table list to session restaurantDetails

        } catch (Exception ex) {
            System.out.println(ex);
        }

        model.setViewName("add_menu");
        return model;
    }

    @RequestMapping(value = "/new_restaurant_menu_save", method = RequestMethod.POST)
    public ModelAndView newRestaurantMenuSave(
            ModelAndView model,
            @RequestParam("mealImagePath") String mealImagePath,
            @ModelAttribute RestaurantDetails restaurantDetails,
            @RequestParam("hiddenMenu") String menu) {

        try {
            ObjectMapper mapper = new ObjectMapper();
            List<Meal> listMeal = mapper.readValue(menu, new TypeReference<List<Meal>>() {
            });

            this.mealImagePath = mealImagePath;
            restaurantDetails.setListRestuarantMenu(listMeal); //add meal list to session restaurantDetails

        } catch (Exception ex) {
            System.out.println(ex);
        }

        model.setViewName("new_restaurant_summary");
        return model;
    }

    @RequestMapping(value = "/new_restaurant_save_final", method = RequestMethod.POST)
    public ModelAndView newRestaurantSaveFinal(
            ModelAndView model,
            @ModelAttribute RestaurantDetails restaurantDetails) {

        insertRestaurantToDatabase(restaurantDetails);
        
        model.setViewName("admin_homepage");
        return model;
    }

    public void insertRestaurantToDatabase(RestaurantDetails restaurantDetails) {
        ftpUploadRestaurantImage(restaurantDetails);
        ftpUploadMealImages();
        restaurantDetailsDAO.saveRestaurant(restaurantDetails);
    }

    public void setRestaurantImage(MultipartFile file, RestaurantDetails restaurantDetails) {

        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();

                // Creating the directory to store file
                String rootPath = System.getProperty("catalina.home");
                File dir = new File(rootPath + File.separator + "tmpFiles");
                if (!dir.exists()) {
                    dir.mkdirs();
                }

                String fullFilePath = dir.getAbsolutePath() + File.separator + file.getOriginalFilename();

                // Create the file on server
                File serverFile = new File(fullFilePath);
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();

                restaurantDetails.setRestaurantImage(fullFilePath);
                restaurantDetails.setFileName(file.getOriginalFilename());

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public void ftpUploadRestaurantImage(RestaurantDetails restaurantDetails) {
        FTPClient client = new FTPClient();

        try {
            client.connect("bitehunter.vimly.ml");
            client.login("bitehunter", "cupboard123");
            client.setFileType(FTP.BINARY_FILE_TYPE);
            client.enterLocalPassiveMode();

            InputStream input = new FileInputStream(new File(restaurantDetails.getRestaurantImage()));
            client.storeFile("/public_html/images/restaurants/" + restaurantDetails.getFileName(), input);

            client.logout();
            client.disconnect();

            restaurantDetails.setRestaurantImage(
                    "http://bitehunter.vimly.ml/images/restaurants/" + restaurantDetails.getFileName());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ftpUploadMealImages() {
        FTPClient client = new FTPClient();

        try {
            client.connect("bitehunter.vimly.ml");
            client.login("bitehunter", "cupboard123");
            client.setFileType(FTP.BINARY_FILE_TYPE);
            client.enterLocalPassiveMode();

            getMealFileNames(mealImagePath);
            
            for (String image : listMealImages) {
                InputStream input = new FileInputStream(new File(mealImagePath + File.separator + image));
                client.storeFile("/public_html/images/meals/" + image, input);
            }
            client.logout();
            client.disconnect();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getMealFileNames(String filePath) {

        File[] files = new File(filePath).listFiles();
        //If this pathname does not denote a directory, then listFiles() returns null. 

        for (File file : files) {
            if (file.isFile()) {
                listMealImages.add(file.getName());
            }
        }
    }
}
