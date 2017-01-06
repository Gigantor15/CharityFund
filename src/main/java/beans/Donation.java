/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.sql.Timestamp;
import javax.persistence.*;

@Cacheable
@Entity
@Table(name="CHARITY_DONATION")
public class Donation {

    @Id
    @Column(name="DONATION_ID")
    private int donationId;
     
    @OneToOne(cascade=CascadeType.REMOVE, fetch=FetchType.LAZY) 	
    @JoinColumn(name="DONATION_DONATOR_ID") 
    private User donatorId;
    
    @OneToOne(cascade=CascadeType.REMOVE, fetch=FetchType.LAZY) 	
    @JoinColumn(name="DONATION_RECEIVER_ID") 
    private Event receiverId;
    
    @Column(name="DONATION_TRANSACTION_DATE", nullable=false, unique=true, updatable=false)
    private Timestamp transactionDate;
    
    @Column(name="DONATION_AMOUNT", nullable=false, unique=true, updatable=false)
    private double donationAmount;

    @Override
    public String toString() {
        return "Donation [doantionId=" + donationId + ", donatorId=" + donatorId + ", receiverId=" + receiverId
                + ", donationAmount=" + donationAmount + "]";
    }

    public int getDoantionId() {
        return donationId;
    }

    public void setDoantionId(int doantionId) {
        this.donationId = doantionId;
    }

    public User getDonatorId() {
        return donatorId;
    }

    public void setDonatorId(User donatorId) {
        this.donatorId = donatorId;
    }

    public Event getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Event receiverId) {
        this.receiverId = receiverId;
    }

    public Timestamp getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Timestamp transactionDate) {
        this.transactionDate = transactionDate;
    }

    public double getDonationAmount() {
        return donationAmount;
    }

    public void setDonationAmount(double donationAmount) {
        this.donationAmount = donationAmount;
    }

    public Donation(int donationId, User donatorId, Event receiverId, Timestamp transactionDate, double donationAmount) {
        super();
        this.donationId = donationId;
        this.donatorId = donatorId;
        this.receiverId = receiverId;
        this.transactionDate = transactionDate;
        this.donationAmount = donationAmount;
    }

    public Donation() {
        super();
    }
}
