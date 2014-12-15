package by.dreamteam.database;

import by.dreamteam.businessservices.entities.Payment;
import javax.ejb.Stateless;

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
}//end PaymentDAO
