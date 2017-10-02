package hms.qate.service.impl;

import hms.qate.data.dao.RestaurantDAO;
import hms.qate.data.model.Restaurant;

import hms.qate.data.model.food_items;
import hms.qate.data.model.reviews;
import hms.qate.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by chinthaka on 9/22/17.
 */

@Service
@Transactional
public class RestaurantServiceImpl implements RestaurantService {


    @Autowired
    private RestaurantDAO restaurantDAO;

    public List<Restaurant> getAllRestaurants() {
        return restaurantDAO.getAllRestaurants();
    }

    public List<Restaurant> getAllRestaurants2(String res_name) {
        return restaurantDAO.getAllRestaurants2(res_name);
    }

    public List<Restaurant> getAllRestaurants3(String nearest_city) {
        return restaurantDAO.getAllRestaurants3(nearest_city);
    }

    public int register(String restaurant_Name,String username,String password,String order_facility,String email,String contact,String city,String food_items,String location,String image)
    {
        return restaurantDAO.register(restaurant_Name,username,password,order_facility,email,contact,city,food_items,location,image);
    }


    public List<Restaurant> restaurant_signup(String res_name,String password){
        return restaurantDAO.restaurant_signup(res_name,password);
    }


    public List<food_items> GettingFoodItems(int rid) {
        return restaurantDAO.GettingFoodItems(rid);
    }



    public List<reviews> ViewComments(int rid){
        return restaurantDAO.ViewComments(rid);
    }

    public int AddComments(int rid,int cid,String comment,int rating,String delivery_status,String time_status){
        return restaurantDAO.AddComments(rid,cid,comment,rating,delivery_status,time_status);
    }


}
