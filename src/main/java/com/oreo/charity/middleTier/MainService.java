package com.oreo.charity.middleTier;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
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
