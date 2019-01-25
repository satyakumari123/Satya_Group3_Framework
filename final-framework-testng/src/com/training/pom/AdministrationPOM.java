package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdministrationPOM {
	
private WebDriver driver; 
	
	public AdministrationPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		}
	@FindBy(xpath="//a[@title='Homepage']")
	private WebElement HomePageAdmin;
	
	@FindBy(xpath="//a[contains(text(),'User list')]")
	private WebElement userListlink;
	
	@FindBy(xpath="//a[@title='Administration']")
	private WebElement AdministrationLabel;
	
	@FindBy(xpath="//a[contains(text(),'Add a user')]")
	private WebElement AddaUserLink;

	public void clickHomepageLink() {
		this.HomePageAdmin.click();
	}
	
	public void clickuserlistLink() {
		this.userListlink.click(); 
	}
	
	public void clickAdministrationLabel() {
		this.AdministrationLabel.click();
	}
	
	public void clickAddaUserLink() {
		this.AddaUserLink.click();
	}

}
