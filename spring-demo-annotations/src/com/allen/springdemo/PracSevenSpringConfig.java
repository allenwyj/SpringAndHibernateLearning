package com.allen.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PracSevenSpringConfig {
	
	@Bean
	public FortuneService pracSevenFortuneService() {
		return new PracSevenFortuneService();
	}
	
	@Bean
	public Coach pracSevenCoach() {
		return new PracSevenCoach(pracSevenFortuneService());
	}

}
