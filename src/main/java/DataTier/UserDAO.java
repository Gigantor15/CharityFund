package DataTier;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import beans.User;



public class UserDAO {
	private SessionFactory sf = new Configuration().configure().buildSessionFactory();
	
	public User get(int id) {
		return (User) sf.openSession().get(User.class, id);
	}
	public User load(int id) {
		return (User) sf.openSession().load(User.class, id);
	}
	public void closeSessionFactory(){
		sf.close();
	}
}
