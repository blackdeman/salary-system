package by.dreamteam.application.controllers;

import by.dreamteam.database.EmployeeDAO;
import by.dreamteam.businessservices.entities.EmployeeList;
import by.dreamteam.businessservices.entities.Employee;
import by.dreamteam.businessservices.entities.Card;
import by.dreamteam.businessservices.entities.CardList;
import by.dreamteam.businessservices.entities.CardPK;
import by.dreamteam.database.CardDAO;
import java.io.Serializable;
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
public class CardController implements Serializable {

    @EJB
    private EmployeeDAO employeeDAO;
    @EJB
    private CardDAO cardDAO;

    private EmployeeList employeeList;
    private Employee employee;

    private CardList cardList;
    private Card card;
    boolean isNew = false;

    public CardController() {

    }

    public EmployeeList getEmployeeList() {
        if (employeeList == null) {
            employeeList = new EmployeeList();
            employeeList = employeeDAO.getEmployeeList();
        }
        return employeeList;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
        cardList = null;
        setCard(null);
    }

    public String selectEmployee() {
        if (getEmployee() != null) {
            return "card-list.xhtml";
        } else {
            return null;
        }
    }

    public CardList getCardList() {
        if (cardList == null) {
            cardList = new CardList();
            cardList = cardDAO.getCardList(employee);
        }
        return cardList;
    }

    public Card getCard() {
        if (card == null) {
            card = new Card();
        }
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public String addCard() {
        isNew = true;
        CardPK cpk = new CardPK();
        cpk.setEmployeeId(getEmployee().getEmployeeId());
        setCard(new Card(cpk));
        return "card-edit.xhtml";
    }

    public String editCard() {
        isNew = false;
        return "card-edit.xhtml";
    }

    public String deleteCard() {
        cardDAO.deleteCard(card);
        cardList = null;
        setCard(null);
        return "card-list.xhtml";
    }

    public String confrimCardChanges() {
        if (isNewCard()) {
            cardDAO.addCard(card);
        } else {
            cardDAO.updateCard(getCard());
        }
        cardList = null;
        setCard(null);
        return "card-list.xhtml";
    }

    public String cancel() {
        cardList = null;
        setCard(null);
        return "card-list.xhtml";
    }

    public boolean isNewCard() {
        return isNew;
    }
}//end CardController
