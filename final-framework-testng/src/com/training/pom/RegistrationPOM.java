package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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
	
	@FindBy(id="registration_language")
	private WebElement registration_language;
	
	@FindBy(xpath="(//input[@name='status'])[2]")//for selecting Teacher radio button
	private WebElement registration_profile;

	@FindBy(id="registration_submit")
	private WebElement registration_submit; 
	
	//Registration error message for wrong username (Expected msg= "Your login can only contain letters, numbers and _.-")
	@FindBy(xpath="//div[@class='alert alert-warning']")
	private WebElement errorMsgforWrongUsername;
	
	//Registration error message for wrong email (Expected msg="The email address is not complete or contains some invalid characters")
	@FindBy(xpath="//div[@class='alert alert-warning']")
	private WebElement errorMsgforWrongemail;
	
	//Registration successful message
	/*Dear xyz abc,

     Your personal settings have been registered.*/
	
	@FindBy(xpath="//div[@class='col-xs-12 col-md-12']//p[1]")
	private WebElement UsersuccessfulSentMsghalf;
	
	@FindBy(xpath="//p[contains(text(),'An email has been sent to help you remember your l')]")
	private WebElement mailSentMsghalf;
	
	@FindBy(xpath="//div[@class='col-xs-12 col-md-12']")
	private WebElement SuccessfulFullMsg;
	
	public void sendregistration_firstname(String registration_firstname) {
		this.registration_firstname.clear();
		this.registration_firstname.sendKeys(registration_firstname);
		}
	public String returnFirstName()//for database assertion
	{
		return this.registration_firstname.getAttribute("value");
	}
	public void sendregistration_lastname(String registration_lastname) {
		this.registration_lastname.clear();
		this.registration_lastname.sendKeys(registration_lastname);
	}
	public String returnLastName()//for database assertion
	{
		return this.registration_lastname.getAttribute("value");
	}
	public void sendRegistration_email(String registration_email) {
		this.registration_email.clear();
		this.registration_email.sendKeys(registration_email);
	}
	public String returneMail()//for database assertion
	{
		return this.registration_email.getAttribute("value");
	}
	public void sendRegistration_official_code(String registration_official_code) {
		this.registration_official_code.clear();
		this.registration_official_code.sendKeys(registration_official_code);
	}
	
	public void senduserName(String username) {
		this.username.clear();
		this.username.sendKeys(username);
	}
	public String returnUserName()//for database assertion
	{
		return this.username.getAttribute("value");
	}
	public void sendPassword(String pass1) {
		this.pass1.clear();
		this.pass1.sendKeys(pass1);
	}
	public String returnPass()//for database assertion
	{
		return this.pass1.getAttribute("value");
	}
	public void sendconfirmPassword(String pass2) {
		this.pass2.clear();
		this.pass2.sendKeys(pass2);
	}
	public String returnConfirmPass()//for database assertion
	{
		return this.pass2.getAttribute("value");
	}
	public void sendregistration_phone(String registration_phone) {
		this.registration_phone.clear();
		this.registration_phone.sendKeys(registration_phone);
	}
	public String returnPhone()//for database assertion
	{
		return this.registration_phone.getAttribute("value");
	}
	public void selectLanguage(String registration_language) {
		Select dropdown = new Select(this.registration_language);
		dropdown.selectByVisibleText(registration_language);
		
}
	public String returnLanguage()//for database assertion
	{  Select dropdown = new Select(this.registration_language);
	//WebElement ele=dropdown.selectByVisibleText(registration_language);
		return this.registration_language.getAttribute("value");
	}
	public void clickTeacherRBtn() {
		registration_profile.click(); //for selecting teacher
	}
	
	public void clickregistration_submitBtn() {
		this.registration_submit.submit(); 
	}
	//Registration Successful msg
	public String DisplayRegistrationMailsentMsgHalf() {
		return this.mailSentMsghalf.getText(); 
	}
	
	public String DisplayRegistrationUsersuccessfulSentMsghalf() {
		return this.UsersuccessfulSentMsghalf.getText();
	}
	
	/*public String DisplayRegistrationSuccessfulFullMsg() {//not usefull as next button content is also covered
		return this.SuccessfulFullMsg.getText(); 
	}*/
	
	//Registration Fail msg
	
		public String DisplayRegistrationErrorMsg() {
			return this.errorMsgforWrongemail.getText();
		}
	
}
