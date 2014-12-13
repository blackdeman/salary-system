package by.dreamteam.application.controllers;

import by.dreamteam.businessservices.entities.Department;
import by.dreamteam.businessservices.entities.EmployeeList;
import by.dreamteam.businessservices.entities.Employee;
import by.dreamteam.database.EmployeeDAO;
import java.io.Serializable;
import java.util.List;
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
    private boolean isNew = false;

    public EmployeeController() {
    }

    public EmployeeList getEmployeeList() {
        if (employeeList == null) {
            employeeList = new EmployeeList();
            employeeList = employeeDAO.getEmployeeList();
        }
        return employeeList;
    }
    
    public List<Department> getAllDepartments() {
        return employeeDAO.getAllDepartments();
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
    
    public String addEmployee() {
        setEmployee(null);
        isNew = true;
        return "employee-edit.xhtml?faces-redirect=true";
    }
    public String editEmployee() {
        if (getEmployee() != null) {
            isNew = false;
            return "employee-edit.xhtml?faces-redirect=true";
        }
        else 
            return null;
    }
    
    public String deleteEmployee() {
        employeeDAO.deleteEmployee(getEmployee());
        employeeList = null;
        return "employee-list.xhtml?faces-redirect=true";
    }
    
    public String saveEmployee() {
        if (isNew) {
            employeeDAO.insertEmployee(getEmployee());
        } else {
            employeeDAO.updateEmployee(getEmployee());
        }
        employeeList = null;
        return "employee-list.xhtml?faces-redirect=true";
    }
    
    public String cancel() {
        return "employee-list.xhtml?faces-redirect=true";
    }

}//end EmployeeController
