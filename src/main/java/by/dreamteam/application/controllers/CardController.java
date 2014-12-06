package by.dreamteam.application.controllers;

import by.dreamteam.database.EmployeeDAO;
import by.dreamteam.database.CardDAO;
import by.dreamteam.businessservices.entities.EmployeeList;
import by.dreamteam.businessservices.entities.Employee;
import by.dreamteam.businessservices.entities.Card;
import by.dreamteam.businessservices.entities.CardList;

/**
 * @author Pavel
 * @version 1.0
 * @created 06-Dec-2014 3:35:01 PM
 */
public class CardController {

    private Card card;
    private CardList card_list;
    public EmployeeDAO m_EmployeeDAO;
    public CardDAO m_CardDAO;
    public EmployeeList employee_list;
    public Employee m_Employee;
    public Card m_Card;

    public CardController() {

    }

    public void confrimCardChanges() {

    }

    /**
     *
     * @param employee
     * @return 
     */
    public Card getCardForSelectedEmployee(Employee employee) {
        return null;
    }

    public EmployeeList getEmployeeList() {
        return null;
    }

    public Employee getSelectedEmployee() {
        return null;
    }

    public void selectCard() {

    }

    /**
     *
     * @param list
     */
    public void setEmployeeList(EmployeeList list) {

    }

    /**
     *
     * @param card
     */
    public void setSelectedCard(Card card) {

    }

    public void setSelectedCard() {

    }

    /**
     *
     * @param employee
     */
    public void setSelectedEmployee(Employee employee) {

    }

    public void updateSelectedCard() {

    }
}//end CardController
