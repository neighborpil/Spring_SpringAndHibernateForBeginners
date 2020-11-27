package com.neighborpil.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.neighborpil.aopdemo.dao.AccountDAO;

public class MainDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		var context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		// call the business method
		theAccountDAO.addAccount();
		
		System.out.println("---Call Again---");
		
		// call the business method
		theAccountDAO.addAccount();

		// close the context
		context.close();
		
	}

}
