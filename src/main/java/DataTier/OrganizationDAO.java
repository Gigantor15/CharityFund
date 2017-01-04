package DataTier;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import beans.Organization;

public class OrganizationDAO {
	private SessionFactory sf = new Configuration().configure().buildSessionFactory();

	public Organization get(int id) {
		return (Organization) sf.openSession().get(Organization.class, id);
	}
	public Organization load(int id) {
		return (Organization) sf.openSession().load(Organization.class, id);
	}
	public void closeSessionFactory(){
		sf.close();
	}
}
