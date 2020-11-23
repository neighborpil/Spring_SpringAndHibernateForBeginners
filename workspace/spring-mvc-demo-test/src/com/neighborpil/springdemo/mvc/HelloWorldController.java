package com.neighborpil.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("hello")
public class HelloWorldController {

	@RequestMapping("showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	@RequestMapping("processForm")
	public String processForm(HttpServletRequest request, Model model) {
		
		var theName = request.getParameter("studentName");
		
		var message = "Hey! " + theName.toUpperCase();
		
		model.addAttribute("message", message);
		
		return "helloworld";
	}
	

	@RequestMapping("/processFormTwo")
	public String processFormTwo(@RequestParam("studentName") String theName, Model model) {
		
		var message = "Hell Yea! " + theName.toUpperCase();
		
		model.addAttribute("messaeg", message);
		
		return "helloworld";
	}
}
