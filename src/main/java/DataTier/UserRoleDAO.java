package DataTier;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import beans.UserRole;

public class UserRoleDAO {

	private SessionFactory sf = new Configuration().configure().buildSessionFactory();

	public UserRole get(int id) {
		return (UserRole) sf.openSession().get(UserRole.class, id);
	}
	
	public UserRole load(int id) {
		return (UserRole) sf.openSession().load(UserRole.class, id);
	}
	public void closeSessionFactory(){
		sf.close();
	}
}
