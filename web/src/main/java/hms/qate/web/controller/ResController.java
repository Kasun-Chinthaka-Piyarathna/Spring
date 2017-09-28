package hms.qate.web.controller;


import com.google.gson.Gson;
import hms.qate.data.model.Restaurant;
import hms.qate.service.RestaurantService;
import org.jboss.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;


@Controller
@RequestMapping("/restaurant")
class ResController {


    private static final Logger logger = Logger.getLogger(ResController.class);

    @Autowired
    private RestaurantService restaurantService;



    //Return JsonObject in spring restful webservice
    @RequestMapping (value="/service")
    @ResponseBody
    public String SayHello2Me(HttpServletRequest request) throws Exception {

        String input = (String) request.getParameter("name");
        String output = "hello " + input + " :)";
        JSONObject outputJsonObj = new JSONObject();
        outputJsonObj.put("output", output);

        return outputJsonObj.toString();
    }




    @RequestMapping (value="/getAllRestauranta")
    @ResponseBody
    public String SayHello2Me2(HttpServletRequest request) throws Exception {


        logger.info("Getting the all Restaurants.");
        List<Restaurant> list = restaurantService.getAllRestaurants();
//        JSONObject outputJsonObj = new JSONObject();
//        outputJsonObj.put("", list);



        String jsonnnn = new Gson().toJson(list );
        JSONParser parser = new JSONParser();
        JSONArray restaurantObjects_new = (JSONArray) parser.parse(jsonnnn);


        return restaurantObjects_new.toString();
    }



}

