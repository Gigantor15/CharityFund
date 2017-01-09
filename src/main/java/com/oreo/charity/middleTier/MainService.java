package com.oreo.charity.middleTier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oreo.charity.dataTier.DataFacade;

@Service(value = "mainservice")
public class MainService {

	@Autowired
	private DataFacade facade;

	public void setFacade(DataFacade facade) {
		this.facade = facade;
	}

	public void test() {
		System.out.println("in service");
		facade.test();
	}

}
