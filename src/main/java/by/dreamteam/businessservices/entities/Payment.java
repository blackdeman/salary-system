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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Andrew
 */
@Entity
@Table(name = "payment_tbl")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Payment.findAll", query = "SELECT p FROM Payment p"),
    @NamedQuery(name = "Payment.findByEmployeeId", query = "SELECT p FROM Payment p WHERE p.paymentPK.employeeId = :employeeId"),
    @NamedQuery(name = "Payment.findByMonthYear", query = "SELECT p FROM Payment p WHERE p.paymentPK.monthYear = :monthYear"),
    @NamedQuery(name = "Payment.findBySalary", query = "SELECT p FROM Payment p WHERE p.salary = :salary")})
public class Payment implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PaymentPK paymentPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "salary")
    private BigInteger salary;
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Employee employee;

    public Payment() {
    }

    public Payment(PaymentPK paymentPK) {
        this.paymentPK = paymentPK;
    }

    public Payment(PaymentPK paymentPK, BigInteger salary) {
        this.paymentPK = paymentPK;
        this.salary = salary;
    }

    public Payment(int employeeId, Date monthYear) {
        this.paymentPK = new PaymentPK(employeeId, monthYear);
    }

    public PaymentPK getPaymentPK() {
        return paymentPK;
    }

    public void setPaymentPK(PaymentPK paymentPK) {
        this.paymentPK = paymentPK;
    }

    public BigInteger getSalary() {
        return salary;
    }

    public void setSalary(BigInteger salary) {
        this.salary = salary;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paymentPK != null ? paymentPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Payment)) {
            return false;
        }
        Payment other = (Payment) object;
        if ((this.paymentPK == null && other.paymentPK != null) || (this.paymentPK != null && !this.paymentPK.equals(other.paymentPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "by.dreamteam.businessservices.entities.Payment[ paymentPK=" + paymentPK + " ]";
    }
    
}
