package com.oreo.charity.middleTier;

import java.sql.Timestamp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.oreo.charity.beans.Event;
import com.oreo.charity.dataTier.DataFacade;

@Service(value="CreateEventService")
public class CreateEventService {

	private static ApplicationContext contxt;

	public CreateEventService() {
		contxt = new ClassPathXmlApplicationContext("beans.xml");
	}
	
	public void newEvent(Event event){
		contxt.getBean(DataFacade.class).createEvent(event);
		System.out.println(event);
	}
}
