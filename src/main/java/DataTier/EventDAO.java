package DataTier;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import beans.Event;

public class EventDAO {
	private SessionFactory sf = new Configuration().configure().buildSessionFactory();
	
	public Event get(int id) {
		return (Event) sf.openSession().get(Event.class, id);
	}
	public Event load(int id) {
		return (Event) sf.openSession().load(Event.class, id);
	}
	public void closeSessionFactory(){
		sf.close();
	}
}
