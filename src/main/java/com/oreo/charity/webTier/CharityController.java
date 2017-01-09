package com.oreo.charity.webTier;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oreo.charity.beans.User;
import com.oreo.charity.dataTier.UserDAO;
import com.oreo.charity.middleTier.Delegate;

@Controller
public class CharityController {
	
	
	private Delegate delegate;

	@Autowired
	public void setDelegate(Delegate delegate) {
		this.delegate = delegate;
	}

	@ResponseBody
	@RequestMapping(value = { "/home" }, method = { RequestMethod.GET }, produces = { "application/json" })
	public void test(HttpSession session) {
		System.out.println("in Controller");
		delegate.test();	
	}

	// localhost:9001/charityFund/user/18
	@ResponseBody
	@RequestMapping(value = "/user/{param}", // PathParam
			        method = RequestMethod.GET, produces = "application/json")
	public User getDan(@PathVariable(value = "param") int id) {
		ApplicationContext contxt = new ClassPathXmlApplicationContext("beans.xml");
		User user = contxt.getBean(UserDAO.class).get(id);
		System.out.println(user);
		return user;
	}
	

	// localhost:9001/charityFund/user?q=__
	@ResponseBody
	@RequestMapping(value = "/user", method = RequestMethod.GET, produces = "application/json")
	public User getUser(@RequestParam(value = "q") int id) {
		ApplicationContext contxt = new ClassPathXmlApplicationContext("beans.xml");
		User user = contxt.getBean(UserDAO.class).get(id);
		System.out.println(user);
		return user;
	}
	
	/*
	@ResponseBody
	@RequestMapping(value = "trainees", method = RequestMethod.GET, produces = "application/json")
	public List<Trainee> getAll() {
		return businessDelegate.getAll();
	}

	@RequestMapping(value = "/trainee/insert", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity insert(@RequestBody @Valid Trainee obj, BindingResult result) { // BResult
																							// holds
																							// errors
		if (result.hasErrors()) {
			return new ResponseEntity("Failed", HttpStatus.BAD_REQUEST);
		}

		businessDelegate.insert(obj);
		return new ResponseEntity(HttpStatus.CREATED);
	}
*/

}
