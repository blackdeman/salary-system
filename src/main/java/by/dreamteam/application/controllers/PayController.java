package by.dreamteam.application.controllers;

import by.dreamteam.businessservices.entities.Employee;
import by.dreamteam.database.EmployeeDAO;
import by.dreamteam.database.PaymentDAO;
import by.dreamteam.businessservices.entities.Payment;
import by.dreamteam.businessservices.entities.PaymentPK;
import by.dreamteam.database.CardDAO;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
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

    /**
     *
     * @param employee
     * @return
     */
    public Payment countPaymentForEmployee(Employee employee) {
        Integer id = employee.getEmployeeId();
        
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.clear(Calendar.MINUTE);
        cal.clear(Calendar.SECOND);
        cal.clear(Calendar.MILLISECOND);
//        cal.set(2014, 10, 30);
        Date lastDay = cal.getTime();
        
        cal.set(Calendar.DAY_OF_MONTH, 1);
        Date firstDay = cal.getTime();
        return new Payment(new PaymentPK(id, lastDay),
                BigInteger.valueOf(cardDAO.getSalaryByEmployeeId(id, firstDay, lastDay)));
    }

    @Schedule(dayOfMonth = "Last")
    public void makePayments() {
        for (Employee e : employeeDAO.getEmployeeList().getList()) {
            Payment p = countPaymentForEmployee(e);
            paymentDAO.savePayment(p);
        }
    }
}//end PayController
