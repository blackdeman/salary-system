package by.dreamteam.businessservices.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pavel
 * @version 1.0
 * @created 06-Dec-2014 3:35:01 PM
 */
public class EmployeeList {

    private List<Employee> employeeList;

    public EmployeeList() {
    }

    public EmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
    
    public List<Employee> getList() {
        if (employeeList == null) {
            employeeList = new ArrayList<>();
        }
        return employeeList;
    }

    public Employee getEmployee(int i) {
        if (getList().size() > i) {
            return employeeList.get(i);
        }
        return null;
    }
    
    public int getSize() {
        return getList().size();
    }
}//end EmployeeList
