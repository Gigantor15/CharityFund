/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.beans;

import java.sql.Timestamp;
import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Cacheable
@Entity
@Table(name="CHARITY_DONATION")
public class Donation {

    @Id
    @Column(name="DONATION_ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int doantionId;
     
    @OneToOne(cascade=CascadeType.REMOVE, fetch=FetchType.LAZY) 	
    @JoinColumn(nullable=false) 
    @Column(name="DONATION_DONATOR_ID", nullable=false, unique=true, updatable=false)
    private User donatorId;
    
    @OneToOne(cascade=CascadeType.REMOVE, fetch=FetchType.LAZY) 	
    @JoinColumn(nullable=false) 
    @Column(name="DONATION_RECEIVER_ID", nullable=false, unique=true, updatable=false)
    private User receiverId;
    
    @Column(name="DONATION_TRANSACTION_DATE", nullable=false, unique=true, updatable=false)
    private Timestamp transactionDate;
    
    @Column(name="DONATION_AMOUNT", nullable=false, unique=true, updatable=false)
    private float donationAmount;

    @Override
    public String toString() {
        return "Donation [doantionId=" + doantionId + ", donatorId=" + donatorId + ", receiverId=" + receiverId
                + ", donationAmount=" + donationAmount + "]";
    }

    public int getDoantionId() {
        return doantionId;
    }

    public void setDoantionId(int doantionId) {
        this.doantionId = doantionId;
    }

    public User getDonatorId() {
        return donatorId;
    }

    public void setDonatorId(User donatorId) {
        this.donatorId = donatorId;
    }

    public User getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(User receiverId) {
        this.receiverId = receiverId;
    }

    public Timestamp getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Timestamp transactionDate) {
        this.transactionDate = transactionDate;
    }

    public float getDonationAmount() {
        return donationAmount;
    }

    public void setDonationAmount(float donationAmount) {
        this.donationAmount = donationAmount;
    }

    public Donation(int doantionId, User donatorId, User receiverId, Timestamp transactionDate, float donationAmount) {
        super();
        this.doantionId = doantionId;
        this.donatorId = donatorId;
        this.receiverId = receiverId;
        this.transactionDate = transactionDate;
        this.donationAmount = donationAmount;
    }

    public Donation() {
        super();
        // TODO Auto-generated constructor stub
    }
}
