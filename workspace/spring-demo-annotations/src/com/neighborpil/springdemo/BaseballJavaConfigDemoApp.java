package com.neighborpil.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BaseballJavaConfigDemoApp {

	public static void main(String[] args) {

		// read spring config file
		var context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		// get the bean from spring container
		// Coach theCoach = context.getBean("thatSillyCoach", Coach.class);
		BaseballCoach theCoach = context.getBean("baseballCoach", BaseballCoach.class);
		
		// call a method on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		// call method to get the daily fortune
		System.out.println(theCoach.getDailyFortune());
		
		// call our new swim coach methods .. has the props values injected
		System.out.println("email: " + theCoach.getEmail());
		System.out.println("team: " + theCoach.getTeam());
		
		// close the context
		context.close();
	}

}
