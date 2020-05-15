package com.allen.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyPracApp {

	public static void main(String[] args) {
		
		// load context
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// retrieve beans
		MyCoach theCoach = context.getBean("myPracCoach", MyCoach.class);
		
		// get values
		System.out.println(theCoach.getDailyFortune());
		
		// close the context
		context.close();
		
	}

}
