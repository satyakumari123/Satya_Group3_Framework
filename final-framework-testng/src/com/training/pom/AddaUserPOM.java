package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddaUserPOM {
	private WebDriver driver;
	public AddaUserPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		}
	@FindBy(id="firstname")
	private WebElement firstname;
	@FindBy(id="lastname")
	private WebElement lastname;
	@FindBy(id="official_code")
	private WebElement official_code;
    @FindBy(id="email")
	private WebElement email;
    @FindBy(id="phone")
	private WebElement phone;
	@FindBy(id="username")
	private WebElement username;

	@FindBy(xpath="(//input[@name='password[password_auto]'])[2]")
	private WebElement password_selectRadio;

	@FindBy(id="password")
	private WebElement password;
	
    //@FindBy(xpath="(//span[@class='filter-option pull-left'])[1]")
	/*@FindBy(xpath="//*[contains(text(),'Learner')]")// shortcut done for xpath as for full content it was not working
	private WebElement profileOptionsFrom;// drop down box value*/
	
	@FindBy(id="status_select")
	private WebElement statusSelect;
	/*
	@FindBy(xpath="//*[contains(text(),'Trainer')]")
	private WebElement profileOptionsTo; */
	
	
	@FindBy(xpath="//button[@name='submit']")
	private WebElement submitBtn;
	
	@FindBy(xpath="//div[@class='alert alert-info']")
	private WebElement InfoAfterSubmit;
	
	@FindBy(id="search_simple_keyword")
	private WebElement SearchTextBox;
	
	@FindBy(id="search_simple_submit")
	private WebElement searchsubmitBtn;
	
	@FindBy(xpath="//td[contains(text(),'efghij')]")
	private WebElement searchResultDisplay;
	
	//other way //-//tr[3]//td[3]
	//for same value //tr[2]//td[6]
	
	public void sendUserfirstname(String firstname) {
		this.firstname.clear();
		this.firstname.sendKeys(firstname);
	}
	public void sendUserlastname(String lastname) {
		this.lastname.clear();
		this.lastname.sendKeys(lastname);
	}
	public void sendUseremail(String email) {
		this.email.clear();
		this.email.sendKeys(email);
	}
	public void sendUserphoneNo(String phone) {
		this.phone.clear();
		this.phone.sendKeys(phone);
	}
	
	public void sendUserName(String username) {
		this.username.clear();
		this.username.sendKeys(username);
	}
	
	public void sendUserPassword(String password) {
		this.password.clear();
		this.password.sendKeys(password);
	}
	/*public void profileOptionsDropdownFrom() {//we can not use select as this is span so use mouse action
		this.profileOptionsFrom.click();;
		}*/
	public void selectProfile(String statusSelect)
	 {
	 Select selectDropdown= new Select(this.statusSelect);
	 selectDropdown.selectByVisibleText(statusSelect);
	 }
	/*
	public void profileOptionsDropdownTo() {//we can not use select as this is span so use mouse action
		this.profileOptionsTo.click();;
		}*/
	
	public void clickAddUser_submitBtn() {
		this.submitBtn.submit(); 
	}
	public String ViewInfoAfterSubLabel() {
		return this.InfoAfterSubmit.getText(); 
	}
	
	public void sendSearchTextBox(String SearchTextBox) {
		this.SearchTextBox.clear();
		this.SearchTextBox.sendKeys(SearchTextBox);
	}
	public void clicksearchBtn() {
		this.searchsubmitBtn.click();
	}
	public String sendSearchTextBox() {
		return this.searchResultDisplay.getText();
		
	}
	
	
	 
	 
	 
	 
	
}
