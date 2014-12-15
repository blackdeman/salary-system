package by.dreamteam.database;

import by.dreamteam.businessservices.entities.Department;
import by.dreamteam.businessservices.entities.EmployeeList;
import by.dreamteam.businessservices.entities.Report;
import by.dreamteam.businessservices.entities.ReportList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 * @author Andrew
 * @version 1.0
 * @created 06-Dec-2014 3:35:02 PM
 */
@Stateless
public class ReportDAO extends MainDAO {

    public ReportDAO() {

    }

    /**
     *
     * @param report
     */
    public void saveReport(Report report) {
        Query q = em.createNamedQuery("Department.findByDepartmentId");
        q.setParameter("departmentId", report.getDepartmentId().getDepartmentId());
        report.setDepartmentId((Department)q.getSingleResult());
        Integer maxId = em.createQuery("SELECT MAX(r.reportId) FROM Report r", Integer.class).getSingleResult();
        if (maxId == null) {
            maxId = 0;
        }
        report.setReportId(maxId + 1);
        em.persist(report);
    }
    
    public ReportList getReportList() {
        Query query = em.createNamedQuery("Report.findAll");
        return new ReportList(query.getResultList());
    }       
    
    public List<Department> getAllDepartments() {
        Query query = em.createNamedQuery("Department.findAll");
        return query.getResultList();
    }
    
    public Department getDepartmentById(Integer id) {
        Query query = em.createNamedQuery("Department.findByDepartmentId");
        query.setParameter("departmentId", id);
        return (Department) query.getSingleResult();
    }        
}//end ReportDAO
