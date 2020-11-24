package com.neighborpil.springdemo.mvc.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

	private String[] coursePrefixes;
	
	@Override
	public void initialize(CourseCode courseCode) {
		
		coursePrefixes = courseCode.value();
	}

	@Override
	public boolean isValid(String code, ConstraintValidatorContext constraintValidatiorContext) {
		
		if(code == null)
			return false;
		
		for(String prefix : coursePrefixes){
			
			if(code.startsWith(prefix))
				return true;
		}
		
		return false;
	}
}
