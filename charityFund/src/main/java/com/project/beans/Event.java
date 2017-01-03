package com.project.beans;

import java.sql.Timestamp;
import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Cacheable
@Entity
@Table(name="CHARITY_EVENT")
public class Event {

    @Id
    @Column(name="EVENT_ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
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
    private float goalAmount;
    
    @OneToOne(cascade=CascadeType.REMOVE, fetch=FetchType.EAGER) 	
    @JoinColumn(nullable=false) 
    @Column(name="EVENT_ORGANIZATION_ID", nullable=false, updatable=false)
    private Organization organizationId;

    public Event() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Event(int eventId, String eventName, String description, Timestamp startDate, Timestamp endDate,
            float goalAmount, Organization organizationId) {
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

    public float getGoalAmount() {
        return goalAmount;
    }

    public void setGoalAmount(float goalAmount) {
        this.goalAmount = goalAmount;
    }

    public Organization getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Organization organizationId) {
        this.organizationId = organizationId;
    }

}
