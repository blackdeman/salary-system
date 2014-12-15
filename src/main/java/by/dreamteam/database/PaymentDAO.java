package by.dreamteam.database;

import by.dreamteam.businessservices.entities.Employee;
import by.dreamteam.businessservices.entities.Payment;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 * @author Andrew
 * @version 1.0
 * @created 06-Dec-2014 3:35:02 PM
 */
@Stateless
public class PaymentDAO extends MainDAO {

    /**
     *
     * @param payment
     */
    public void savePayment(Payment payment) {
        em.persist(payment);
    }
    
    public List<Payment> getPaymentsForEmployee (Employee employee) {
        Query q = em.createNamedQuery("Payment.findByEmployeeId");
        q.setParameter("employeeId", employee.getEmployeeId());
        return q.getResultList();
    }
}//end PaymentDAO
