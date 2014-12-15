package by.dreamteam.application.controllers;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 * @author Andrew
 * @version 1.0
 * @created 06-Dec-2014 3:35:00 PM
 */
@Named
@SessionScoped
public class BillController implements Serializable {

    @EJB
    PayController payController;
    
    public BillController() {

    }

    public void getMonthAndYear() {

    }

    public void selectEmployee() {

    }
    
    public void testMakePayments() {
        payController.makePayments();
    }
}//end BillController
