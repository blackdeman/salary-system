package by.dreamteam.database;

import by.dreamteam.businessservices.entities.Card;
import by.dreamteam.businessservices.entities.CardList;
import by.dreamteam.businessservices.entities.Employee;
import by.dreamteam.businessservices.entities.EmployeeList;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
        try {
            em.persist(card);
        } catch (Exception ex) {
            em.merge(card);
        }
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

    public CardList getCardsByEmployeeId(Integer id) {
        Query q = em.createNamedQuery("Card.findByEmployeeId");
        q.setParameter("employeeId", id);

        List<Card> cards = q.getResultList();

        if (cards != null) {
            return new CardList(cards);
        }

        return null;
    }

    public CardList getTimeRelevantCardsByEmployeeId(Integer id, Date start, Date end) {
        List<Card> cards = new ArrayList<>();

        CardList cardList = getCardsByEmployeeId(id);
        if (cardList != null) {
            for (Card card : cardList.getList()) {
                Date current = card.getCardPK().getDate();
                if (current.after(start) && current.before(end)) {
                    cards.add(card);
                }
            }

            return new CardList(cards);
        }

        return null;
    }

    public Integer getSalaryByEmployeeId(Integer id, Date start, Date end) {
        CardList cardList = getTimeRelevantCardsByEmployeeId(id, start, end);

        if (cardList != null) {
            Integer sum = 0;
            for (Card card : cardList.getList()) {
                sum += card.getHours() * card.getRatePerHour().intValue();
            }

            return sum;
        }

        return null;
    }

    public EmployeeList getEmployeeListByDepartmentId(Integer id) {
        Query q = em.createQuery("SELECT e FROM Employee e WHERE e.departmentId.departmentId = :departmentId");
        q.setParameter("departmentId", id);

        List<Employee> employeeList = q.getResultList();

        if (employeeList != null) {
            return new EmployeeList(q.getResultList());
        }

        return null;
    }

    public Float getTimeAverageSalaryByDepartmentId(Integer id, Date start, Date end) {
        float average = 0.0f;

        EmployeeList employeeList = getEmployeeListByDepartmentId(id);
        if (employeeList != null) {
            for (Employee e : employeeList.getList()) {
                average += getSalaryByEmployeeId(e.getEmployeeId(), start, end);
            }

            if (!employeeList.getList().isEmpty()) {
                return average / employeeList.getList().size();
            }

            return 0.0f;
        }

        return null;
    }

}//end CardDAO
