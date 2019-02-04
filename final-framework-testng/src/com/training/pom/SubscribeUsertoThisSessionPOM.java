package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubscribeUsertoThisSessionPOM {
	private WebDriver driver;
	public SubscribeUsertoThisSessionPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		}
	@FindBy(xpath="//h3[@class='page-header']")
	private WebElement Subscribeusersessionmsg;
	
	@FindBy(xpath="//td[@class='title']")
	private WebElement Courselisttitle;
	
	
	public String SubscribeuserssessionmsgLabel() {
		//this.add_session_name.clear();
		 return this.Subscribeusersessionmsg.getText();
		//System.out.println(this.Subscribeusersmsg.getText());
	}
	
	
	public String Courselisttitle() {
		return this.Courselisttitle.getText();
	}
}
