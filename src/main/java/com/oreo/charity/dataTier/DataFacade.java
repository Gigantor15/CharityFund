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

	/*
	 * public void createEvent(List<Event> events){ for(Event event : events){
	 * eventDAO.insert(event); System.out.println("Event was inserted"); } }
	 */

	public BankAccount 			getBankAccount(int bankAccountId ) {return bankAccountDAO.get(bankAccountId); }
	public OrganizationType 	getOrganizationType(int organizationId) { return organizationTypeDAO.get(organizationId);}
	public UserRole 			getUserRole(int userRoleId) { return userRoleDAO.get(userRoleId); }
	public Donation 			getDonation(int donationId) { return donationDAO.get(donationId); }
	public Event 				getEvent(int eventId) { return eventDAO.get(eventId); }
	public Organization 		getOrganization(int organizationId) { return organizationDAO.get(organizationId); }
	public User 				getUser(int userId) { return userDAO.get(userId);}
	
	
	public void update(BankAccount account) {bankAccountDAO.update(account);}

	public List<Event> getAllEvents() {
		return eventDAO.getAllEvents();
	}

}
