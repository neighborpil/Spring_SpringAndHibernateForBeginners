package com.neighborpil.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.neighborpil.aopdemo.dao.AccountDAO;

public class AfterFinallyDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		var context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		List<Account> theAccounts = null;

		try {
			// add a boolean flag to simulare exception
			boolean tripWire = false;
			theAccounts = theAccountDAO.findAccounts(tripWire);
		} catch (Exception ex) {
			System.out.println("\n\nMain Program... caught exception: " + ex);
		}
		
		// display the accounts
		System.out.println("\n\nMain Program: AfterThrowingDemoApp" );
		System.out.println("----");
		
		
		System.out.println(theAccounts);
		
		System.out.println("\n");

		// close the context
		context.close();
		
	}

}
