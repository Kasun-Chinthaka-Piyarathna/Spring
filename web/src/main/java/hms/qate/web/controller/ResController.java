package hms.qate.web.controller;


import com.google.gson.Gson;
import hms.qate.data.model.Customer;
import hms.qate.data.model.Restaurant;
import hms.qate.service.CustomerService;
import hms.qate.service.RestaurantService;
import org.jboss.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;


@Controller
@RequestMapping("/restaurant")
class ResController {


    private static final Logger logger = Logger.getLogger(ResController.class);

    @Autowired
    private RestaurantService restaurantService;
//    @Autowired
//    private CustomerService customerService;


    //Return JsonObject in spring restful webservice
    @RequestMapping(value = "/service")
    @ResponseBody
    public String SayHello2Me(HttpServletRequest request) throws Exception {

        String input = (String) request.getParameter("name");
        String output = "hello " + input + " :)";
        JSONObject outputJsonObj = new JSONObject();
        outputJsonObj.put("output", output);

        return outputJsonObj.toString();
    }


    @RequestMapping(value = "/getAllRestauranta")
    @ResponseBody
    public String SayHello2Me2(HttpServletRequest request) throws Exception {


        logger.info("Getting the all Restaurants.");
        List<Restaurant> list = restaurantService.getAllRestaurants();
//        JSONObject outputJsonObj = new JSONObject();
//        outputJsonObj.put("", list);


        String jsonnnn = new Gson().toJson(list);
        JSONParser parser = new JSONParser();
        JSONArray restaurantObjects_new = (JSONArray) parser.parse(jsonnnn);


        return restaurantObjects_new.toString();
    }


    @RequestMapping(value = "/restaurantwise", method = RequestMethod.POST)
    @ResponseBody
    public String GettingRestaurants2(@RequestParam("res") final String res_name) throws org.json.simple.parser.ParseException {

        logger.info("Getting the all Restaurants. /filter: Restaurant_name");
        List<Restaurant> list2 = restaurantService.getAllRestaurants2(res_name);
        String jsonnnn2 = new Gson().toJson(list2);
        JSONParser parser2 = new JSONParser();
        JSONArray restaurantObjects_new2 = (JSONArray) parser2.parse(jsonnnn2);


        return restaurantObjects_new2.toString();


    }

    @RequestMapping(value = "/locationwise", method = RequestMethod.POST)
    @ResponseBody
    public String GettingRestaurants3(@RequestParam("loc") final String nearest_city) throws org.json.simple.parser.ParseException {

        logger.info("Getting the all Restaurants. /filter: Nearest_city");
        List<Restaurant> list3 = restaurantService.getAllRestaurants3(nearest_city);
        String jsonnnn3 = new Gson().toJson(list3);
        JSONParser parser3 = new JSONParser();
        JSONArray restaurantObjects_new3 = (JSONArray) parser3.parse(jsonnnn3);


        return restaurantObjects_new3.toString();


    }
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public String GettingRestaurants4(@RequestParam("rname") final String restaurant_Name,
                                      @RequestParam("uname") final String username,
                                      @RequestParam("pwd") final String password,
                                      @RequestParam("ofac") final String order_facility,
                                      @RequestParam("email") final String email,
                                      @RequestParam("rconta") final String contact,
                                      @RequestParam("city") final String city,
                                      @RequestParam("fooditems") final String food_items,
                                      @RequestParam("location") final String location,
                                      @RequestParam("image") final String image


    ) throws org.json.simple.parser.ParseException {

        logger.info("Restaurants Register*************");
        int rawaffected2  = restaurantService.register(restaurant_Name,username,password,order_facility,email,contact,city,food_items,location,image);
        String rawaffected_string2 = String.valueOf(rawaffected2);
        return rawaffected_string2;


    }


}

