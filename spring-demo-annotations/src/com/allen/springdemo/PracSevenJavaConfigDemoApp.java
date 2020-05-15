package com.allen.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PracSevenJavaConfigDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PracSevenSpringConfig.class);

		// get the bean from spring container
		Coach theCoach = context.getBean("pracSevenCoach", Coach.class);
		
		// Coach for practice exercise
		// Coach theCoach = context.getBean("pracCoach", Coach.class);
		
		
		// call method to get the daily fortune
		System.out.println(theCoach.getDailyFortune());
		
		// close the context
		context.close();
	}

}
