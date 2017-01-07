
package beans;

import javax.persistence.*;


@Entity
@Table(name = "CHARITY_ORGANIZATION")
public class Organization {

	@Id
	@Column(name = "ORGANIZATION_ID")
	private int organizationId;

	@Column(name = "ORGANIZATION_NAME", nullable = false, unique = true, updatable = false)
	private String organizationName;

	@OneToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
	@JoinColumn(name="ORGANIZATION_MANAGER_ID")
	private User managerId;

	@OneToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
	@JoinColumn(name="ORGANIZATION_BANK_ID")
	private BankAccount bankId;

	@OneToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
	@JoinColumn(name="ORGANIZATION_TYPE_ID")
	private OrganizationType organizationTypeId;

	public Organization() {
		super();
	}

	public Organization(int organizationId, String organizationName, User managerId, BankAccount bankId,
			OrganizationType organizationTypeId) {
		
		this.organizationId = organizationId;
		this.organizationName = organizationName;
		this.managerId = managerId;
		this.bankId = bankId;
		this.organizationTypeId = organizationTypeId;
	}

	@Override
	public String toString() {
		return "Organization [organizationId=" + organizationId + ", organizationName=" + organizationName
				+ ", managerId=" + managerId + ", BankAccount="+ bankId + ", organizationTypeId=" + organizationTypeId + "]";
	}

	public int getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(int organizationId) {
		this.organizationId = organizationId;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
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
