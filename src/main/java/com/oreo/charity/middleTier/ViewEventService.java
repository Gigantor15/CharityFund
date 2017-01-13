package com.oreo.charity.middleTier;


import com.oreo.charity.beans.Donation;
import com.oreo.charity.beans.Event;
import com.oreo.charity.beans.Organization;
import com.oreo.charity.beans.User;
import com.oreo.charity.dataTier.DataFacade;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;


@Service(value = "ViewEventService")
public class ViewEventService {

	/*
	 * @Autowired private DataFacade facade; public void setFacade(DataFacade
	 * facade) { this.facade = facade; }
	 */

	ApplicationContext contxt;
        Event event;

	public ViewEventService() {
		contxt = new ClassPathXmlApplicationContext("beans.xml");
	}

	public void test() {
		System.out.println("in View Event Service");
		contxt.getBean(DataFacade.class).test();
	}

	public Event testGet() {
		return contxt.getBean(DataFacade.class).getEvent(1);
	}
        
        public List<Organization> getAllOrganizations(){
            return contxt.getBean(DataFacade.class).getAllOrganizations();
        }

	public List<Event> getAllEvents() {
		return contxt.getBean(DataFacade.class).getAllEvents();
	}
        
        public List<Donation> getMadeBy(User user){
            return contxt.getBean(DataFacade.class).getMadeBy(user);
        }
        
        public List<Donation> getMadeTo(Event event){
            return contxt.getBean(DataFacade.class).getMadeTo(event);
        }
        
        public List<Donation> getAllDonations(){
            return contxt.getBean(DataFacade.class).getAllDonations();
        }
        
        public Double sumOfDonations(){
            return contxt.getBean(DataFacade.class).sumOfDonations(event);
        }
        
}