package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElearningHomePOM {
private WebDriver driver; 
	
	public ElearningHomePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		
		
			}
	
	@FindBy(xpath="//span[@class='caret']")
	private WebElement Dropdown; //on elearning home page right drop down
	
	@FindBy(xpath="//a[@title='Inbox']")
	private WebElement InboxD; //on drop down
	@FindBy(xpath="//a[@title='My certificates']")
	private WebElement MycertificateD; //on drop down
	@FindBy(xpath="//a[@id='logout_button']")
	private WebElement logoutD; //on drop down
	
	@FindBy(xpath="//a[contains(text(),'Edit profile')]")
	private WebElement editProfile; //on drop down
	
	
	public void ElearningHDropdownClick() {
		this.Dropdown.click();
			}
	public void clicklogoutDBtn() {
		this.logoutD.click(); 
	}
	public void clickeditProfileLink() {
		this.editProfile.click(); 
	}
	
	
	}
