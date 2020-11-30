package com.neighborpil.aopdemo;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.neighborpil.aopdemo.dao.AccountDAO;
import com.neighborpil.aopdemo.service.TrafficFortuneService;

public class AroundWithLoggerDemoApp {

	private static Logger myLogger = Logger.getLogger(AroundWithLoggerDemoApp.class.getName());
	
	public static void main(String[] args) {

		// read spring config java class
		var context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

		myLogger.info("\nMain Program: AroundDemoApp");
		
		myLogger.info("Calling getFortuneService");
		
		String data = theFortuneService.getFortune();
		
		myLogger.info("\nMy Fortune is: " + data);
		
		myLogger.info("Finished");
		
		// close the context
		context.close();
	}
}
