package hms.qate.web.controller;


import hms.qate.data.model.Restaurant;

//
//import com.ranga.entity.Employee;
//import com.ranga.service.EmployeeService;

import hms.qate.service.RestaurantService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by chinthaka on 9/29/17.
 */
@Controller
public class EmployeeController {

    private static final Logger logger = Logger.getLogger(EmployeeController.class);

    public EmployeeController() {
        System.out.println("EmployeeController()");
    }


    @Controller
    @RequestMapping("/")
    public class DefaultController {
        @RequestMapping(method = RequestMethod.GET)
        public String showDefault() {
            return "index.html";
        }
    }

    @Controller
    @RequestMapping("/#/home")
    public class DefaultController2 {
        @RequestMapping(method = RequestMethod.GET)
        public String showDefault() {
            return "views/home.jsp";
        }
    }


}