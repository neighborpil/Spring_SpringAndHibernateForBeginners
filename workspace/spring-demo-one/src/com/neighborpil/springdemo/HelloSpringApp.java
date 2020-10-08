package com.neighborpil.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {

		// load the spring configuration file
		var context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// reptrieve bean form spring container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		
		// call methods on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		// close the context
		context.close();
	}

}
