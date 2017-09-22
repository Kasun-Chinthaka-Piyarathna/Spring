package hms.qate.service.impl;

import hms.qate.data.dao.RestaurantDAO;
import hms.qate.data.model.Employee;
import hms.qate.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by chinthaka on 9/22/17.
 */
public class RestaurantServiceImpl implements RestaurantService {


    @Autowired
    private RestaurantDAO restaurantDAO;

    @Override
    public List<Employee> getAllRestaurants(String restaurantName) {
        return restaurantDAO.getAllRestaurants(restaurantName);
    }


}
