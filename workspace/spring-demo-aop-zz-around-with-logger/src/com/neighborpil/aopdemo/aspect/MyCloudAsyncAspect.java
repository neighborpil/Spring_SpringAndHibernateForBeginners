package com.neighborpil.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudAsyncAspect {

	@Before("com.neighborpil.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()") // 
	public void logToCloudeAsyn() {
		System.out.println("\n==> Logging to cloude in asnyc function");
	}
}
