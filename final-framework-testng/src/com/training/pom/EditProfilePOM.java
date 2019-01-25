package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditProfilePOM {
private WebDriver driver; 
	
	public EditProfilePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		}
	@FindBy(id="profile_password0")
	private WebElement ExistingProfilepassword;
	
	@FindBy(id="password1")
	private WebElement NewProfilepassword;
	
	@FindBy(id="profile_password2")
	private WebElement confirmProfilepassword;
	
	@FindBy(id="profile_apply_change")
	private WebElement profile_apply_change;
	
	@FindBy(xpath="//div[@class='alert alert-info']")
	private WebElement alertinfoafterUpdate;
	
	
	
	public void sendprofilePassword(String ExistingProfilepassword) {
		this.ExistingProfilepassword.clear();
		this.ExistingProfilepassword.sendKeys(ExistingProfilepassword);
	}
	
	public void sendNewSetPassword(String NewProfilepassword) {
		this.NewProfilepassword.clear();
		this.NewProfilepassword.sendKeys(NewProfilepassword);
	}
	public void sendconfirmSetPassword(String confirmProfilepassword) {
		this.confirmProfilepassword.clear();
		this.confirmProfilepassword.sendKeys(confirmProfilepassword);
	}
	public void clickProfileApplyChangeBtn() {
		this.profile_apply_change.click(); 
	}
	
	public String alertinfoafterUpdate() {
		return this.alertinfoafterUpdate.getText(); //return message as string
		
	}
	
	
	
}
