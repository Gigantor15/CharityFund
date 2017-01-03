package beans;

import javax.persistence.*;

@Entity()
@Table(name = "CHARITY_ORGANIZATION_TYPE")
public class OrganizationType {

	@Id
	@Column(name = "ORGANIZATION_TYPE_ID")
	private int id;

	@Column(name = "ORGANIZATION_TYPE_NAME")
	private String type;

	public OrganizationType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrganizationType(int id, String type) {
		this.id = id;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "OrganizationType [id=" + id + ", type=" + type + "]";
	}
}
