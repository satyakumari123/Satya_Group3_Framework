package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoursesCatalogPOM {
	private WebDriver driver;
	public CoursesCatalogPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		}
	@FindBy(xpath="//input[@name='search_term']")
	private WebElement search_term;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement Searchsubmit_button;

	
	@FindBy(xpath="//a[@title='Subscribe']")//click on subscribe button
	private WebElement Subscribe_button;
	
	@FindBy(xpath="//div[@class='alert alert-info']")// for subscribe msg displayed on screen after click on subscribe
	private WebElement Subscribe_alertmsg;
	
	@FindBy(xpath="//section[@id='content-section']")// for finding the whole page content same project what was subscribed
	private WebElement PageContent;
	
	@FindBy(id="register")// for finding  project already subscribed
	private WebElement AlreadySubscribed;
	
	
		
	@FindBy(xpath="//a[@title='SeleniumCourseSatya']")// click on same project link what was subscribed // Always we have to change this path ????
	private WebElement ClickSubscribed_ProjectLink;
	
	@FindBy(xpath="//a[contains(text(),'SeleniumCourseSatya')]")// After click on project link on project home page //// Always we have to change this path ??
	private WebElement On_ProjectAfterclickedOnProjectLink;
	
	
	
	
	
	public void sendSearch_item(String search_term) {
		this.search_term.clear();
		this.search_term.sendKeys(search_term);
	}
	
	public void clickSearchsubmit_Btn() {
		this.Searchsubmit_button.click(); 
	}

	public String subscribebuttonavailable()
	{
		return this.Subscribe_button.getAttribute("title");
	}
	public void ClickonSubscribe_Item() {
		this.Subscribe_button.click(); 
	}
	
	public String DisplaySubscribed_alertmsg() {
		return this.Subscribe_alertmsg.getText(); 
		
	}
	
	public String CheckAlreadysubscribedCouse() {
		return this.AlreadySubscribed.getAttribute("title");
	}
	
	public void ClickonSubscribed_Project_Link() {
		this.ClickSubscribed_ProjectLink.click(); 
	}

	public String DisplayProjectNameAfterClickedonProjectLink() {
		return this.On_ProjectAfterclickedOnProjectLink.getText(); 
	}
	
	
	
}
