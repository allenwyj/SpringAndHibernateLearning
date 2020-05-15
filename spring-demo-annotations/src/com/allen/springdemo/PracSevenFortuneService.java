package com.allen.springdemo;

public class PracSevenFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		
		return "This is a single hard coded fortune";
	}

}
