package hms.qate.data.dao.impl;

import hms.qate.data.dao.CustomerDAO;
import hms.qate.data.dao.RestaurantDAO;
import hms.qate.data.model.Customer;
import hms.qate.data.model.Restaurant;
import hms.qate.data.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.json.simple.JSONArray;
import org.springframework.stereotype.Repository;
import sun.security.util.Password;

import java.util.List;

/**
 * Created by chinthaka on 9/29/17.
 */

@Repository
public class CustomerDAOImpl extends HibernateUtil implements CustomerDAO {

    JSONArray customerObjects_new;

    public CustomerDAOImpl() {
        System.out.println("CustomerDAOImpl");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public List<Customer> signIn(String username, String password) {
        Session session = getSession();
        Query query = session.createQuery("from Customer where Username = :code and Password = :code2");
        query.setParameter("code", username);
        query.setParameter("code2", password);
        List customerObjects = query.list();
        return customerObjects;

    }


    @SuppressWarnings("rawtypes")
    @Override
    public int signUp(
            String Contact_Number,
            String Customer_Full_Name,
            String Email,
            String NIC,
            String password,
            String username
    ) {


        Session session = getSession();
        Query query2 = session.createSQLQuery("INSERT INTO Customer (Contact_Number, Customer_Full_Name,Email,NIC,Password,Username) VALUES (?,?,?,?,?,?)");
        query2.setParameter(0, Contact_Number);
        query2.setParameter(1, Customer_Full_Name);
        query2.setParameter(2, Email);
        query2.setParameter(3, NIC);
        query2.setParameter(4, password);
        query2.setParameter(5, username);
        int rowsAffected = query2.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println(rowsAffected + "(s) were inserted");
//            session.getTransaction().commit();
        }

        return rowsAffected;


    }

}
