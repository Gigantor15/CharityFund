package JUnitTest;

import java.sql.Timestamp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Ignore;
import org.junit.Test;

import DataTier.UserRoleDAO;
import DataTier.BankAccountDAO;
import DataTier.OrganizationDAO;
import DataTier.OrganizationTypeDAO;
import DataTier.UserDAO;
import beans.BankAccount;
import beans.Event;
import beans.Organization;
import beans.OrganizationType;
import beans.User;
import beans.UserRole;

public class HibernateTest {
	private SessionFactory sf = new Configuration().configure().buildSessionFactory();
	
	
	@Test
	public void testEventInsert() {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		OrganizationDAO orgDAO = new OrganizationDAO();
		Organization org =  orgDAO.get(1);
		
		Timestamp startDate = new Timestamp( System.currentTimeMillis() );
		Timestamp endDate = Timestamp.valueOf("2017-01-10 10:10:10.0");
		
		Event event = new Event(1, "Save the Shelter Dogs", "saving the shelter dogs", startDate, endDate, 1000.00, org);
		
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
	
	
	

	/*
	 * UserInsert() is not working
	 * 8585 [main] WARN org.hibernate.util.JDBCExceptionReporter - SQL Error: 904, SQLState: 42000
     * 8585 [main] ERROR org.hibernate.util.JDBCExceptionReporter - ORA-00904: "USERROLE_USER_ROLE_ID": invalid identifier
	 */
	@Test
	@Ignore
	public void testUserInsert() {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		UserRoleDAO daoRole = new UserRoleDAO();
		BankAccountDAO daoBank = new BankAccountDAO();

		UserRole role = daoRole.load(1);			daoRole.closeSessionFactory();
		BankAccount bankAccount = daoBank.load(1);	daoBank.closeSessionFactory();
		
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
		
		BankAccount acct1 =  new BankAccount(1, 123456789, 123456789, 100.23);
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
