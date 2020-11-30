package com.neighborpil.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.neighborpil.aopdemo.dao.AccountDAO;
import com.neighborpil.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		var context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		
		// call the business method
		Account myAccount = new Account();
		myAccount.setName("peter");
		myAccount.setLevel("Three");
		theAccountDAO.addAccount(myAccount, true);
		theAccountDAO.doWork();
		
		// call the accountdao getter/setter methods
		theAccountDAO.setName("foobar");
		theAccountDAO.setServiceCode("siver");
		
		String name = theAccountDAO.getName();
		String code = theAccountDAO.getServiceCode();
		
		System.out.println("--- Membership DAO ---");
		
		// call the business method
		theMembershipDAO.addSillyMember();
		theMembershipDAO.goToSleep();

		// close the context
		context.close();
		
	}

}
