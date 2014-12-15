package by.dreamteam.application.controllers;

import by.dreamteam.businessservices.entities.Employee;
import by.dreamteam.database.EmployeeDAO;
import by.dreamteam.database.PaymentDAO;
import by.dreamteam.businessservices.entities.EmployeeList;
import by.dreamteam.businessservices.entities.Payment;
import by.dreamteam.database.CardDAO;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.inject.Inject;

/**
 * @author Andrew
 * @version 1.0
 * @created 06-Dec-2014 3:35:02 PM
 */
@Singleton
public class PayController {

    @Inject
    private EmployeeDAO employeeDAO;
    @Inject
    private PaymentDAO paymentDAO;
    @Inject
    private CardDAO cardDAO;
    
    public EmployeeList employeeList;

    public PayController() {
    }

    /**
     *
     * @param employee
     * @return 
     */
    public Payment countPaymentForEmployee(Employee employee) {
        return new Payment();
    }

    @Schedule(dayOfMonth="Last")
    public void makePayments() {
        
    }
}//end PayController
