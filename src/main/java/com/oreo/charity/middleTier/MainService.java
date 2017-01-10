package com.oreo.charity.middleTier;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.oreo.charity.beans.Event;
import com.oreo.charity.dataTier.DataFacade;

@Service(value = "mainservice")
public class MainService {

	/*
	 * @Autowired private DataFacade facade; public void setFacade(DataFacade
	 * facade) { this.facade = facade; }
	 */

	ApplicationContext contxt;

	public MainService() {
		contxt = new ClassPathXmlApplicationContext("beans.xml");
	}

	public void test() {
		System.out.println("in service");
		contxt.getBean(DataFacade.class).test();
	}

	public Event testGet() {
		return contxt.getBean(DataFacade.class).getEvent();
	}

}
