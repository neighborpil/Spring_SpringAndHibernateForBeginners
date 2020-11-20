package com.neighborpil.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component("thatSillyCoach") // explicit bean id
//@Scope("prototype") // 留ㅻ쾲 �깉濡쒖슫 �씤�뒪�꽩�뒪瑜� �깮�꽦�븳�떎
@Component // default bean id
public class TennisCoach implements Coach {

	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	// define a default constructor
	public TennisCoach() {
		System.out.println(">>TennisCoach: inside default constructor");
	}
	
	@PostConstruct
	public void postConstruct() {
		System.out.println("postConstruct called");
	}
	
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println("preDestory called");
	}
	
//	@Autowired
//	public void doSomeCrazyStuff(FortuneService fortuneService) {
//		System.out.println(">>TennisCoach: inside setFortuneService() method");
//		this.fortuneService = fortuneService;
//	}
	
	/*
	// define a setter method
	@Autowired
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println(">>TennisCoach: inside setFortuneService() method");
		this.fortuneService = fortuneService;
	}
	*/
	/*
	@Autowired
	public TennisCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	*/
	
	@Override
	public String getDailyWorkout() {

		return "Practice your backhand volly";
	}

	@Override
	public String getDailyFortune() {
		
		return fortuneService.getFortune();
	}
}
