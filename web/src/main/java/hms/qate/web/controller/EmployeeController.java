package hms.qate.web.controller;


import hms.qate.data.model.Employee;
import hms.qate.data.model.Restaurant;
import hms.qate.service.EmployeeService;

//
//import com.ranga.entity.Employee;
//import com.ranga.service.EmployeeService;

import hms.qate.service.RestaurantService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author Ranga Reddy
 * @version 1.0
 */
@Controller
public class EmployeeController {
	
	private static final Logger logger = Logger.getLogger(EmployeeController.class);
	
	public EmployeeController() {
		System.out.println("EmployeeController()");
	}

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private RestaurantService restaurantService;

    @RequestMapping("createEmployee")
    public ModelAndView createEmployee(@ModelAttribute Employee employee) {
    	logger.info("Creating Employee. Data: "+employee);
        return new ModelAndView("employeeForm");
    }


    //-------------------Retrieve All Users--------------------------------------------------------

//    @RequestMapping(value = "/user/", method = RequestMethod.GET)
//    public ResponseEntity<List<User>> listAllUsers() {
//        List<User> users = userService.findAllUsers();
//        if(users.isEmpty()){
//            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
//        }
//        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
//    }



    @RequestMapping("editEmployee")
    public ModelAndView editEmployee(@RequestParam long id, @ModelAttribute Employee employee) {
    	logger.info("Updating the Employee for the Id "+id);
        employee = employeeService.getEmployee(id);
        return new ModelAndView("employeeForm", "employeeObject", employee);
    }
    
    @RequestMapping("saveEmployee")
    public ModelAndView saveEmployee(@ModelAttribute Employee employee) {
    	logger.info("Saving the Employee. Data : "+employee);
        if(employee.getId() == 0){ // if employee id is 0 then creating the employee other updating the employee
            employeeService.createEmployee(employee);
        } else {
            employeeService.updateEmployee(employee);
        }
        return new ModelAndView("redirect:getAllEmployees");
    }
    
    @RequestMapping("deleteEmployee")
    public ModelAndView deleteEmployee(@RequestParam long id) {
    	logger.info("Deleting the Employee. Id : "+id);
        employeeService.deleteEmployee(id);
        return new ModelAndView("redirect:getAllEmployees");
    }

    @RequestMapping("/getAllRestaurant")
    public List getAllEmployees() {
        logger.info("Getting the all Restaurants.");
        List<Restaurant> list = restaurantService.getAllRestaurants();
        return list;
    }

//
//    @RequestMapping(value = {"getAllEmployees", "/"})
//    public ModelAndView getAllEmployees() {
//    	logger.info("Getting the all Employees.");
//        List<Employee> employeeList = employeeService.getAllEmployees();
//        return new ModelAndView("employeeList", "employeeList", employeeList);
//    }


 // will return index.html(first one of three.)Hello Stranger! ${wow} iyala tibboth index.html eke ekata employeeList attach wei.


    @Controller
    @RequestMapping("/")
    public class DefaultController {
        @RequestMapping(method= RequestMethod.GET)
        public String showDefault(){
            return "index.html";
        }
    }

    @Controller
    @RequestMapping("/#/home")
    public class DefaultController2 {
        @RequestMapping(method= RequestMethod.GET)
        public String showDefault(){
            return "views/home.jsp";
        }
    }




//    /ordertracking/WEB-INF/views/static/index.html.jsp

    @RequestMapping("searchEmployee")
    public ModelAndView searchEmployee(@RequestParam("searchName") String searchName) {  
    	logger.info("Searching the Employee. Employee Names: "+searchName);
    	List<Employee> employeeList = employeeService.getAllEmployees(searchName);
        return new ModelAndView("employeeList", "employeeList", employeeList);    	
    }
}