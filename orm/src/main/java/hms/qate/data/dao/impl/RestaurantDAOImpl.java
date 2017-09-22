package hms.qate.data.dao.impl;

import hms.qate.data.dao.RestaurantDAO;
import hms.qate.data.model.Employee;
import hms.qate.data.utils.HibernateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chinthaka on 9/22/17.
 */

@Repository
public class RestaurantDAOImpl implements RestaurantDAO {

    public RestaurantDAOImpl() {
        System.out.println("RestaurantDAOImpl");
    }

    @Autowired
    private HibernateUtil hibernateUtil;


    @SuppressWarnings("unchecked")
    @Override
    public List<Employee> getAllRestaurants(String employeeName) {
        String query = "SELECT e.* FROM Employees e WHERE e.name like '%"+ employeeName +"%'";
        List<Object[]> employeeObjects = hibernateUtil.fetchAll(query);
        List<Employee> employees = new ArrayList<Employee>();
        for(Object[] employeeObject: employeeObjects) {
            Employee employee = new Employee();
            long id = ((BigInteger) employeeObject[0]).longValue();
            int age = (int) employeeObject[1];
            String name = (String) employeeObject[2];
            float salary = (float) employeeObject[3];
            employee.setId(id);
            employee.setName(name);
            employee.setAge(age);
            employee.setSalary(salary);
            employees.add(employee);
        }
        System.out.println(employees);
        return employees;
    }
}
