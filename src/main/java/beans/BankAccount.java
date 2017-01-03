package com.project.beans;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class BankAccount {
	
	@Id
	@Column(name="BANK_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int bankId;
	
	@Column(name="BANK_ACCOUNT_NUMBER", nullable=false, unique=true, length=9, updatable=false)
	private int accountNum;
	
	@Column(name="BANK_ACCOUNT_ROUTING_NUMBER", nullable=false, length=9, updatable=false)
	private int routingNum;
	
	@Column(name="BANK_ACCOUNT_BALANCE", nullable=false, unique=true, updatable=true)
	private float balance;
	@Override
	public String toString() {
		return "BankAccount [bankId=" + bankId + ", accountNum=" + accountNum + ", routingNum=" + routingNum
				+ ", balance=" + balance + "]";
	}
	public int getBankId() {
		return bankId;
	}
	public void setBankId(int bankId) {
		this.bankId = bankId;
	}
	public int getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(int accountNum) {
		this.accountNum = accountNum;
	}
	public int getRoutingNum() {
		return routingNum;
	}
	public void setRoutingNum(int routingNum) {
		this.routingNum = routingNum;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public BankAccount(int bankId, int accountNum, int routingNum, float balance) {
		super();
		this.bankId = bankId;
		this.accountNum = accountNum;
		this.routingNum = routingNum;
		this.balance = balance;
	}
	public BankAccount() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
