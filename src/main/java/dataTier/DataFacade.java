package dataTier;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.Event;
import beans.Organization;
import java.util.List;

public class DataFacade {
  
    private SessionFactory sf = new Configuration().configure().buildSessionFactory();
    private static ApplicationContext contxt;

    public static void getContext() {
        contxt = new ClassPathXmlApplicationContext("beans.xml");
    }

    private BankAccountDAO bankAccountDAO;
    private DonationDAO donationDAO;
    private EventDAO eventDAO;
    private OrganizationDAO organizationDAO;
    private OrganizationTypeDAO organizationTypeDAO;
    private UserDAO userDAO;
    private UserRoleDAO userRoleDAO;

    /*public void createEvent(List<Event> events){
		for(Event event : events){
			eventDAO.insert(event);
			System.out.println("Event was inserted");
		}
	}*/
    public void createEvent(Event event) {
        contxt.getBean(EventDAO.class).insert(event);
        System.out.println("Event was inserted");
    }

    public List<Organization> getAllOrganizations() {
        return contxt.getBean(OrganizationDAO.class).getAll();
    }

    public List<Event> getAllEvents() {
        return contxt.getBean(EventDAO.class).getAll();
    }

    public BankAccountDAO getBankAccountDAO() {
        return bankAccountDAO;
    }

    public void setBankAccountDAO(BankAccountDAO bankAccountDAO) {
        this.bankAccountDAO = bankAccountDAO;
    }

    public DonationDAO getDonaiontDAO() {
        return donationDAO;
    }

    public void setDonationDAO(DonationDAO donationDAO) {
        this.donationDAO = donationDAO;
    }

    /**
     * @return the eventDAO
     */
    public EventDAO getEventDAO() {
        return eventDAO;
    }

    /**
     * @param eventDAO the eventDAO to set
     */
    public void setEventDAO(EventDAO eventDAO) {
        this.eventDAO = eventDAO;
    }

    /**
     * @return the organizationDAO
     */
    public OrganizationDAO getOrganizationDAO() {
        return organizationDAO;
    }

    /**
     * @param organizationDAO the organizationDAO to set
     */
    public void setOrganizationDAO(OrganizationDAO organizationDAO) {
        this.organizationDAO = organizationDAO;
    }

    /**
     * @return the organizationTypeDAO
     */
    public OrganizationTypeDAO getOrganizationTypeDAO() {
        return organizationTypeDAO;
    }

    /**
     * @param organizationTypeDAO the organizationTypeDAO to set
     */
    public void setOrganizationTypeDAO(OrganizationTypeDAO organizationTypeDAO) {
        this.organizationTypeDAO = organizationTypeDAO;
    }

    /**
     * @return the userDAO
     */
    public UserDAO getUserDAO() {
        return userDAO;
    }

    /**
     * @param userDAO the userDAO to set
     */
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    /**
     * @return the userRoleDAO
     */
    public UserRoleDAO getUserRoleDAO() {
        return userRoleDAO;
    }

    /**
     * @param userRoleDAO the userRoleDAO to set
     */
    public void setUserRoleDAO(UserRoleDAO userRoleDAO) {
        this.userRoleDAO = userRoleDAO;
    }

}
