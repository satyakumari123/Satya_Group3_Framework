package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AfterSubscribeClassToCoursesPOM {
	private WebDriver driver;
	public AfterSubscribeClassToCoursesPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		}
	@FindBy(xpath="//div[@class='alert alert-info']")
	private WebElement AlertmsgAfterClassToCourses;
	
	//@FindBy(xpath="//tr[2]//td[3]")
	@FindBy(xpath="//td[@title='1'and @aria-describedby='usergroups_courses']")//// Taken dynamic row then checked no. of courses 
	private WebElement NoOfCourses; //for no of courses

	public String AlertmsgAfterClassToCoursesAdded() {
		return this.AlertmsgAfterClassToCourses.getText();
		
	}
	
	public String NoOfCoursesToClass() {
		return this.NoOfCourses.getText();
		
	}

}
