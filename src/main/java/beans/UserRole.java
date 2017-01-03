package beans;

import javax.persistence.*;

@Entity()
@Table(name = "CHARITY_USER_ROLE")
public class UserRole {

	@Id
	@Column(name = "USER_ROLE_ID")
	private int id;

	@Column(name = "USER_ROLE_NAME")
	private String role;

	public UserRole() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserRole(int id, String role) {
		super();
		this.id = id;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserRole [id=" + id + ", role=" + role + "]";
	}

}
