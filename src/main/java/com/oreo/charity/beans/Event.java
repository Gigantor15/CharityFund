package com.oreo.charity.beans;

import java.sql.Timestamp;
import javax.persistence.*;


@Cacheable
@Entity
@Table(name="CHARITY_EVENT")
public class Event {

    @Id
    @Column(name="EVENT_ID")
    private int eventId;
    
    @Column(name="EVENT_NAME", nullable=false, unique=true, updatable=false)
    private String eventName;
    
    @Column(name="EVENT_DESCRIPTION", nullable=false, unique=true, updatable=false)
    private String description;
    
    @Column(name="EVENT_START_DATE", nullable=false, unique=true, updatable=false)
    private Timestamp startDate;
    
    @Column(name="EVENT_END_DATE", nullable=false, unique=true, updatable=false)
    private Timestamp endDate;
    
    @Column(name="EVENT_GOAL_AMOUNT", nullable=false, unique=true, updatable=false)
    private double goalAmount;
    
    @ManyToOne(cascade=CascadeType.REMOVE, fetch=FetchType.EAGER) 	
    @JoinColumn(name="EVENT_ORGANIZATION_ID") 
    private Organization organizationId;

    public Event() {
        super();
    }

    public Event(int eventId, String eventName, String description, Timestamp startDate, Timestamp endDate,
    		double goalAmount, Organization organizationId) {
        super();
        this.eventId = eventId;
        this.eventName = eventName;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.goalAmount = goalAmount;
        this.organizationId = organizationId;
    }

    @Override
    public String toString() {
        return "Event [eventId=" + eventId + ", eventName=" + eventName + ", description=" + description
                + ", startDate=" + startDate + ", endDate=" + endDate + ", goalAmount=" + goalAmount
                + ", organizationId=" + organizationId + "]";
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

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    public double getGoalAmount() {
        return goalAmount;
    }

    public void setGoalAmount(double goalAmount) {
        this.goalAmount = goalAmount;
    }

    public Organization getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Organization organizationId) {
        this.organizationId = organizationId;
    }

}
