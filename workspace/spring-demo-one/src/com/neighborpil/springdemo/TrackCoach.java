package com.neighborpil.springdemo;

public class TrackCoach implements Coach {

	
	private FortuneService fortuneService;
	
	public TrackCoach() {
		
	}
	
	public TrackCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {

		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {

		return fortuneService.getFortune();
	}

	// add an init-method
	public void doMyStartUpStuffs() {
		System.out.println("TrackCoach: inside method doMyStartUpStuffs");
	}
	
	// add an destroy-method
	public void doMyCleanUpStuffs() {
		System.out.println("TrackCoach: inside method doCleanUpStuffs");
	}
}
