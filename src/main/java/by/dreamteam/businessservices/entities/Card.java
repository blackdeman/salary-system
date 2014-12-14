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
@Table(name = "card_tbl")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Card.findAll", query = "SELECT c FROM Card c"),
    @NamedQuery(name = "Card.findByEmployeeId", query = "SELECT c FROM Card c WHERE c.cardPK.employeeId = :employeeId"),
    @NamedQuery(name = "Card.findByDate", query = "SELECT c FROM Card c WHERE c.cardPK.date = :date"),
    @NamedQuery(name = "Card.findByHours", query = "SELECT c FROM Card c WHERE c.hours = :hours"),
    @NamedQuery(name = "Card.findByRatePerHour", query = "SELECT c FROM Card c WHERE c.ratePerHour = :ratePerHour")})
public class Card implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CardPK cardPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hours")
    private int hours;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rate_per_hour")
    private BigInteger ratePerHour;
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Employee employee;

    public Card() {
        this.cardPK = new CardPK();
        this.employee = new Employee();
    }

    public Card(CardPK cardPK) {
        this.cardPK = cardPK;
    }

    public Card(CardPK cardPK, int hours, BigInteger ratePerHour) {
        this.cardPK = cardPK;
        this.hours = hours;
        this.ratePerHour = ratePerHour;
    }

    public Card(int employeeId, Date date) {
        this.cardPK = new CardPK(employeeId, date);
    }

    public CardPK getCardPK() {
        return cardPK;
    }

    public void setCardPK(CardPK cardPK) {
        this.cardPK = cardPK;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public BigInteger getRatePerHour() {
        return ratePerHour;
    }

    public void setRatePerHour(BigInteger ratePerHour) {
        this.ratePerHour = ratePerHour;
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
        hash += (cardPK != null ? cardPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Card)) {
            return false;
        }
        Card other = (Card) object;
        return !((this.cardPK == null && other.cardPK != null) || (this.cardPK != null && !this.cardPK.equals(other.cardPK)));
    }

    @Override
    public String toString() {
        return "by.dreamteam.businessservices.entities.Card[ cardPK=" + cardPK + " ]";
    }
    
}
