package com.neighborpil.springdemo.mvc;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.neighborpil.springdemo.mvc.validator.CourseCode;

public class Customer {

	private String firstName;
	
	@NotNull(message="이(가) 필요합니다.")
	@Size(min=1, message="이(가) 필요합니다.")
	private String lastName;
	
	@NotNull(message="이(가) 필요합니다")
	@Min(value=0, message="0보다 큰 수를 입력해 주세요.")
	@Max(value=10, message="10보다 작은 수를 입력해 주세요.")
	private Integer freePasses;
	
	@NotNull(message="을(를) 입력해 주세요.")
	@Pattern(regexp="^[\\w]{5}", message="5자리의 숫자 또는 문자만 입력해 주세요.")
	private String postalCode;
	
	@CourseCode
	private String courseCode;
	
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
	public Integer getFreePasses() {
		return freePasses;
	}
	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	
}
