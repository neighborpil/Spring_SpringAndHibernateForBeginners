package com.neighborpil.springdemo;

public class TennisCoach implements Coach {


	private FortuneService fortuneService;
	
	public TennisCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		
		return "Swing 5000 times in 5 min";
	}

	@Override
	public String getDailyFortune() {

		return "Just do it: " + fortuneService.getFortune();
	}

}
