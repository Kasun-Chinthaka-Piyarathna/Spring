package hms.qate.service;

import hms.qate.data.model.Restaurant;
import hms.qate.data.model.food_items;
import hms.qate.data.model.reviews;

import java.util.List;

/**
 * Created by chinthaka on 9/27/17.
 */
public interface RestaurantService {
    public List<Restaurant> getAllRestaurants();


    public List<Restaurant> getAllRestaurants2(String res_name);


    public List<Restaurant> getAllRestaurants3(String nearest_city);


    public int register(String restaurant_Name,String username,String password,String order_facility,String email,String contact,String city,String food_items,String location,String image);



    public List<Restaurant> restaurant_signup(String res_name,String password);





    public List<food_items> GettingFoodItems(int rid);

    public List<reviews> ViewComments(int rid);

    public int AddComments(int rid,int cid,String comment,int rating,String delivery_status,String time_status);





}
