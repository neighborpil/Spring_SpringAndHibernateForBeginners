package com.neighborpil.springdemo.mvc;

import java.util.LinkedHashMap;

public class Student {

	private String firstName;
	
	private String lastName;
	
	private String country;
	
//	private LinkedHashMap<String, String> countryOptions;

	private String favoriteLanguage;
	
	private LinkedHashMap<String, String> languageOptions;
	
	private String[] operatingSystems;
	
	public Student() {

		/*
		 * // populate country options: used ISO country code countryOptions = new
		 * LinkedHashMap<String, String>();
		 * 
		 * countryOptions.put("BR", "Brazil"); countryOptions.put("FR", "France");
		 * countryOptions.put("DE", "Germany"); countryOptions.put("IN", "India");
		 * countryOptions.put("US", "United States of Ameria");
		 */
		
		languageOptions = new LinkedHashMap<String, String>();
		languageOptions.put("C#", "C#");
		languageOptions.put("Go", "Go");
		languageOptions.put("Python", "Python");
		languageOptions.put("C", "C");
		languageOptions.put("C++", "C++");
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getFavoriteLanguage() {
		return favoriteLanguage;
	}

	public void setFavoriteLanguage(String favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}

	public LinkedHashMap<String, String> getLanguageOptions() {
		return languageOptions;
	}

	public String[] getOperatingSystems() {
		return operatingSystems;
	}

	public void setOperatingSystems(String[] operatingSystems) {
		this.operatingSystems = operatingSystems;
	}

//	public LinkedHashMap<String, String> getCountryOptions() {
//		return countryOptions;
//	}

}
