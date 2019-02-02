package com.bitehunter.bitehunter.config;

import com.bitehunter.bitehunter.dao.FloorplanDAO;
import com.bitehunter.bitehunter.dao.FloorplanDAOImpl;
import com.bitehunter.bitehunter.dao.MenuDetailsDAO;
import com.bitehunter.bitehunter.dao.MenuDetailsDAOImpl;
import com.bitehunter.bitehunter.dao.UserDAO;
import com.bitehunter.bitehunter.dao.UserDAOImpl;
import java.io.IOException;
import javax.sql.DataSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import com.bitehunter.bitehunter.dao.RestaurantDetailsDAO;
import com.bitehunter.bitehunter.dao.RestaurantDetailsDAOImpl;

/**
 *
 * @author Jevin
 */
@Configuration
@ComponentScan(basePackages = "com.bitehunter")
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurerAdapter {

    @Bean
    public ViewResolver getViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");

        //credentials for vimlyhost
        dataSource.setUrl("jdbc:mysql://173.212.229.171:3306/bitehunter_bitehunterDB");
        dataSource.setUsername("bitehunter");

        //credentials for heliohost
//        dataSource.setUrl("jdbc:mysql://ricky.heliohost.org:3306/biteht_bitehunterDB");
//        dataSource.setUsername("biteht");
        //common password
        dataSource.setPassword("cupboard123");

        return dataSource;
    }

    @Bean
    public UserDAO getUserDAO() {
        return new UserDAOImpl(getDataSource());
    }

    @Bean
    public RestaurantDetailsDAO getRestaurantDetailsDAO() {
        return new RestaurantDetailsDAOImpl(getDataSource());
    }

    @Bean
    public MenuDetailsDAO getMenuDetailsDAO() {
        return new MenuDetailsDAOImpl(getDataSource());
    }

    @Bean
    public FloorplanDAO getFloorplanDAO() {
        return new FloorplanDAOImpl(getDataSource());
    }

    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver getResolver() throws IOException {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        // no limit
        resolver.setMaxUploadSize(-1);
        return resolver;
    }

}
