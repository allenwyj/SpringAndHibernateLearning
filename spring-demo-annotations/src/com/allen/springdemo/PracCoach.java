package com.allen.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PracCoach implements Coach {

	@Autowired
	@Qualifier("pracFortuneService")
	private FortuneService myFortuneService;
	
	public PracCoach() {
		System.out.println(">> PracCoach: This is inside the default constructor.");
	}
	
	@Override
	public String getDailyWorkout() {
		return "Nothing here.";
	}

	@Override
	public String getDailyFortune() {
		return myFortuneService.getFortune();
	}

}
