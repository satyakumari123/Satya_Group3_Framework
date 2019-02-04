package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCategoryPOM {
	private WebDriver driver;
	public String before,after,Totalname,categoryname;//made local variable as static
	public AddCategoryPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		}
	@FindBy(xpath="//img[@title='Add category']")
	//img[@title='Add category']
	private WebElement AddCategoryimg;
	
	@FindBy(id="course_category_code")
	private WebElement course_category_code;
	
	@FindBy(id="course_category_name")
	private WebElement course_category_name;
	
	@FindBy(xpath="(//input[@name='auth_course_child'])[1]")
	private WebElement radioyes;
	
	@FindBy(id="course_category_submit")
	private WebElement course_category_submit;
	
	
	
	@FindBy(xpath="//a[@href='index.php?']")
	private WebElement AdministrationLink;
	
	public void AddCategoryimgclick() {
		this.AddCategoryimg.click();
	}
	
	public void sendcourse_category_code(String course_category_code) {
		this.course_category_code.clear();
		this.course_category_code.sendKeys(course_category_code);
	}
	
	public void sendcourse_category_name(String course_category_name) {
		this.course_category_name.clear();
		this.course_category_name.sendKeys(course_category_name);
		categoryname=this.course_category_name.getAttribute("value");
		
		//String categoryname=driver.findElement(By.xpath(course_category_name)).getAttribute("value");
		//->u need to take By.id if u have inspected element with id then it will work
	System.out.println("categoryname:"+categoryname);
	}
	public void addingcoursesinthiscategoryradioBtn() {
		this.radioyes.click();
		}
	public void course_category_submitBtn() {
		this.course_category_submit.submit();
		
	}
	
public String NemeofAddedCategoryDisplayed() {// check class name added in list
		
	//a[contains(text(),'xyz test')]
		before="//a[contains(text(),'";
		after="')]";
		Totalname=before+this.categoryname+after; //-----------------
		
		System.out.println(Totalname);
		return this.driver.findElement(By.xpath(Totalname)).getText();
		
	}
	
	public void AdministrationLinkClick() {
		this.AdministrationLink.click();
		
	}

}
