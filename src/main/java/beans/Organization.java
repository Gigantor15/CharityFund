
package com.project.beans;

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
@Table(name="CHARITY_ORGANIZATION")
public class Organization {
    
    @Id
    @Column(name="ORGANIZATION_ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int organizationId;
    
    @Column(name="ORGANIZATION_NAME", nullable=false, unique=true, updatable=false)
    private int organizationName;
    
    @OneToOne(cascade=CascadeType.REMOVE, fetch=FetchType.LAZY) 	
    @JoinColumn(nullable=false) 
    @Column(name="ORGANIZATION_MANAGER_ID", nullable=false, unique=true, updatable=false)
    private User managerId;
    
    @OneToOne(cascade=CascadeType.REMOVE, fetch=FetchType.LAZY) 	
    @JoinColumn(nullable=false) 
    @Column(name="ORGANIZATION_ID", nullable=false, unique=true, updatable=false)
    private BankAccount bankId;
    
    @OneToOne(cascade=CascadeType.REMOVE, fetch=FetchType.LAZY) 	
    @JoinColumn(nullable=false) 
    @Column(name="ORGANIZATION_TYPE_ID", nullable=false, updatable=false)
    private OrganizationType organizationTypeId;
    
    
    	public Organization() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Organization(int organizationId, int organizationName, User managerId, BankAccount bankId,
            OrganizationType organizationTypeId) {
        super();
        this.organizationId = organizationId;
        this.organizationName = organizationName;
        this.managerId = managerId;
        this.bankId = bankId;
        this.organizationTypeId = organizationTypeId;
    }

    @Override
    public String toString() {
        return "Organization [organizationId=" + organizationId + ", organizationName=" + organizationName
                + ", organizationTypeId=" + organizationTypeId + "]";
    }

    public int getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(int organizationId) {
        this.organizationId = organizationId;
    }

    public int getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(int organizationName) {
        this.organizationName = organizationName;
    }

    public User getManagerId() {
        return managerId;
    }

    public void setManagerId(User managerId) {
        this.managerId = managerId;
    }

    public BankAccount getBankId() {
        return bankId;
    }

    public void setBankId(BankAccount bankId) {
        this.bankId = bankId;
    }

    public OrganizationType getOrganizationTypeId() {
        return organizationTypeId;
    }

    public void setOrganizationTypeId(OrganizationType organizationTypeId) {
        this.organizationTypeId = organizationTypeId;
    }


}
