package com.allen.springdemo;

public class MyCoach implements Coach {
	private FortuneService myRandomFortuneService;
	
	// no-arg constructor
	public MyCoach() {
		System.out.println("This is no-arg consturctor - MyCoach");
	}

	public void setMyRandomFortuneService(FortuneService myRandomFortuneService) {
		System.out.println("setMyRandomFortuneService - This is inside setMyRandomFortuneService class");
		this.myRandomFortuneService = myRandomFortuneService;
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDailyFortune() {
		return myRandomFortuneService.getFortune();
	}

}
