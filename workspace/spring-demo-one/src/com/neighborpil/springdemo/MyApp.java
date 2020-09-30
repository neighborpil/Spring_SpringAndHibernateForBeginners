package com.neighborpil.springdemo;

public class MyApp {

	public static void main(String[] args) {
		
		// create the object
		Coach theCoach = new BaseballCoach();
		
		// use the object
		System.out.println(theCoach.getDailyWorkout());

		theCoach = new TrackCoach();
		
		System.out.println(theCoach.getDailyWorkout()); // IoC : 쉬운 변경
	}
}
