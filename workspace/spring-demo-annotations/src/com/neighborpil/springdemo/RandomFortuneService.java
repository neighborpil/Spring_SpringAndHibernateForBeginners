package com.neighborpil.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	// create a array of strings
	private String[] _data = {
			"Beware of the wolf in sheep's clothing",
			"Diligence is the mother of good luck",
			"Get a lotto6"
	};
	
	//create a random number generator
	private Random _random = new Random();
	
	@Override
	public String getFortune() {

		// pick a random string from the array
		int index = _random.nextInt(_data.length);
		
		return _data[index];
	}
}
