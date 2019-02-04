package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StudentMyCoursesHomePagePOM {
	private WebDriver driver;
	public StudentMyCoursesHomePagePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(xpath="//a[contains(text(),'Course catalog')]")
	private WebElement Coursecatalog;
	
	public void ClickCoursecatalogLink()
	{
		this.Coursecatalog.click();
	}

}
