package beans;

import javax.persistence.*;

@Entity
@Table(name = "CHARITY_BANK")
public class BankAccount {

	@Id
	@Column(name = "BANK_ID")
	private int id;

	@Column(name = "BANK_ACCOUNT_NUMBER")
	private int accountNumber;

	@Column(name = "BANK_ACCOUNT_ROUTING_NUMBER")
	private int routingNumber;

	@Column(name = "BANK_ACCOUNT_BALANCE")
	private double balance;
	

	public BankAccount() {
		super();
	}

	public BankAccount(int id, int accountNumber, int routingNumber, double balance) {
		super();
		this.id = id;
		this.accountNumber = accountNumber;
		this.routingNumber = routingNumber;
		this.balance = balance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getRoutingNumber() {
		return routingNumber;
	}

	public void setRoutingNumber(int routingNumber) {
		this.routingNumber = routingNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "BankAccount [id=" + id + ", accountNumber=" + accountNumber + ", routingNumber=" + routingNumber
				+ ", balance=" + balance + "]";
	}

}
