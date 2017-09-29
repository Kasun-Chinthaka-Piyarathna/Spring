package hms.qate.service;

import hms.qate.data.model.Customer;
import hms.qate.data.model.Restaurant;

import java.util.List;

/**
 * Created by chinthaka on 9/29/17.
 */
public interface CustomerService {

        public List<Customer> signIn(String  username, String password);



    public int signUp(String Contact_Number,
                      String Customer_Full_Name,
                      String Email,
                      String NIC,
                      String Password,
                      String Username);




}
