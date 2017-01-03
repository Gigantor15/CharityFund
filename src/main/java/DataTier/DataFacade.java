package DataTier;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component(value="facade")
public class DataFacade {

	private SessionFactory sessionFactory;
	private ApplicationContext ctxt;
	
	public void setApplicationContext(ApplicationContext ctxt){
		this.ctxt = ctxt;
	}
	
	public DataFacade(){
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}
}
