package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CourseHomePageInsidePOM {
	private WebDriver driver;
	public String Start,End,Total,Categoryename;
	public CourseHomePageInsidePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		}
	
	//Authoring content
	
	@FindBy(id="istooldesc_667")//Assessment link
	private WebElement AssessmentLink;
	
	
	
	public void clickAssessmentLink() {
		this.AssessmentLink.click();
		
	}
	
	//Test link
	@FindBy(id="istooldesc_657")
	private WebElement TestsLink;
	
	public void clickTestsLink() {
		this.TestsLink.click();
		
	}
	

}
