package by.dreamteam.application.controllers;

import by.dreamteam.database.EmployeeDAO;
import by.dreamteam.businessservices.entities.EmployeeList;
import by.dreamteam.businessservices.entities.Employee;
import by.dreamteam.businessservices.entities.Card;
import by.dreamteam.businessservices.entities.CardList;
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
        setCard(null);
        return "card-edit.xhtml";
    }

    public String editCard() {
        return "card-edit.xhtml";
    }
    
    public String deleteCard() {
        return "card-list.xhtml?faces-redirect=true";
    }

    public void confrimCardChanges() {

    }

    public Card getCardForSelectedEmployee(Employee employee) {
        return null;
    }

    public void updateSelectedCard() {

    }
}//end CardController
