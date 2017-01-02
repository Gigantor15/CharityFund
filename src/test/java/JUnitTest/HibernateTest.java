package JUnitTest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Ignore;
import org.junit.Test;

import beans.BankAccount;
import beans.OrganizationType;
import beans.UserRole;

public class HibernateTest {
	private SessionFactory sf = new Configuration().configure().buildSessionFactory();
	
	
	@Test
	@Ignore
	public void testBankInsert() {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		BankAccount acct1  = new BankAccount(1, 111, 100, 90.65);
		session.save(acct1);
		
		tx.commit();
		session.close();
	}
	
	@Test
	@Ignore
	public void testUserRoleInsert() {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		//UserRole typeMember = new UserRole(1001, "member");
		//UserRole typeManager = new UserRole(1002, "manager");
		
		//session.save(typeMember);
		//session.save(typeManager);
		
		UserRole typeAdmin = new UserRole(1003, "admin");
		session.save(typeAdmin);
		
		tx.commit();
		session.close();
	}
	
	@Test
	@Ignore
	public void testOrganizationTypeInsert() {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		OrganizationType type1 = new OrganizationType(1001, "Animal");
		OrganizationType type2 = new OrganizationType(1002, "Environmental");
		OrganizationType type3 = new OrganizationType(1003, "International NGO");
		OrganizationType type4 = new OrganizationType(1004, "Health");
		OrganizationType type5 = new OrganizationType(1005, "Education");
		OrganizationType type6 = new OrganizationType(1006, "Arts & Culture");
		OrganizationType type7 = new OrganizationType(1007, "Other");
		
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
