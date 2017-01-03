package DataTier;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import beans.OrganizationType;

public class OrganizationTypeDAO {
	private SessionFactory sf = new Configuration().configure().buildSessionFactory();

	public OrganizationType get(int id) {
		return (OrganizationType) sf.openSession().get(OrganizationType.class, id);
	}
	public OrganizationType load(int id) {
		return (OrganizationType) sf.openSession().load(OrganizationType.class, id);
	}
	public void closeSessionFactory(){
		sf.close();
	}
}
