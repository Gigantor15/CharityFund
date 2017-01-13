package com.oreo.charity.middleTier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oreo.charity.beans.*;


@Component(value = "businessDelegate")
public class Delegate {

	private MainService mainService;
	private CreateEventService createEventService;
        private ViewEventService viewEventService;

	@Autowired
	public void setMainService(MainService mainService) {
		this.mainService = mainService;
	}
	
	@Autowired
	public void setUserService(CreateEventService createEventService){
		this.createEventService = createEventService;
	}
        
        @Autowired
        public void setViewEventService(ViewEventService viewEventService){
            this.viewEventService = viewEventService;
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
		return viewEventService.getAllEvents();
	}
        
        public List<Organization> getAllOrganizations(){
            return viewEventService.getAllOrganizations();
        }
        
        public List<Donation> getMadeBy(User user){
            return viewEventService.getMadeBy(user);
        }
        
        public List<Donation> getMadeTo(Event event){
            return viewEventService.getMadeTo(event);
        }
        
        public List<Donation> getAllDonations(){
            return viewEventService.getAllDonations();
        }
        
        public Double sumOfDonations(){
            return viewEventService.sumOfDonations();
        }

 

}
