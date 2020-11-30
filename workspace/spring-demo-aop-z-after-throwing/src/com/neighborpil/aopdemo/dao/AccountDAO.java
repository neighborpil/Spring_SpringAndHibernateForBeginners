package com.neighborpil.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.neighborpil.aopdemo.Account;

@Component
public class AccountDAO {

	private String name;
	private String serviceCode;
	
	// add a new method: findAccutonts()
	public List<Account> findAccounts(boolean tripWire){
		
		// for academic purpose .. simulate an exception
		if(tripWire) {
			throw new RuntimeException("No soup for you");
		}
		
		List<Account> myAccounts = new ArrayList<>();
		
		// create sample accounts
		Account temp1 = new Account("Join", "Sliver");
		Account temp2 = new Account("Join22", "Gold");
		Account temp3 = new Account("Join33", "Platinum");
		
		// add them to out account list
		myAccounts.add(temp1);
		myAccounts.add(temp2);
		myAccounts.add(temp3);
		
		return myAccounts;
	}
	
	public void addAccount(Account theAccount, boolean vipFlag) {
		System.out.println(getClass() + ": Doing my work : add an account");
	}
	
	
	public boolean doWork() {
		System.out.println(getClass() + ": doWork()");
		return false;
	}
	

	public String getName() {
		System.out.println(getClass() + ": in getName()");
		return name;
	}


	public void setName(String name) {
		System.out.println(getClass() + ": in setName()");
		this.name = name;
	}


	public String getServiceCode() {
		System.out.println(getClass() + ": in getServiceCode()");
		return serviceCode;
	}


	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + ": in setServiceCode()");
		this.serviceCode = serviceCode;
	}
}
