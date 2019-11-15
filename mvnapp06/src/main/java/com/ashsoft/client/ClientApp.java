package com.ashsoft.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ashsoft.beans.HelloBean;

public class ClientApp {
  
	public void wish()
	{
		@SuppressWarnings("resource")
		ApplicationContext context= new ClassPathXmlApplicationContext("/com/ashsoft/resources/applicationContext.xml");
		HelloBean helloBean=(HelloBean) context.getBean("helloBean");
		String message=helloBean.sayHello("Sachin");
		System.out.println(message);
	}
}
