package hms.qate.data.dao.impl;

import hms.qate.data.dao.RestaurantDAO;
import hms.qate.data.model.Employee;
import hms.qate.data.model.Restaurant;
import hms.qate.data.utils.HibernateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chinthaka on 9/22/17.
 */

@Repository
public class RestaurantDAOImpl implements RestaurantDAO {

    public RestaurantDAOImpl() {
        System.out.println("RestaurantDAOImpl");
    }

    @Autowired
    private HibernateUtil hibernateUtil;


    @SuppressWarnings("unchecked")
    @Override
    public List<Restaurant> getAllRestaurants() {
        String query = "select * from Restaurant";
        List<Object[]> restaurantObjects = hibernateUtil.fetchAll(query);
        List<Restaurant> restaurants = new ArrayList<Restaurant>();
        for(Object[] restaurantObject: restaurantObjects) {
            Restaurant restaurant = new Restaurant();
            int  Restaurant_ID = (int) restaurantObject[0];
            String Restaurant_Name = (String) restaurantObject[1];
            String RUsername = (String) restaurantObject[2];
            String Password = (String) restaurantObject[3];
            String OFacility = (String) restaurantObject[4];
            String Email = (String) restaurantObject[5];
            String NearestCity = (String) restaurantObject[6];
            String Location = (String) restaurantObject[7];
            String RImage = (String) restaurantObject[8];





            restaurant.setRestaurant_ID(Restaurant_ID);
            restaurant.setRestaurant_Name(Restaurant_Name);
            restaurant.setRUsername(RUsername);
            restaurant.setPassword(Password);
            restaurant.setOFacility(OFacility);
            restaurant.setEmail(Email);
            restaurant.setNearestCity(NearestCity);
            restaurant.setLocation(Location);
            restaurant.setRImage(RImage);


            restaurants.add(restaurant);
        }
        System.out.println(restaurants);
        return restaurants;
    }
}
