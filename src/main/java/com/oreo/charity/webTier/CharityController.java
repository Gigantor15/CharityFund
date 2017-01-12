package com.oreo.charity.webTier;

import java.util.List;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oreo.charity.beans.Event;
import com.oreo.charity.middleTier.Delegate;

@Controller
public class CharityController {

	private Delegate delegate;

	@Autowired
	public void setDelegate(Delegate delegate) {
		this.delegate = delegate;
	}
	
	@ResponseBody
	@RequestMapping(value = { "/getAllEvents" }, method = RequestMethod.GET, produces = "application/json")
	public List<Event> getAll() {
		//Event event = new Event(1, "test", "test", null, null, 100, null);
		//Event event1 = new Event(2, "test1", "test1", null, null, 100, null);
		//Event event2 = new Event(3, "test2", "test2", null, null, 100, null);
		
		//List<Event> eventList = new ArrayList<Event>();
		//eventList.add(event1);
		//eventList.add(event2);
		//eventList.add(event);
		
		List<Event> eventList = delegate.getAllEvents();
		System.out.println(eventList);
		return eventList;
	}
	
	@RequestMapping(value = { "/" }, method = { RequestMethod.GET })
	public String getHome(HttpSession session) {
		return "index";
	}


	@ResponseBody
	@RequestMapping(value = { "/home" }, method = { RequestMethod.GET })
	public String test(HttpSession session) {
		System.out.println("in Controller");
		delegate.test();
		return "charityHome";
	}

	@ResponseBody
	@RequestMapping(value = { "/testget" }, method = { RequestMethod.GET })
	public String testget(HttpSession session) {
		return delegate.testGet().toString();
	}
	
	@ResponseBody
	@RequestMapping(value = { "/home/getAll" }, method = { RequestMethod.GET })
	public String getAll(HttpSession session) {
		return delegate.testGet().toString();
	}

	@ResponseBody
	@RequestMapping(value = { "/login" }, method = { RequestMethod.POST })
	public String login (HttpSession session) {
		return "test";
	}

	@SuppressWarnings("rawtypes")
    @RequestMapping(value = "/insert", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity insertEvent(@RequestBody Event event) {
        System.out.println(event);
        return new ResponseEntity(HttpStatus.CREATED);
    }
	
/*	@RequestMapping(value = "/home/insert", method = RequestMethod.POST, consumes = "application/json")
	public HttpEntity createEvent(@RequestBody String event) {
		System.out.println(event);
		if (result.hasErrors()) {
			return new ResponseEntity("Failed", HttpStatus.BAD_REQUEST);
		}
		//delegate.createNewEvent(event);
		return new ResponseEntity(HttpStatus.CREATED);
	}*/

}
