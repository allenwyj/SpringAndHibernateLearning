package com.allen.springdemo;

public class PracSevenCoach implements Coach {

	private FortuneService fortuneService;
	
	public PracSevenCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDailyFortune() {
		
		return fortuneService.getFortune();
	}

}
