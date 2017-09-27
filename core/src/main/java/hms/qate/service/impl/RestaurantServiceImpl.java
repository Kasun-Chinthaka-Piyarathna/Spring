package hms.qate.service.impl;

import hms.qate.data.dao.RestaurantDAO;
import hms.qate.data.model.Employee;
import hms.qate.data.model.Restaurant;

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
public class RestaurantServiceImpl implements RestaurantService{


    @Autowired
    private RestaurantDAO restaurantDAO;

    public List<Restaurant> getAllRestaurants() {
        return restaurantDAO.getAllRestaurants();
    }


}
