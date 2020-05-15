package com.allen.springdemo;

import org.springframework.stereotype.Component;

@Component
public class DatabaseFortuneService implements FortuneService {

	public DatabaseFortuneService() {
		System.out.println(">> DatabaseFortuneService: inside default constructor");
	}
	
	@Override
	public String getFortune() {
		// TODO Auto-generated method stub
		return null;
	}

}
