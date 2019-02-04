package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CourseListPOM {
	private WebDriver driver;
	public CourseListPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		}
	@FindBy(xpath="//input[@id='course-search-keyword']")
	private WebElement search_courseitem;

	@FindBy(xpath="//button[@id='search_simple_submit']")
	private WebElement search_simple_submitBtn;
	
	//@FindBy(xpath="//a[contains(text(),'Phython')]")
	@FindBy(xpath="//td[@class='title']")
	private WebElement search_itemmatch;

	public void sendsearch_courseitem(String search_courseitem) {
		this.search_courseitem.clear(); 
		this.search_courseitem.sendKeys(search_courseitem); 
	}
	
	public void clicksearch_simple_submitBtn() {
		this.search_simple_submitBtn.click(); 
	}
	
	public String Displaysearch_itemmatch() {
		return this.search_itemmatch.getText(); 
		
	}

}
