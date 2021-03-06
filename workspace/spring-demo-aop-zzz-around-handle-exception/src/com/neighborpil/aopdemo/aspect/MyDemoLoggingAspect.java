
package com.neighborpil.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.neighborpil.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

	private static Logger myLogger = Logger.getLogger(MyDemoLoggingAspect.class.getName());

	@Before("com.neighborpil.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()") // 
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {

		myLogger.info("\n=====> Executing @Before advice on addAccount()");
		
		// display the method signature
		MethodSignature methodSig = (MethodSignature)theJoinPoint.getSignature();
		
		myLogger.info("Method: " + methodSig);
		
		// display method arguments
		
		// get args
		Object[] args = theJoinPoint.getArgs();
		
		// loop thru args
		
		for(Object tempArgs : args) {
			myLogger.info(tempArgs.toString());
			
			if(tempArgs instanceof Account) {
				// downcast and print Account specific stuff
				Account theAccount = (Account) tempArgs;
				
				myLogger.info("account name: " + theAccount.getName());
				myLogger.info("account level: " + theAccount.getLevel());
			}
		}
	}
	
	// add a new advice for @AfterReturning on the findAccounts method
	@AfterReturning(
			pointcut="execution(* com.neighborpil.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result){
		
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n=====>>>Executing @AfterReturning on method: " + method);
		
		// print out the results of the method call
		myLogger.info("\n=====>>>Result is : " + result);
		
		// let's post-process the data .. modify it
		
		// convert the account names to uppercase
		convertAccountNamesToUpperCase(result);
	}

	private void convertAccountNamesToUpperCase(List<Account> result) {
		
		// loop through accounts
		for(Account tempAccount : result) {
			
		// get uppercase version of name
		String theUpperName = tempAccount.getName().toUpperCase();
		
		// update the name on the account;
		tempAccount.setName(theUpperName);
		}
	}
	
	@AfterThrowing(
			pointcut="execution(* com.neighborpil.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing="theExc")
	public void afterThrowingFindAccountAdvice(
			JoinPoint theJoinPoint, Throwable theExc) {
		
		// print out witch mehtod we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n=====>>>Executing @AfterThrowing on method: " + method);

		// log the exception
		myLogger.info("\n====> The exception is: " + theExc);

	}
	
	@After("execution(* com.neighborpil.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
		

		// print out witch mehtod we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n=====>>>Executing @After(finally) on method: " + method);
		
	}
	
	
	@Around("execution(* com.neighborpil.aopdemo.service.*.*(..))")
	public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable{
		
		// print out witch mehtod we are advising on
		String method = theProceedingJoinPoint.getSignature().toShortString();
		myLogger.info("\n=====>>>Executing @Around on method: " + method);
		
		// get begin timestamp
		long begin = System.currentTimeMillis();
		
		// now, let's execute the method
		Object result = null; 
		try {
			result = theProceedingJoinPoint.proceed();
		} catch (Throwable e) {
			// got the exception
			myLogger.warning(e.getMessage()); // 여기서 예외처리 하기 때문에 메인 메소드는 예외를 알지 못한다
			
			//give user a custom message
			// result = "Major Accident!, But no warries";
			
			// rethrow exception
			result = e;
		}
		
		
		// get end timestamp
		long end = System.currentTimeMillis();
		
		// compute duration and display it 
		long duration = end - begin;
		myLogger.info("\n=====" + duration / 1000.0 + "sec");
		
		return result;
	}
}













