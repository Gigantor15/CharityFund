package com.oreo.charity.webTier;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oreo.charity.middleTier.Delegate;

@Controller
public class CharityController {
	
	
	private Delegate delegate;

	@Autowired
	public void setDelegate(Delegate delegate) {
		this.delegate = delegate;
	}
	
	@RequestMapping(value = { "/" }, method = { RequestMethod.GET })
	public String getHome(HttpSession session) {
		return "index";
	}
	
	@RequestMapping(value = { "/home" }, method = { RequestMethod.GET })
	public String test(HttpSession session) {
		/*System.out.println("in Controller");
		delegate.test();	*/
		return "charityHome";
	}
	
	@ResponseBody
	@RequestMapping(value = { "/testget" }, method = { RequestMethod.GET })
	public String testget(HttpSession session) {
		return delegate.testGet().toString();
	}
	
/*	@RequestMapping(value= "/home/insert", method = RequestMethod.POST, consumes = "application/json" )
	public ResponseEntity createEvent(@RequestBody Event event, BindingResult result){
		if(result.hasErrors())
			return new ResponseEntity("Failed", HttpStatus.BAD_REQUEST);
		delegate.createNewEvent(event);
		return new ResponseEntity(HttpStatus.CREATED);
	}*/

}
