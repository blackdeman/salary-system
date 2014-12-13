package by.dreamteam.database;

import by.dreamteam.businessservices.entities.EmployeeList;
import by.dreamteam.businessservices.entities.Employee;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 * @author Andrew
 * @version 1.0
 * @created 06-Dec-2014 3:35:01 PM
 */
@Stateless
public class EmployeeDAO extends MainDAO {

    public EmployeeDAO() {
    }

    /**
     *
     * @param id
     * @return
     */
    public Employee getEmployee(int id) {
        return null;
    }

    public EmployeeList getEmployeeList() {
        Query query = em.createNamedQuery("Employee.findAll");
        return new EmployeeList(query.getResultList());
    }

    /**
     *
     * @param department
     * @return 
     */
    public EmployeeList getEmployeeList(String department) {
        return null;
    }

    /**
     *
     * @param employee
     */
    public void updateEmployee(Employee employee) {

    }
}//end EmployeeDAO
