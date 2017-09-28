package hms.qate.data.utils;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * @author Ranga Reddy
 * @version 1.0
 */
@Repository
public class HibernateUtil2 {

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public <T> List gettingallrestuarnts(String query2) {
        // Prep work
//        SessionFactory sessionFactory = new SessionFactory() ;
        Session session = sessionFactory.getCurrentSession();

        // Get All Employees
        Transaction tx = session.beginTransaction();
        SQLQuery query = session.createSQLQuery(query2);
        System.out.println("shdhwhfwhejdhewhdwh" + query);


        return query.list();


    }

}





