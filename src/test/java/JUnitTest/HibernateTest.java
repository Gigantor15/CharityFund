package JUnitTest;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.BankAccount;
import beans.Donation;
import beans.Event;
import beans.Organization;
import beans.OrganizationType;
import beans.User;
import beans.UserRole;
import dataTier.BankAccountDAO;
import dataTier.DataFacade;
import dataTier.DonationDAO;
import dataTier.EventDAO;
import dataTier.OrganizationDAO;
import dataTier.OrganizationTypeDAO;
import dataTier.UserDAO;
import dataTier.UserRoleDAO;

public class HibernateTest {

	private SessionFactory sf = new Configuration().configure().buildSessionFactory();
	private static ApplicationContext contxt;

	@BeforeClass
	public static void setup() {
		contxt = new ClassPathXmlApplicationContext("beans.xml");
	}
	
	@Test
        @Ignore
	public void createEvent(){
		
		Organization org = contxt.getBean(OrganizationDAO.class).get(1);
		
		Timestamp startDate = new Timestamp(System.currentTimeMillis());
		Timestamp endDate = Timestamp.valueOf("2017-01-15 1:10:10.0");
		Event event = new Event(3,"Cancer", "support cancer", startDate, endDate, 10000, org);
		//contxt.getBean(EventDAO.class).insert(new Event(2,"Cancer 5K event", "Sponser a runner in the 5K race to support cancer", startDate, endDate, 20000, org));
		contxt.getBean(DataFacade.class).getContext();
		contxt.getBean(DataFacade.class).createEvent(event);
		System.out.println("Event was created!");
	}

       @Test
  //     @Ignore
       public void showAllOrganizations(){    
           DataFacade.getContext();
           List allOrgs = contxt.getBean(DataFacade.class).getAllOrganizations();
           System.out.print("Organization List: " + allOrgs);       
       }
       
       @Test
       @Ignore
       public void showAllEvents(){
           DataFacade.getContext();
           List allEvents = contxt.getBean(DataFacade.class).getAllEvents();
           System.out.println("Event List: " + allEvents);
       }
        
	@Test
	@Ignore
	public void testGetFromEveryTable() {

		BankAccount bean1 = contxt.getBean(BankAccountDAO.class).get(1);
		OrganizationType bean6 = contxt.getBean(OrganizationTypeDAO.class).get(1);
		UserRole bean2 = contxt.getBean(UserRoleDAO.class).get(1);
		Donation bean3 = contxt.getBean(DonationDAO.class).get(1);
		Event bean4 = contxt.getBean(EventDAO.class).get(1);
		Organization bean5 = contxt.getBean(OrganizationDAO.class).get(1);
		User bean7 = contxt.getBean(UserDAO.class).get(1);

		System.out.println(bean1);
		System.out.println(bean6);
		System.out.println(bean2);
		System.out.println(bean3);
		System.out.println(bean4);
		System.out.println(bean5);
		System.out.println(bean7);
	}

	@Test
	@Ignore
	public void testDonationInsert() {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		UserDAO userDAO = new UserDAO();
		EventDAO eventDAO = new EventDAO();

		User user = userDAO.get(1);
		Event event = eventDAO.get(1);
		Timestamp transactDate = new Timestamp(System.currentTimeMillis());

		Donation donation = new Donation(1, user, event, transactDate, 200.10);

		session.save(donation);

		tx.commit();
		session.close();
	}

	@Test
	@Ignore
	public void testEventInsert() {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		OrganizationDAO orgDAO = new OrganizationDAO();
		Organization org = orgDAO.get(1);

		Timestamp startDate = new Timestamp(System.currentTimeMillis());
		Timestamp endDate = Timestamp.valueOf("2017-01-10 10:10:10.0");

		Event event = new Event(1, "Save the Shelter Dogs", "saving the shelter dogs", startDate, endDate, 1000.00,
				org);

		session.save(event);

		tx.commit();
		session.close();
	}

	@Test
	@Ignore
	public void testOrganizationInsert() {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		OrganizationTypeDAO daoOT = new OrganizationTypeDAO();
		BankAccountDAO daoBank = new BankAccountDAO();
		UserDAO daoUser = new UserDAO();

		OrganizationType type = daoOT.get(1);
		BankAccount account = daoBank.get(1);
		User user = daoUser.get(1);

		System.out.println(type);
		System.out.println(account);
		System.out.println(user);

		Organization org1 = new Organization(1, "PETA", user, account, type);

		session.save(org1);

		tx.commit();
		session.close();
	}

	@Test
	@Ignore
	public void testGetUser() {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		UserDAO daoUser = new UserDAO();

		User user = daoUser.load(1);
		System.out.println(user);

		tx.commit();
		session.close();
	}

	@Test
	@Ignore
	public void testUserInsert() {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		UserRoleDAO daoRole = new UserRoleDAO();
		BankAccountDAO daoBank = new BankAccountDAO();

		UserRole role = daoRole.load(1);
		BankAccount bankAccount = daoBank.load(1);

		System.out.println(bankAccount);
		System.out.println(role);

		User user1 = new User(11, "Dan1", "Pickle1", "user1", "pass1", "dan1@pickle.com", bankAccount, role);

		session.save(user1);

		tx.commit();
		session.close();
	}

	@Test
	@Ignore
	public void testBankInsert() {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		BankAccount acct1 = new BankAccount(1, 123456789, 123456789, 100.23);
		session.save(acct1);

		tx.commit();
		session.close();
	}

	@Test
	@Ignore
	public void testUserRoleInsert() {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		UserRole typeMember = new UserRole(1, "member");
		UserRole typeManager = new UserRole(2, "manager");

		session.save(typeMember);
		session.save(typeManager);

		UserRole typeAdmin = new UserRole(3, "admin");
		session.save(typeAdmin);

		tx.commit();
		session.close();
	}

	@Test
	@Ignore
	public void testOrganizationTypeInsert() {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		OrganizationType type1 = new OrganizationType(1, "Animal");
		OrganizationType type2 = new OrganizationType(2, "Environmental");
		OrganizationType type3 = new OrganizationType(3, "International NGO");
		OrganizationType type4 = new OrganizationType(4, "Health");
		OrganizationType type5 = new OrganizationType(5, "Education");
		OrganizationType type6 = new OrganizationType(6, "Arts & Culture");
		OrganizationType type7 = new OrganizationType(7, "Other");

		session.save(type1);
		session.save(type2);
		session.save(type3);
		session.save(type4);
		session.save(type5);
		session.save(type6);
		session.save(type7);

		tx.commit();
		session.close();
	}
}
