package beans;

public class BankAccount {

	private int id;
	private int accountNumber;
	private int routingNumber;
	private double balance;

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
