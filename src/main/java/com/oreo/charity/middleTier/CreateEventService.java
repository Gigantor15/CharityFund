package com.oreo.charity.middleTier;

import org.junit.BeforeClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.oreo.charity.beans.Event;
import com.oreo.charity.dataTier.DataFacade;

@Service(value="CreateEventService")
public class CreateEventService {

	private static ApplicationContext contxt;

	@BeforeClass
	public static void setup() {
		contxt = new ClassPathXmlApplicationContext("beans.xml");
	}
	
	@Autowired
	private DataFacade facade;

	public void setFacade(DataFacade facade) {
		this.facade = facade;
	}
	
	public void newEvent(Event event){
		contxt.getBean(DataFacade.class).createEvent(event);
	}
}
