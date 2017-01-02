package JUnitTest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import beans.OrganizationType;

public class HibernateTest {
	private SessionFactory sf = new Configuration().configure().buildSessionFactory();

	@Test
	public void testMappings() {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		OrganizationType typeMember = new OrganizationType(1001, "member");
		OrganizationType typeManager = new OrganizationType(1002, "manager");
		
		session.save(typeMember);
		session.save(typeManager);

		tx.commit();
		session.close();
	}
}
