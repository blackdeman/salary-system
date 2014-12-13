package by.dreamteam.application.controllers;

import by.dreamteam.businessservices.entities.EmployeeList;
import by.dreamteam.businessservices.entities.Employee;
import by.dreamteam.database.EmployeeDAO;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 * @author Pavel
 * @version 1.0
 * @created 06-Dec-2014 3:35:01 PM
 */
@Named
@SessionScoped
public class EmployeeController implements Serializable {

    @EJB
    private EmployeeDAO employeeDAO;
    
    private EmployeeList employeeList;
    private Employee employee;

    public EmployeeController() {
    }

    public EmployeeList getEmployeeList() {
        if (employeeList == null) {
            employeeList = new EmployeeList();
            employeeList = employeeDAO.getEmployeeList();
        }
        return employeeList;
    }

    public Employee getEmployee() {
        if (employee == null) {
            employee = new Employee();
        }
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

}//end EmployeeController
