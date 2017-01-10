package com.oreo.charity.middleTier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oreo.charity.beans.Event;


@Component(value = "businessDelegate")
public class Delegate {

	private MainService mainService;
	private CreateEventService createEventService;

	@Autowired
	public void setUserService(MainService mainService) {
		this.mainService = mainService;
	}

	public void test() {
		System.out.println("in delegate");
		mainService.test();
	}



	public void createNewEvent(Event event){
		createEventService.newEvent(event);
	}

	public Event testGet() {
		return mainService.testGet();
	}

}
