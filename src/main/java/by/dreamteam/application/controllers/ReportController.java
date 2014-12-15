package by.dreamteam.application.controllers;

import by.dreamteam.businessservices.entities.Department;
import by.dreamteam.businessservices.entities.Report;
import by.dreamteam.businessservices.entities.ReportList;
import by.dreamteam.businessservices.entities.User;
import by.dreamteam.database.CardDAO;
import by.dreamteam.database.ReportDAO;
import by.dreamteam.database.UserDAO;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 * @author dkaganovich
 * @version 1.0
 * @created 06-Dec-2014 3:35:02 PM
 */
@Named
@ViewScoped
public class ReportController implements Serializable {

    private Report report;
    private ReportList reportList;

    @EJB
    ReportDAO reportDAO;

    @EJB
    CardDAO cardDAO;

    @EJB
    UserDAO userDAO;

    public Report getReport() {
        if (report == null) {
            report = new Report();
        }
        return report;
    }

    public ReportList getReportList() {
        if (reportList == null) {
            reportList = reportDAO.getReportList();
        }
        return reportList;
    }

    public void setReport(Report report) {
        this.report = report;
    }

    public List<Department> getAllDepartments() {
        return reportDAO.getAllDepartments();
    }

    public Department getCurrentUserDepartment() {
        String username = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
        User user = userDAO.getUserByUsername(username);

        return user.getDepartment();
    }

    public String generatePreview() {
        Report r = getReport();
        if (FacesContext.getCurrentInstance().getExternalContext().isUserInRole("ADMIN")) {
            if (r.getDepartmentId().getDepartmentId() != null && r.getStartDate() != null && r.getEndDate() != null) {
                BigInteger average = BigInteger.valueOf(cardDAO.getTimeAverageSalaryByDepartmentId(r.getDepartmentId().getDepartmentId(),
                        r.getStartDate(), r.getEndDate()).longValue());
                getReport().setAverageSalary(average);
            }
        } else if (FacesContext.getCurrentInstance().getExternalContext().isUserInRole("ACCOUNTANT")) {
            if (r.getStartDate() != null && r.getEndDate() != null) {
                r.getDepartmentId().setDepartmentId(getCurrentUserDepartment().getDepartmentId());
                BigInteger average = BigInteger.valueOf(cardDAO.getTimeAverageSalaryByDepartmentId(r.getDepartmentId().getDepartmentId(),
                        r.getStartDate(), r.getEndDate()).longValue());
                getReport().setAverageSalary(average);
            }
        }

        return null;
    }

    public String showPreview() {
        Report r = getReport();
        if (r.getAverageSalary() != null) {
            return "The average salary for the " + reportDAO.getDepartmentById(r.getDepartmentId().getDepartmentId()).getName()
                    + "\nby the period from " + r.getStartDate() + " to " + r.getEndDate()
                    + "\nis " + r.getAverageSalary();
        }

        return null;
    }

    public String confirmReport() {
        Report r = getReport();
        if (r.getAverageSalary() == null) {
            generatePreview();
        }
        reportDAO.saveReport(r);

        return "/admin/report-print.faces?faces-redirect=true";
    }

    public String printReport() {
        Report r = getReport();
        if (r.getDepartmentId().getName() != null && r.getStartDate() != null && r.getEndDate() != null && r.getAverageSalary() != null) {
            return "The average salary for the " + r.getDepartmentId().getName()
                    + "\nby the period from " + r.getStartDate() + " to " + r.getEndDate()
                    + "\nis " + r.getAverageSalary();
        }

        return null;
    }        

    public String abort() {
        return "/admin/welcome.faces?faces-redirect=true";
    }
}//end ReportController
