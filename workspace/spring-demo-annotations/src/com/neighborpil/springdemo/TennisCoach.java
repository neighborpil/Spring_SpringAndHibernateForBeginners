package com.neighborpil.springdemo;

import org.springframework.stereotype.Component;

//@Component("thatSillyCoach") // explicit bean id
@Component // default bean id
public class TennisCoach implements Coach {

	@Override
	public String getDailyWorkout() {

		return "Practice your backhand volly";
	}

}
