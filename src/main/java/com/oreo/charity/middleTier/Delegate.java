package com.oreo.charity.middleTier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component(value="businessDelegate")
public class Delegate {

	private MainService mainService;
	@Autowired
	public void setUserService(MainService mainService) { this.mainService = mainService; }



	public void test() {
		System.out.println("in delegate");
		mainService.test();
	}


	public void createNewEvent(){
		
	}
}
