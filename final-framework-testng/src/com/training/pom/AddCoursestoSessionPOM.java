package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCoursestoSessionPOM {
	private WebDriver driver;
	public AddCoursestoSessionPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		}
	@FindBy(xpath="(//select[@id='origin'])")
	private WebElement statusSelect;

	@FindBy(xpath="//button[@name='add_course']")
	private WebElement clickbutton;
	
	@FindBy(xpath="//select[@id='destination']")
	private WebElement statusDestinationSelect;
	
	@FindBy(xpath="//button[@name='next']")
	private WebElement nextStepbutton;
	
	
	
	public void Selectcourses(String statusSelect) {
		// return this.statusSelect;
		Select selectContentent=new Select(this.statusSelect);
		selectContentent.selectByVisibleText(statusSelect);
		
	}
	
	public String testSlectedCoursebackgroundcolorinCourseList()
	{
		String color = statusSelect.getCssValue("color");
		return statusSelect.getCssValue("color");
			   }
	
	public void clickbuttonBtn() {
		this.clickbutton.click();
	}
	public String showSelectcoursesinSession() {
		// return this.statusSelect;
		Select selectDestiContentent=new Select(this.statusDestinationSelect);
		selectDestiContentent.selectByValue("4");
		 return this.statusDestinationSelect.getText();
		//selectDestiContentent.getAllSelectedOptions();
		}
	public String testShowSlectedCourseDestinbackgroundcolorinCourseSession()
	{
		String color = statusDestinationSelect.getCssValue("color");
		return statusDestinationSelect.getCssValue("color");
			   }
	
	public void clicknextStepbuttonBtn() {
		this.nextStepbutton.click();
	}

}
