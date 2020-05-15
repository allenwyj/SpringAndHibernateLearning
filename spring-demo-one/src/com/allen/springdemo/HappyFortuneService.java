package com.allen.springdemo;

public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		
		return "Fortune 1 - HappyFortuneService";
	}

}
