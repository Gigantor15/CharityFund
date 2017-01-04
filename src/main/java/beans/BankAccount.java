package beans;


import javax.persistence.*;


@Entity
@Table(name="CHARITY_BANK")
public class BankAccount {
	
	@Id
	@Column(name="BANK_ACCOUNT_ID")
	private int bankId;
	
	@Column(name="BANK_ACCOUNT_NUMBER", nullable=false, unique=true, length=9, updatable=false)
	private int accountNum;
	
	@Column(name="BANK_ACCOUNT_ROUTING_NUMBER", nullable=false, length=9, updatable=false)
	private int routingNum;
	
	@Column(name="BANK_ACCOUNT_BALANCE", nullable=false, updatable=true)
	private double balance;
	
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
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public BankAccount(int bankId, int accountNum, int routingNum, double balance) {
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
