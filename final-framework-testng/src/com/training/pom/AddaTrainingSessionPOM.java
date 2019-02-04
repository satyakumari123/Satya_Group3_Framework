package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddaTrainingSessionPOM {
	private WebDriver driver;
	public String fullsessionname,sessionname;//to display full session name>>>>>>>>>>>>>>
	public AddaTrainingSessionPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(xpath="//li[contains(text(),'Add a training session')]")
	private WebElement Addatrainingsession;
	
	@FindBy(id="add_session_name")
	private WebElement add_session_name;
	
	@FindBy(id="add_session_submit")
	private WebElement add_session_submit;
	
	//@FindBy(xpath="//legend[contains(text(),'Add courses to this session (selenium trainmming 1')]")
	//need to check dynamic path for full name???
	
	@FindBy(xpath="//li[contains(text(),'Add courses to this session')]")
	private WebElement add_CoursestoThisSession;
	
	public String ViewAddatrainingsessionLabel() {
		return this.Addatrainingsession.getText(); 
	}
	public void sendadd_session_name(String add_session_name) {
		this.add_session_name.clear();
		this.add_session_name.sendKeys(add_session_name);
		sessionname=this.add_session_name.getAttribute("value");//get session name value for display what added >>>
	}
	
	public void clicksession_submitBtn() {
		this.add_session_submit.click(); 
	}
	
	public String Displayadd_CoursestoThisSessionLabel() {
		//return this.add_CoursestoThisSession.getText();
		
		String first="//legend[contains(text(),'Add courses to this session (";
		String last=")')]";
		fullsessionname=first+sessionname+last;
		driver.findElement(By.xpath(fullsessionname)).getText();
		return driver.findElement(By.xpath(fullsessionname)).getText();
		
	}
}
