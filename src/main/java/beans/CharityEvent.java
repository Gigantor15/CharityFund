package beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity()
@Table(name = "CHARITY_EVENT")
public class CharityEvent {

	@Column(name="EVENT_ID")
	private int eventId;
	@Column(name="EVENT_NAME")
	private String eventName;
	@Column(name="EVENT_DESCRIPTION")
	private String description;
	@Column(name="EVENT_START_DATE")
	private Date startDate;
	@Column(name="EVENT_END_DATE")
	private Date endDate;
	@Column(name="EVENT_GOAL_AMOUNT")
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
