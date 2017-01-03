/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
@Table(name="CHARITY_USER")
public class User {
    
    @Id
    @Column(name="ORGANIZATION_TYPE_ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int userId;
    
    @Column(name="USER_FIRST_NAME", nullable=true, unique=true, updatable=false)
    private String first_name;
    
    @Column(name="USER_LAST_NAME", nullable=true, unique=true, updatable=false)
    private String last_name;
    
    @Column(name="USER_USERNAME", nullable=true, unique=true, updatable=false)
    private String username;
    
    @Column(name="USER_PASSWORD", nullable=true, unique=true, updatable=true)
    private String password;
    
    @Column(name="USER_EMAIL", nullable=true, unique=true, updatable=true)
    private String email;
    
    @OneToOne(cascade=CascadeType.REMOVE, fetch=FetchType.LAZY) 	
    @JoinColumn(nullable=false) 
    @Column(name="USER_ROLE_ID", nullable=false, unique=true, updatable=false)
    private UserRole userRoleId;
    
    @OneToOne(cascade=CascadeType.REMOVE, fetch=FetchType.EAGER) 	
    @JoinColumn(nullable=false) 
    @Column(name="USER_BANK_ID", nullable=false, unique=true, length=9, updatable=false)
    private BankAccount bankId;
    
    @Override
    public String toString() {
        return "User [userId=" + userId + ", first_name=" + first_name + ", last_name=" + last_name + ", username="
                + username + ", password=" + password + ", email=" + email + ", userRoleId=" + userRoleId + "]";
    }

    public User(int userId, String first_name, String last_name, String username, String password, String email,
            UserRole userRoleId, BankAccount bankId) {
        super();
        this.userId = userId;
        this.first_name = first_name;
        this.last_name = last_name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.userRoleId = userRoleId;
        this.bankId = bankId;
    }

    public User() {
        super();
        // TODO Auto-generated constructor stub
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserRole getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(UserRole userRoleId) {
        this.userRoleId = userRoleId;
    }

    public BankAccount getBankId() {
        return bankId;
    }

    public void setBankId(BankAccount bankId) {
        this.bankId = bankId;
    }

}
