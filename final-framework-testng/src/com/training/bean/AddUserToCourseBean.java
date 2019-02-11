package com.training.bean;

public class AddUserToCourseBean {
	private String FirstName;
	public AddUserToCourseBean(){
	}
	public AddUserToCourseBean(String FirstName) {
		super();
		this.FirstName = FirstName;
		}
	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String FirstName) {
		this.FirstName = FirstName;
	}
	public String toString() {
		return "RegistrationBean [FirstName=" + FirstName + "]";
	}

}
