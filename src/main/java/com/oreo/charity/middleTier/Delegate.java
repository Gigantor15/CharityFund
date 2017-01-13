package com.oreo.charity.middleTier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oreo.charity.beans.Event;


@Component(value = "businessDelegate")
public class Delegate {

	private MainService mainService;
	private CreateEventService createEventService;
        private UserViewService userViewService;

	@Autowired
	public void setMainService(MainService mainService) {
		this.mainService = mainService;
	}
	
	@Autowired
	public void setUserService(CreateEventService createEventService){
		this.createEventService = createEventService;
	}
        
        @Autowired
        public void setUserViewService(UserViewService userViewService){
            this.userViewService = userViewService;
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
	
	public List<Event> getAllEvents(){
		return mainService.getAllEvents();
	}

}
