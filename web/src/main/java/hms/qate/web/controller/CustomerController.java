package hms.qate.web.controller;

import com.google.gson.Gson;
import hms.qate.data.model.Customer;
import hms.qate.data.model.Restaurant;
import hms.qate.service.CustomerService;
import hms.qate.service.RestaurantService;
import org.jboss.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by chinthaka on 9/29/17.
 */


@Controller
@RequestMapping("/customer")
class CustomerController {

    private static final Logger logger = Logger.getLogger(CustomerController.class);

    @Autowired
    private CustomerService customerService;


    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    @ResponseBody

    public String GettingCustomers(@RequestParam("cname") final String username, @RequestParam("pwd") final String password) throws org.json.simple.parser.ParseException {

        logger.info("Cutomer sign in ###########");
        List<Customer> list = customerService.signIn(username, password);
        String jsonnnn = new Gson().toJson(list);
        JSONParser parser = new JSONParser();
        JSONArray customerObjects_new = (JSONArray) parser.parse(jsonnnn);


        return customerObjects_new.toString();


    }


    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    @ResponseBody

    public String GettingCustomers2(@RequestParam("phone") final String Contact_Number,
                                    @RequestParam("cname") final String Customer_Full_Name,
                                    @RequestParam("email") final String Email,
                                    @RequestParam("nic") final String NIC,
                                    @RequestParam("pwd") final String Password,
                                    @RequestParam("username") final String Username

    ) throws org.json.simple.parser.ParseException {


        logger.info("Cutomer sign up ###########");
        int rawaffected = customerService.signUp(Contact_Number, Customer_Full_Name, Email, NIC, Password, Username);
        String rawaffected_string = String.valueOf(rawaffected);


        return rawaffected_string;


    }


}
