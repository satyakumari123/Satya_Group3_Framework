package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPOM {
private WebDriver driver; 
	
	public RegistrationPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="registration_firstname")
	private WebElement registration_firstname; 
	
	@FindBy(id="registration_lastname")
	private WebElement registration_lastname;
	
	@FindBy(id="registration_email")
	private WebElement registration_email;
	
	@FindBy(id="registration_official_code")
	private WebElement registration_official_code;
	
	@FindBy(id="username")
	private WebElement username;
	
	@FindBy(id="pass1")
	private WebElement pass1;
	
	@FindBy(id="pass2")
	private WebElement pass2;
	
	@FindBy(id="registration_phone")
	private WebElement registration_phone;

	/*@FindBy(xpath="//input[@id='qf_58822b']")  
	private WebElement Teacher;//select teacher */
	
	@FindBy(xpath="(//input[@name='status'])[2]")
	private WebElement registration_profile;

	@FindBy(id="registration_submit")
	private WebElement registration_submit; 
	
	public void sendregistration_firstname(String registration_firstname) {
		this.registration_firstname.clear();
		this.registration_firstname.sendKeys(registration_firstname);
	}
	public void sendregistration_lastname(String registration_lastname) {
		this.registration_lastname.clear();
		this.registration_lastname.sendKeys(registration_lastname);
	}
	public void sendRegistration_email(String registration_email) {
		this.registration_email.clear();
		this.registration_email.sendKeys(registration_email);
	}
	public void sendRegistration_official_code(String registration_official_code) {
		this.registration_official_code.clear();
		this.registration_official_code.sendKeys(registration_official_code);
	}
	public void senduserName(String username) {
		this.username.clear();
		this.username.sendKeys(username);
	}
	public void sendPassword(String pass1) {
		this.pass1.clear();
		this.pass1.sendKeys(pass1);
	}
	public void sendconfirmPassword(String pass2) {
		this.pass2.clear();
		this.pass2.sendKeys(pass2);
	}
	public void sendregistration_phone(String registration_phone) {
		this.registration_phone.clear();
		this.registration_phone.sendKeys(registration_phone);
	}
	public void clickTeacherRBtn() {
		registration_profile.click(); //for selecting teacher
	}
	
	public void clickregistration_submitBtn() {
		this.registration_submit.submit(); 
	}
	
}
