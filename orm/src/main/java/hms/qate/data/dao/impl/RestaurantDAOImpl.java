package hms.qate.data.dao.impl;

import com.google.gson.Gson;
import hms.qate.data.dao.RestaurantDAO;
import hms.qate.data.model.Employee;
import hms.qate.data.model.Restaurant;
import hms.qate.data.utils.HibernateUtil;
import org.hibernate.Query;
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

        System.out.println("********************** " + restaurantObjects);
        return restaurantObjects;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public List<Restaurant> getAllRestaurants2(String res_name) {



        Session session = getSession();
        Query query = session.createQuery("from Restaurant where Restaurant_Name = :code ");
        query.setParameter("code",res_name);
        List restaurantObjects2 = query.list();
        return  restaurantObjects2;

//
//        Session session = getSession();
//        List<Restaurant> restaurantObjects2 = session.createCriteria(Restaurant.class).list();
//        System.out.println("###########################"+ session.createCriteria(Restaurant.class).list());
//
//        System.out.println("printing restaurant objects/ filter:Restaurant Name " +restaurantObjects2);
//
//        System.out.println("**********************filter:Restaurant Name  " + restaurantObjects2);
//        return restaurantObjects2;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public List<Restaurant> getAllRestaurants3(String nearest_city) {
        Session session3 = getSession();
        Query query3 = session3.createQuery("from Restaurant where NearestCity = :code ");
        query3.setParameter("code", nearest_city);
        List restaurantObjects3 = query3.list();
        return  restaurantObjects3;

    }



    @SuppressWarnings("rawtypes")
    @Override
    public int register(
            String restaurant_Name,
            String username,
            String password,
            String order_facility,
            String email,
            String contact,
            String city,
            String food_items,
            String location,
            String image
    ) {


        Session session = getSession();
        Query query2 = session.createSQLQuery("INSERT INTO Restaurant (Email, Location,NearestCity,OFacility,Password,RImage,RUsername,Restaurant_Name) VALUES (?,?,?,?,?,?,?,?)");
        query2.setParameter(0, email);
        query2.setParameter(1, location);
        query2.setParameter(2, city);
        query2.setParameter(3, order_facility);
        query2.setParameter(4, password);
        query2.setParameter(5, image);
        query2.setParameter(4, username);
        query2.setParameter(5, restaurant_Name);
        int rowsAffected_new = query2.executeUpdate();
        if (rowsAffected_new > 0) {
            System.out.println(rowsAffected_new + "(s) were inserted");
//            session.getTransaction().commit();
        }

        return rowsAffected_new;


    }





















}
