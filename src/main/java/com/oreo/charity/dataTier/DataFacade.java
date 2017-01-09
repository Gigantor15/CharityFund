package com.oreo.charity.dataTier;


import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.oreo.charity.beans.BankAccount;
import com.oreo.charity.beans.Event;


@Component(value = "facade")
public class DataFacade {

	private ApplicationContext ctxt;

	public DataFacade() {
		super();
	}


	public void setApplicationContext(ApplicationContext ctxt) throws BeansException {
		this.ctxt = ctxt;
	}
	
	
	public void test() {
		System.out.println("in DataFacade");
	}
	
	
	
	
	BankAccountDAO bankAccountDAO;
	public void setBankAccountDAO(BankAccountDAO bankAccountDAO) {
		this.bankAccountDAO = bankAccountDAO;
	}
	

	/*
	 * public void createEvent(List<Event> events){ for(Event event : events){
	 * eventDAO.insert(event); System.out.println("Event was inserted"); } }
	 */



	public void createEvent(Event event) {
		EventDAO eventDAO = new EventDAO();
		eventDAO.insert(event);
		System.out.println("Event was inserted");
	}

	public BankAccount getBankAccount() {
	
		BankAccountDAO bankAccountDAO = ctxt.getBean("bankAccountDAO", BankAccountDAO.class);
		
		// do DAO stuff
		BankAccount acc = bankAccountDAO.get(1);
		System.out.println(acc);
		return acc;
	}


	

	/*
	public OrganizationType getOrganizationType() {
		OrganizationTypeDAO organizationTypeDAO = new OrganizationTypeDAO();
		return organizationTypeDAO.get(1);
	}

	public UserRole getUserRole() {
		UserRoleDAO userRoleDAO = new UserRoleDAO();
		return userRoleDAO.get(1);
	}

	public Donation getDonation() {
		DonationDAO donationDAO = new DonationDAO();
		return donationDAO.get(1);
	}

	public Event getEvent() {
		EventDAO eventDAO = new EventDAO();
		return eventDAO.get(1);
	}

	public Organization getOrganization() {
		OrganizationDAO organizationDAO = new OrganizationDAO();
		return organizationDAO.get(1);
	}

	public User getUser() {
		UserDAO userDAO = new UserDAO();
		return userDAO.get(1);
	}
	 */
}
