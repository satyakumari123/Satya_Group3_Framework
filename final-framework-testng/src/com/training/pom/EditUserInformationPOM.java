package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditUserInformationPOM {
	
private WebDriver driver; 
	
	public EditUserInformationPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		}
	@FindBy(id="user_edit_firstname")
	private WebElement user_edit_firstname;
	
	@FindBy(id="user_edit_lastname")
	private WebElement user_edit_lastname;
	
	public String getuser_edit_firstname() {
		return this.user_edit_firstname.getAttribute("value"); 
	}
	
	public String getuser_edit_lastname() {
		return this.user_edit_lastname.getAttribute("value"); 
	}

	

}
