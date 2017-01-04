package beans;

import javax.persistence.*;

@Entity
@Table(name = "CHARITY_USER")
public class User {

	@Id
	@Column(name = "USER_ID")
	private int id;

	@Column(name = "USER_FIRST_NAME")
	private String firstName;

	@Column(name = "USER_LAST_NAME")
	private String lastName;

	@Column(name = "USER_USERNAME")
	private String username;

	@Column(name = "USER_PASSWORD")
	private String password;

	@Column(name = "USER_EMAIL")
	private String email;

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USER_BANK_ID")
	private BankAccount bankAccount;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USER_ROLE_ID")
	private UserRole userRole;

	public User() {
		super();
	}

	public User(int id, String firstName, String lastName, String username, String password, String email,
			BankAccount bankAccount, UserRole userRole) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.bankAccount = bankAccount;
		this.userRole = userRole;
	}

	public User(int id, String firstName, String lastName, String username, String password, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public BankAccount getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", username=" + username
				+ ", password=" + password + ", email=" + email + ", bankAccount=" + bankAccount + ", userRole="
				+ userRole + "]";
	}

}
