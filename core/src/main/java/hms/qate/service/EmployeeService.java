
package hms.qate.service;

import hms.qate.data.model.Employee;



//import com.ranga.entity.Employee;

import java.io.Console;
import java.util.List;

/**
 * @author Ranga Reddy
 * @version 1.0
 */
public interface EmployeeService {
	public long createEmployee(Employee employee);
    public Employee updateEmployee(Employee employee);
    public void deleteEmployee(long id);
    public List<Employee> getAllEmployees();
    public Employee getEmployee(long id);
	public List<Employee> getAllEmployees(String employeeName);

}
