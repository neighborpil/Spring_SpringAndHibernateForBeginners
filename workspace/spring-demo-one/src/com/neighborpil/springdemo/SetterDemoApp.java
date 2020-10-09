package com.neighborpil.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {
		
		// load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// retrieve bean from spring container
		CricketCoach theCoach = context.getBean("myCricketCoach", CricketCoach.class); 
		// <=여기서 Coach가 아닌 CricketCoach 클래스로 사용하는 이유는 Coach클래스에는 getTeam() 및 getEamilAddress()메소드가 없기 때문이다
		// Coach 클래스로 변수를 생성하면 getTeam() 및 getEamilAddress()메소드를 사용 할 수 없다
		
		// call methods on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		System.out.println(theCoach.getDailyFortune());
		
		// call our new methods to get the literal values
		System.out.println(theCoach.getEmailAddress());
		System.out.println(theCoach.getTeam());
		
		// close the context
		context.close();
	}

}
