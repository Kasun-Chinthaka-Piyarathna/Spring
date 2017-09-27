package hms.qate.data.dao;

import hms.qate.data.model.Employee;
import hms.qate.data.model.Restaurant;

import java.util.List;

/**
 * Created by chinthaka on 9/22/17.
 */
public interface RestaurantDAO {

    public List<Restaurant> getAllRestaurants();
}
