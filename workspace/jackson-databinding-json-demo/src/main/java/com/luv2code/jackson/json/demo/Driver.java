package com.luv2code.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {

		try { 
			// create object mapper
			ObjectMapper mapper = new ObjectMapper();
			
			// read JSON file and map/convert to Java POJO: data/sample-lite.json
			Student theStudent = mapper.readValue(new File("data/sample-full.json"), Student.class);
			
			// print first name and last name
			System.out.println("FirstName: " + theStudent.getFirstName());
			System.out.println("LastName: " + theStudent.getLastName());
			System.out.println("Active: " + theStudent.isActive());
			System.out.println("Address: " + theStudent.getAddress());
			for(String lauguage : theStudent.getLanguages()) {
				System.out.println("Language:" + lauguage);
			}
			
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
