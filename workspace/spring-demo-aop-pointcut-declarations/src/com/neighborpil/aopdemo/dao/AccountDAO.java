package com.neighborpil.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.neighborpil.aopdemo.Account;

@Component
public class AccountDAO {

	
	public void addAccount(Account theAccount, boolean vipFlag) {
		System.out.println(getClass() + ": Doing my work : add an account");
	}
	
	
	public boolean doWork() {
		System.out.println(getClass() + ": in doWork()");
		return false;
	}


	
	
}
