package com.allen.springdemo;

import java.lang.Math;

public class RandomFortuneService implements FortuneService {

	private String[] fortuneServices = {"Fortune Service 1 - Hello", "Fortune Service 2 - Nihao", "Fortune Service 3 - 你好"};
	
	// generate a random number 
	private int randomNumberGenerator() {
		return (int) (Math.random() * fortuneServices.length);
	}
	
	@Override
	public String getFortune() {
		int index = randomNumberGenerator();
		return fortuneServices[index];
	}

}
