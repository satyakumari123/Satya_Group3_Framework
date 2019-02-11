package com.training.pom;

import org.openqa.selenium.Alert;
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
	@FindBy(xpath="//a[@title='Administration']")
	private WebElement AdministrationLabel;
	
	//Users 
	@FindBy(xpath="//a[contains(text(),'User list')]")
	private WebElement userListlink;
	@FindBy(xpath="//input[@id='search_simple_keyword']")//search text box
	private WebElement searchTextBox;
	
	@FindBy(xpath="//button[@id='search_simple_submit']")//search Button
	private WebElement searchButton;
	
	@FindBy(xpath="//img[@title='Delete']")
	private WebElement DeleteIcon;
	
	@FindBy(xpath="//a[contains(text(),'Add a user')]")
	private WebElement AddaUserLink;
	
	@FindBy(xpath="//a[contains(text(),'Classes')]")
	private WebElement ClassesLink;
	
	// Under Courses Session
	@FindBy(xpath="//a[contains(text(),'Add a training session')]")
	private WebElement Trainingsession;

	// under courses 
	@FindBy(xpath="//a[contains(text(),'Courses categories')]")
	private WebElement coursecategorylink;
	
	
	
	//courses section 
	@FindBy(xpath="//a[contains(text(),'Create a course')]")
	private WebElement createacourselink;
	
	@FindBy(xpath="//a[contains(text(),'Add users to course')]")
	private WebElement AddusrsTocourselink;
	
	@FindBy(xpath="//a[contains(text(),'Course list')]")
	private WebElement Course_listlink;

	

	public void clickHomepageLink() {
		this.HomePageAdmin.click();
	}
	
	public void clickAdministrationLabel() {
		this.AdministrationLabel.click();
	}
	//Under Users Section
	public void clickuserlistLink() { // click user list link
		this.userListlink.click();
	}
	public void SendNameTosearchTextBox(String searchTextBox) { // search name of user
		this.searchTextBox.clear();
		this.searchTextBox.sendKeys(searchTextBox);
	}
	public void clicksearchButton() { //click on search button
		this.searchButton.click();
	}
	public void clickDeleteIcon() { //click on DeleteIcon
		this.DeleteIcon.click();
		Alert a=driver.switchTo().alert();
		a.accept();
		System.out.println("Deleted Class successfully"); 

	}
	
	public void clickAddaUserLink() { //click Add a user link
		this.AddaUserLink.click();
	}
	
	public void clickClassesLink() { //click classes link
		this.ClassesLink.click();
	}
	
	//Under Courses Session
	public void clickAddTrainingsession() {
		this.Trainingsession.click();
	}
	
	//under courses
	public void clickCoursescategoriesLink() {
		this.coursecategorylink.click();
	}
	
	public void clickcreateaCoursesLink() {
		this.createacourselink.click();
	}
	public void clickAddUsersToCoursesLink() {
		this.AddusrsTocourselink.click();
	}
	public void clickCoursesListLink() {
		this.Course_listlink.click();
	}


}
