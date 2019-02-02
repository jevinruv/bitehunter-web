package com.bitehunter.bitehunter.controller;

import com.bitehunter.bitehunter.model.User;
import java.io.IOException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Jevin
 */
@Controller
@SessionAttributes("user")
public class HomeController {


    @RequestMapping(value = "/manager_homepage", method = RequestMethod.GET)
    public ModelAndView loadManagerHome(ModelAndView model, @ModelAttribute User user) throws IOException {

        model.setViewName("manager_homepage");
        return model;
    }

    @RequestMapping(value = "/chef_homepage", method = RequestMethod.GET)
    public ModelAndView loadChefHome(ModelAndView model, @ModelAttribute User user) throws IOException {
        
        model.addObject("user", user);
        model.setViewName("chef_homepage");
        return model;
    }

    @RequestMapping(value = "/admin_homepage", method = RequestMethod.GET)
    public ModelAndView loadAdminHome(ModelAndView model, @ModelAttribute User user) throws IOException {

        model.setViewName("admin_homepage");
        return model;
    }

    @RequestMapping(value = "/tester", method = RequestMethod.GET)
    public ModelAndView table(ModelAndView model) throws IOException {
        model.setViewName("tester");
        return model;
    }
}
