package hms.qate.data.dao;

import hms.qate.data.model.Customer;
import hms.qate.data.model.Restaurant;

import java.util.List;

/**
 * Created by chinthaka on 9/29/17.
 */
public interface CustomerDAO {

    public List<Customer> signIn(String username, String password);


    public int signUp(String username,
                                 String password,
                                 String Contact_Number,
                                 String Customer_Full_Name,
                                 String Email,
                                 String NIC);
}
