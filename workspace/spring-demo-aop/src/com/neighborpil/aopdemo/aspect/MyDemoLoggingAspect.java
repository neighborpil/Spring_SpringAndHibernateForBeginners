package com.neighborpil.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	// this is where we add all of our related advices for logging
	
	// let's start with an @Before avice
	
	// @Before("execution(public void addAccount())")
	// @Before("execution(void add*())")
	// @Before("execution(public void addAccount(..))") // 0개 또는 1개 이상의 모든 파라미터
	// @Before("execution(* add*())") // 모든 리턴타입, add로 시작하는 모든 함수, 파라미터는 없음
//	 @Before("execution(void add*(Account))") // 파라미터가 전체 경로가 아니기 때문에 오류 발생
//	 @Before("execution(void add*(com.neighborpil.aopdemo.Account))") // Account파라미터 하나만 있는 함수이다
//	 @Before("execution(void add*(com.neighborpil.aopdemo.Account, ..))") // Account 파라미터를 반드시 포함하고, 나머지 파라미터는 있어도 되고 없어도 됨
	 @Before("execution(* com.neighborpil.aopdemo.dao.*.*(..))") // 어떠한 modifier, 어떠한 리턴타입, com.neighborpil.aopdemo.dao패키지 내 어떠한 클래스 내에 어떠한 메소드, 어떠한 파라미터
	public void beforeAddAccountAdvice() {

		System.out.println("\n=====> Executing @Before advice on addAccount()");
		
	}
}
