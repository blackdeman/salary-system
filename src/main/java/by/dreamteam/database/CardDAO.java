package by.dreamteam.database;

import by.dreamteam.businessservices.entities.Card;
import by.dreamteam.businessservices.entities.CardList;
import by.dreamteam.businessservices.entities.Employee;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 * @author Andrew
 * @version 1.0
 * @created 06-Dec-2014 3:35:01 PM
 */
@Stateless
public class CardDAO extends MainDAO {

    /**
     *
     * @param employee
     * @return
     */
    public CardList getCardList(Employee employee) {
        Query query = em.createNamedQuery("Card.findByEmployeeId");
        query.setParameter("employeeId", employee.getEmployeeId());
        return new CardList(query.getResultList());
    }
    
    public void addCard(Card card) {
        em.persist(card);
    }

    public void updateCard(Card card) {
        em.merge(card);
    }

    public void deleteCard(Card card) {
        Query q = em.createNamedQuery("Card.findByPK");
        q.setParameter("employeeId", card.getCardPK().getEmployeeId());
        q.setParameter("date", card.getCardPK().getDate());
        em.remove(q.getSingleResult());
    }
}//end CardDAO
