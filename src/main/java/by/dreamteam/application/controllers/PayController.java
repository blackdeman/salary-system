package by.dreamteam.application.controllers;
import by.dreamteam.businessservices.entities.Employee;
import by.dreamteam.database.EmployeeDAO;
import by.dreamteam.database.PaymentDAO;
import by.dreamteam.businessservices.entities.EmployeeList;
import by.dreamteam.businessservices.entities.Payment;

/**
 * @author Andrew
 * @version 1.0
 * @created 06-Dec-2014 3:35:02 PM
 */
public class PayController {

	public EmployeeDAO m_EmployeeDAO;
	public PaymentDAO m_PaymentDAO;
	public EmployeeList employeeList;
	public Payment payment;

	public PayController(){

	}

	/**
	 * 
	 * @param employee
	 */
	public void countPaymentForEmployee(Employee employee){

	}

	public void makePayments(){

	}
}//end PayController