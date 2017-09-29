package hms.qate.service.impl;

import hms.qate.data.dao.CustomerDAO;
import hms.qate.data.dao.RestaurantDAO;
import hms.qate.data.model.Customer;
import hms.qate.data.model.Restaurant;
import hms.qate.service.CustomerService;
import hms.qate.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by chinthaka on 9/29/17.
 */

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{

        @Autowired
        private CustomerDAO customerDAO;

        public List<Customer> signIn(String username, String password) {
            return customerDAO.signIn(username, password);
        }


    public int signUp(String Contact_Number,
                      String Customer_Full_Name,
                      String Email,
                      String NIC,
                      String Password,
                      String Username) {
        return customerDAO.signUp(Contact_Number, Customer_Full_Name, Email,NIC,Password,Username);
    }



    }
