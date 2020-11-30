package com.neighborpil.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.neighborpil.aopdemo.dao.AccountDAO;
import com.neighborpil.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		var context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

		System.out.println("\nMain Program: AroundDemoApp");
		
		System.out.println("Calling getFortuneService");
		
		String data = theFortuneService.getFortune();
		
		System.out.println("\nMy Fortune is: " + data);
		
		System.out.println("Finished");
		
		// close the context
		context.close();
	}
}
