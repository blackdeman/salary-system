package by.dreamteam.database;

import by.dreamteam.businessservices.entities.Department;
import by.dreamteam.businessservices.entities.EmployeeList;
import by.dreamteam.businessservices.entities.Employee;
import java.util.List;
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
    public EmployeeList getEmployeeList(Department department) {
        return null;
    }
    
    public List<Department> getAllDepartments() {
        Query query = em.createNamedQuery("Department.findAll");
        return query.getResultList();
    }

    public void insertEmployee(Employee employee) {
        Query q = em.createNamedQuery("Department.findByDepartmentId");
        q.setParameter("departmentId", employee.getDepartmentId().getDepartmentId());
        employee.setDepartmentId((Department)q.getSingleResult());
        Integer maxId = em.createQuery("SELECT MAX(e.employeeId) FROM Employee e", Integer.class).getSingleResult();
        employee.setEmployeeId(maxId + 1);
        em.persist(employee);
    }
    
    public void updateEmployee(Employee employee) {
        Query q = em.createNamedQuery("Department.findByDepartmentId");
        q.setParameter("departmentId", employee.getDepartmentId().getDepartmentId());
        employee.setDepartmentId((Department)q.getSingleResult());
        em.merge(employee);
    }
    
    public void deleteEmployee(Employee employee) {
        em.remove(em.find(Employee.class, employee.getEmployeeId()));
    }
}//end EmployeeDAO
