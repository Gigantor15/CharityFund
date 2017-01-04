package beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity()
@Table(name = "CHARITY_EVENT")
public class CharityEvent {

	@Id
	@Column(name="EVENT_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int eventId;
	
	@Column(name="EVENT_NAME", nullable=false, unique=true, updatable=false)
	private String eventName;
	
	@Column(name="EVENT_DESCRIPTION", nullable=false, unique=true, updatable=false)
	private String description;
	
	@Column(name="EVENT_START_DATE", nullable=false, unique=true, updatable=false)
	private Date startDate;
	
	@Column(name="EVENT_END_DATE", nullable=false, unique=true, updatable=false)
	private Date endDate;
	
	@Column(name="EVENT_GOAL_AMOUNT", nullable=false, unique=true, updatable=false)
	private int goalAmt;
	
	@Column(name="EVENT_ORGANIZATION_ID")
	private int orgId;
	
	
	
	@Override
	public String toString() {
		return "CharityEvent [eventId=" + eventId + ", eventName=" + eventName + ", description=" + description
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", goalAmt=" + goalAmt + ", orgId=" + orgId
				+ "]";
	}
	public CharityEvent() {
		super();
	}
	public CharityEvent(int eventId, String eventName, String description, Date startDate, Date endDate, int goalAmt,
			int orgId) {
		super();
		this.eventId = eventId;
		this.eventName = eventName;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.goalAmt = goalAmt;
		this.orgId = orgId;
	}
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public int getGoalAmt() {
		return goalAmt;
	}
	public void setGoalAmt(int goalAmt) {
		this.goalAmt = goalAmt;
	}
	public int getOrgId() {
		return orgId;
	}
	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}
	
	
	
}
