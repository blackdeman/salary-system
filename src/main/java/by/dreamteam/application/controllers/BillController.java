package by.dreamteam.application.controllers;

import by.dreamteam.businessservices.entities.Department;
import by.dreamteam.businessservices.entities.Employee;
import by.dreamteam.businessservices.entities.EmployeeList;
import by.dreamteam.businessservices.entities.Payment;
import by.dreamteam.businessservices.entities.User;
import by.dreamteam.database.EmployeeDAO;
import by.dreamteam.database.PaymentDAO;
import by.dreamteam.database.UserDAO;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
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
    private PayController payController;
    @EJB
    private EmployeeDAO employeeDAO;
    @EJB
    private PaymentDAO paymentDAO;
    @EJB
    UserDAO userDAO;

    private Employee selectedEmployee;
    private Payment payment;

    public void getMonthAndYear() {

    }
    
    public String showPreview() {
        if (payment != null) {
            SimpleDateFormat df = new SimpleDateFormat("MM.yyyy");
            return "The salary for the " + getSelectedEmployee().getSurname() + " " + getSelectedEmployee().getName()
                    + "(id = " + getSelectedEmployee().getEmployeeId() + ")"
                    + "\nfor  " + df.format(getPayment().getPaymentPK().getMonthYear())
                    + " is " + payment.getSalary();
        }
        else {
            return null;
        }
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public List<Payment> getAllPayments() {
        return paymentDAO.getPaymentsForEmployee(getSelectedEmployee());
    }

    public String selectEmployee() {
        if (getSelectedEmployee() != null) {
            return "payment-list.xhtml";
        } else {
            return null;
        }
    }

    public Employee getSelectedEmployee() {
        return selectedEmployee;
    }

    public void setSelectedEmployee(Employee selectedEmployee) {
        this.selectedEmployee = selectedEmployee;
    }

    public void testMakePayments() {
        payController.makePayments();
    }

    public EmployeeList getEmployeeList() {
        List<Employee> list = new ArrayList<>();
        for (Employee e : employeeDAO.getEmployeeList().getList()) {
            if (e.getDepartmentId().getDepartmentId().equals(getCurrentUserDepartment().getDepartmentId())) {
                list.add(e);
            }
        }
        return new EmployeeList(list);
    }
    
    public Department getCurrentUserDepartment() {
        String username = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
        User user = userDAO.getUserByUsername(username);

        return user.getDepartment();
    }
}//end BillController
