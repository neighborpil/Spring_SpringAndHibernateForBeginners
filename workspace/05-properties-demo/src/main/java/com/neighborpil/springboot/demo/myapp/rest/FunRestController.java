package com.neighborpil.springboot.demo.myapp.rest;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

	// expose "/" that return "Hello World"
	@GetMapping("/")
	public String sayHello() {
		
		return "Hello Wolrd! Time on server is " + LocalDateTime.now();
	}
	
	
	// expose a new endpoint for "workout"
	@GetMapping("/workout")
	public String getDailyWorkout() {
		
		return "Run a hard 5k";
	}
	
	
	@GetMapping("/fortune")
	public String getDailyFortune() {
		
		return "Today is your lucky day";
	}
}
