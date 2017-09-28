package hms.qate.data.dao.impl;

import com.google.gson.Gson;
import hms.qate.data.dao.RestaurantDAO;
import hms.qate.data.model.Employee;
import hms.qate.data.model.Restaurant;
import hms.qate.data.utils.HibernateUtil;
import org.hibernate.Session;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chinthaka on 9/22/17.
 */

@Repository
public class RestaurantDAOImpl extends HibernateUtil implements RestaurantDAO {

    JSONArray restaurantObjects_new;

    public RestaurantDAOImpl() {
        System.out.println("RestaurantDAOImpl");
    }



    @SuppressWarnings("rawtypes")
    @Override
    public List<Restaurant> getAllRestaurants() {
        Session session = getSession();
        List<Restaurant> restaurantObjects = session.createCriteria(Restaurant.class).list();
        System.out.println("###########################"+ session.createCriteria(Restaurant.class).list());

        System.out.println("printing restaurant objects " +restaurantObjects);

//
//        String json = new Gson().toJson(restaurantObjects );
//        JSONParser parser = new JSONParser();
//        try {
//            restaurantObjects_new = (JSONArray) parser.parse(json);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//        List<Restaurant> restaurants = new ArrayList<Restaurant>();
//        for(int i=0;i<restaurantObjects_new.size();i++) {
//            Restaurant restaurant = new Restaurant();
//
//            int  Restaurant_ID = (int) restaurantObject[0];
//            String Restaurant_Name = (String) restaurantObject[1];
//            String RUsername = (String) restaurantObject[2];
//            String Password = (String) restaurantObject[3];
//            String OFacility = (String) restaurantObject[4];
//            String Email = (String) restaurantObject[5];
//            String NearestCity = (String) restaurantObject[6];
//            String Location = (String) restaurantObject[7];
//            String RImage = (String) restaurantObject[8];
//
//
//
//
//
//            restaurant.setRestaurant_ID(Restaurant_ID);
//            restaurant.setRestaurant_Name(Restaurant_Name);
//            restaurant.setRUsername(RUsername);
//            restaurant.setPassword(Password);
//            restaurant.setOFacility(OFacility);
//            restaurant.setEmail(Email);
//            restaurant.setNearestCity(NearestCity);
//            restaurant.setLocation(Location);
//            restaurant.setRImage(RImage);
//
//
//            restaurants.add(restaurant);
//        }
        System.out.println("********************** " + restaurantObjects);
        return restaurantObjects;
    }
}
