package DataTier;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import beans.BankAccount;

public class BankAccountDAO {
	private SessionFactory sf = new Configuration().configure().buildSessionFactory();

	public BankAccount get(int id) {
		return (BankAccount) sf.openSession().get(BankAccount.class, id);
	}
	public BankAccount load(int id) {
		return (BankAccount) sf.openSession().load(BankAccount.class, id);
	}
	
	public void closeSessionFactory(){
		sf.close();
	}
}
