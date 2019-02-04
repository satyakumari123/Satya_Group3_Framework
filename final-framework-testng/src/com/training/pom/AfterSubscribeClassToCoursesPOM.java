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
	
	@FindBy(xpath="//tr[2]//td[3]")// how to find dynamic //no of courses ??
	private WebElement NoOfCourses;

	public String AlertmsgAfterClassToCoursesAdded() {
		return this.AlertmsgAfterClassToCourses.getText();
		
	}
	
	public String NoOfCoursesToClass() {
		return this.NoOfCourses.getText();
		
	}

}
