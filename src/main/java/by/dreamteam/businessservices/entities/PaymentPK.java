/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.dreamteam.businessservices.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Andrew
 */
@Embeddable
public class PaymentPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "employee_id")
    private int employeeId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "month_year")
    @Temporal(TemporalType.DATE)
    private Date monthYear;

    public PaymentPK() {
    }

    public PaymentPK(int employeeId, Date monthYear) {
        this.employeeId = employeeId;
        this.monthYear = monthYear;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public Date getMonthYear() {
        return monthYear;
    }

    public void setMonthYear(Date monthYear) {
        this.monthYear = monthYear;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) employeeId;
        hash += (monthYear != null ? monthYear.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PaymentPK)) {
            return false;
        }
        PaymentPK other = (PaymentPK) object;
        if (this.employeeId != other.employeeId) {
            return false;
        }
        if ((this.monthYear == null && other.monthYear != null) || (this.monthYear != null && !this.monthYear.equals(other.monthYear))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "by.dreamteam.businessservices.entities.PaymentPK[ employeeId=" + employeeId + ", monthYear=" + monthYear + " ]";
    }
    
}
