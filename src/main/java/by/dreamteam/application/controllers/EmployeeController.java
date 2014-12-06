package by.dreamteam.application.controllers;
import by.dreamteam.businessservices.entities.EmployeeList;
import by.dreamteam.database.EmployeeDAO;
import by.dreamteam.businessservices.entities.Employee;

/**
 * @author Pavel
 * @version 1.0
 * @created 06-Dec-2014 3:35:01 PM
 */
public class EmployeeController {

	private EmployeeList employeeList;
	private Employee selectedEmployee;
	public EmployeeDAO m_EmployeeDAO;
	public Employee employee;

	public EmployeeController(){

	}

	public EmployeeList getEmployeeList(){
		return null;
	}

	public Employee getSelectedEmployee(){
		return null;
	}

	/**
	 * 
	 * @param employeeList
	 */
	public void setEmployeeList(EmployeeList employeeList){

	}

	/**
	 * 
	 * @param employee
	 */
	public void setSelectedEmployee(Employee employee){

	}

	public void updateSelectedEmployee(){

	}
}//end EmployeeController