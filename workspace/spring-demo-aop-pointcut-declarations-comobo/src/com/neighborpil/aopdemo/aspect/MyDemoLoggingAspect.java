
package com.neighborpil.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	@Pointcut("execution(* com.neighborpil.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	// create pointcut for getter methods
	@Pointcut("execution(* com.neighborpil.aopdemo.dao.*.get*(..))")
	private void getter() {}
	
	// create pointcut for getter methods
	@Pointcut("execution(* com.neighborpil.aopdemo.dao.*.set*(..))")
	private void setter() {}
	
	// create point: include package ...exclude getter/setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageNoGetterSetter() {}
	
	@Before("forDaoPackageNoGetterSetter()") // 
	public void beforeAddAccountAdvice() {

		System.out.println("\n=====> Executing @Before advice on addAccount()");
		
	}
	
	@Before("forDaoPackageNoGetterSetter()") // 
	public void performApiAnalytics() {
		System.out.println("\n==> Performing API analytics");
	}
}