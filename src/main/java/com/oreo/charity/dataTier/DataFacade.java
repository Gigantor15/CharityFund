package com.oreo.charity.dataTier;

import org.springframework.stereotype.Component;

import com.oreo.charity.beans.BankAccount;
import com.oreo.charity.beans.Donation;
import com.oreo.charity.beans.Event;
import com.oreo.charity.beans.Organization;
import com.oreo.charity.beans.OrganizationType;
import com.oreo.charity.beans.User;
import com.oreo.charity.beans.UserRole;
import java.util.List;

@Component(value = "facade")
public class DataFacade {

	// Contextual Session
	BankAccountDAO bankAccountDAO;

	public void setBankAccountDAO(BankAccountDAO bankAccountDAO) {
		this.bankAccountDAO = bankAccountDAO;
	}

	DonationDAO donationDAO;
	public void setDonationDAO(DonationDAO donationDAO) {
		this.donationDAO = donationDAO;
	}

	EventDAO eventDAO;
	public void setEventDAO(EventDAO eventDAO) {
		this.eventDAO = eventDAO;
	}

	OrganizationDAO organizationDAO;
	public void setOrganizationDAO(OrganizationDAO organizationDAO) {
		this.organizationDAO = organizationDAO;
	}

	OrganizationTypeDAO organizationTypeDAO;
	public void setOrganizationTypeDAO(OrganizationTypeDAO organizationTypeDAO) {
		this.organizationTypeDAO = organizationTypeDAO;
	}

	UserDAO userDAO;
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	UserRoleDAO userRoleDAO;
	public void setUserRoleDAO(UserRoleDAO userRoleDAO) {
		this.userRoleDAO = userRoleDAO;
	}

	public DataFacade() {
		super();
	}

	public void test() {
		System.out.println("in DataFacade");
	}

        public List<Organization> orgList(){
            return organizationDAO.getAll();
        }
        
        public List<Event> eventList(){
            return eventDAO.getAllEvents();
        }
        
        
	public void createEvent(Event event) {
		eventDAO.insert(event);
		System.out.println("Event was inserted");
	}
	
	public void insertBankAccount(BankAccount account) {
		bankAccountDAO.insert(account);
	}
	
	public BankAccount 			getBankAccount() {return bankAccountDAO.get(1); }
	public OrganizationType 	getOrganizationType() { return organizationTypeDAO.get(1);}
	public UserRole 			getUserRole() { return userRoleDAO.get(1); }
	public Donation 			getDonation() { return donationDAO.get(1); }
	public Event 				getEvent() { return eventDAO.get(1); }
	public Organization 		getOrganization() { return organizationDAO.get(1); }
	public User 				getUser() { return userDAO.get(1);}



	/*
	 * public void createEvent(List<Event> events){ for(Event event : events){
	 * eventDAO.insert(event); System.out.println("Event was inserted"); } }
	 */

}
