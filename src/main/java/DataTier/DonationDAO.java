package DataTier;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import beans.Donation;

public class DonationDAO {
	private SessionFactory sf = new Configuration().configure().buildSessionFactory();
	
	public Donation get(int id) {
		return (Donation) sf.openSession().get(Donation.class, id);
	}
	public Donation load(int id) {
		return (Donation) sf.openSession().load(Donation.class, id);
	}
	public void closeSessionFactory(){
		sf.close();
	}
}
