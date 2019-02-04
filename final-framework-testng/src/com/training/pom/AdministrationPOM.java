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
	
	//Users 
	
	@FindBy(xpath="//a[contains(text(),'Add a user')]")
	private WebElement AddaUserLink;
	
	@FindBy(xpath="//a[contains(text(),'Classes')]")
	private WebElement ClassesLink;
	
	
	
	//Under Courses Session
	@FindBy(xpath="//a[contains(text(),'Add a training session')]")
	private WebElement Trainingsession;

	// under courses 
	@FindBy(xpath="//a[contains(text(),'Courses categories')]")
	private WebElement coursecategorylink;
	
	
	@FindBy(xpath="//a[contains(text(),'Create a course')]")
	private WebElement createacourselink;
	
	@FindBy(xpath="//a[contains(text(),'Add users to course')]")
	private WebElement AddusrsTocourselink;
	
	@FindBy(xpath="//a[contains(text(),'Course list')]")
	private WebElement Course_listlink;

	

	public void clickHomepageLink() {
		this.HomePageAdmin.click();
	}
	
	public void clickuserlistLink() {
		this.userListlink.click(); 
	}
	
	public void clickAdministrationLabel() {
		this.AdministrationLabel.click();
	}
	//Under Users Section
	
	public void clickAddaUserLink() {
		this.AddaUserLink.click();
	}
	
	public void clickClassesLink() {
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
