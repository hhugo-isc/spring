package com.hh.springdemo;

public class BaseballCoach implements Coach {

//	Define a private field for dependency
	private FortuneService fortuneService;

	public BaseballCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	public String getDailyWorkout() {
		return "Spend 30 minutes on batting practice";
	}

	@Override
	public String getDailyFortune() {
//		use my fortunateService to get a fortune
		return fortuneService.getFortune();
	}

}
