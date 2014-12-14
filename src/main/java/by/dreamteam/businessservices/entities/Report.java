/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.dreamteam.businessservices.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dmitry Kaganovich
 */
@Entity
@Table(name = "report_tbl")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Report.findAll", query = "SELECT r FROM Report r"),
    @NamedQuery(name = "Report.findByReportId", query = "SELECT r FROM Report r WHERE r.reportId = :reportId"),
    @NamedQuery(name = "Report.findByReportName", query = "SELECT r FROM Report r WHERE r.reportName = :reportName"),
    @NamedQuery(name = "Report.findByMonthYear", query = "SELECT r FROM Report r WHERE r.monthYear = :monthYear"),
    @NamedQuery(name = "Report.findByAverageSalary", query = "SELECT r FROM Report r WHERE r.averageSalary = :averageSalary")})
public class Report implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "report_id")
    private Integer reportId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "report_name")
    private String reportName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "month_year")
    @Temporal(TemporalType.DATE)
    private Date monthYear;
    @Basic(optional = false)
    @NotNull
    @Column(name = "average_salary")
    private BigInteger averageSalary;
    @JoinColumn(name = "department_id", referencedColumnName = "department_id")
    @ManyToOne(optional = false)
    private Department departmentId;

    public Report() {
    }

    public Report(Integer reportId) {
        this.reportId = reportId;
    }

    public Report(Integer reportId, String reportName, Date monthYear, BigInteger averageSalary) {
        this.reportId = reportId;
        this.reportName = reportName;
        this.monthYear = monthYear;
        this.averageSalary = averageSalary;
    }

    public Integer getReportId() {
        return reportId;
    }

    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public Date getMonthYear() {
        return monthYear;
    }

    public void setMonthYear(Date monthYear) {
        this.monthYear = monthYear;
    }

    public BigInteger getAverageSalary() {
        return averageSalary;
    }

    public void setAverageSalary(BigInteger averageSalary) {
        this.averageSalary = averageSalary;
    }

    public Department getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Department departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reportId != null ? reportId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Report)) {
            return false;
        }
        Report other = (Report) object;
        if ((this.reportId == null && other.reportId != null) || (this.reportId != null && !this.reportId.equals(other.reportId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "by.dreamteam.businessservices.entities.Report[ reportId=" + reportId + " ]";
    }
    
}
