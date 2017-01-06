package dataTier;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.Event;

public class DataFacade {
	
	private SessionFactory sf = new Configuration().configure().buildSessionFactory();
	private static ApplicationContext contxt;
	
	public static void getContext() {
		contxt = new ClassPathXmlApplicationContext("beans.xml");
	}
	
	private BankAccountDAO bankAccountDAO;
	private EventDAO eventDAO;
	
	
	public void setBankAccountDAO(BankAccountDAO bankAccountDAO) {
		this.bankAccountDAO = bankAccountDAO;
	}

	/*public void createEvent(List<Event> events){
		for(Event event : events){
			eventDAO.insert(event);
			System.out.println("Event was inserted");
		}
	}*/

	public void createEvent(Event event){
		contxt.getBean(EventDAO.class).insert(event);
		System.out.println("Event was inserted");		
	}
	
}
