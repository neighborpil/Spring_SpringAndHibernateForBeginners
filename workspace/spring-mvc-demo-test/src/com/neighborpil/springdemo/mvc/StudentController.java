package com.neighborpil.springdemo.mvc;

import java.util.HashMap;
import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Value("#{countryOptions}")
	private LinkedHashMap<String, String> theCountryOptions;
	
	@Value("#{favoriteLanguageOptions}")
	private HashMap<String, String> favoriteLanguageOptions;
	
	@RequestMapping("/showForm")
	public String showForm(Model model) {

		var student = new Student();
		
		model.addAttribute("student", student);
		
		model.addAttribute("countryOptions", theCountryOptions);
		
		model.addAttribute("favoriteLanguageOptions", favoriteLanguageOptions);
		
		return "student-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student theStudent) {

		System.out.println("theStudent" + theStudent.getFirstName() + " " + theStudent.getLastName());
		
		return "student-confirmation";
	}
}
