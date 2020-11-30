package com.neighborpil.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.neighborpil.aopdemo.dao.AccountDAO;

public class AfterReturningDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		var context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		List<Account> theAccounts = theAccountDAO.findAccounts(false);
		
		// display the accounts
		System.out.println("\n\nMain Program: AfterReturning" );
		System.out.println("----");
		
		
		System.out.println(theAccounts);
		
		System.out.println("\n");

		// close the context
		context.close();
		
	}

}
