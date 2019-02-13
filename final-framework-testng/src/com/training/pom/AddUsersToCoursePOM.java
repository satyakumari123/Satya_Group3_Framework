package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddUsersToCoursePOM {
	
	private WebDriver driver;
	public String after,before,totalpath,Stringpath;
	public AddUsersToCoursePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		}
	@FindBy(xpath="//li[contains(text(),'Add users to course')]")
	private WebElement AddUsersToaCourseHomePage;
	
	
	@FindBy(xpath="//select[@name='UserList[]']")
	private WebElement SelectUselist;
	
	@FindBy(xpath="//button[@value='Add to the course(s) >>']")
	private WebElement AddtothecourseS;
	
	@FindBy(xpath="//select[@name='CourseList[]']")
	private WebElement CourseLists;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement AlertMsgAftercourseaddedtoUser;
	
	public String displayAddUsersToaCourseHomePage() {
		return this.AddUsersToaCourseHomePage.getText();
		
	}
	
	public void selectuserfromUserList(String SelectUselist) {//select user
		Select selectuser=new Select(this.SelectUselist);
		selectuser.selectByVisibleText(SelectUselist);	
		
	}
	
	public void selectuserfromUserListforExcel(String lastname) {//select Userlist for excelsheet
		//select user from list for excelsheet
		//*[ contains(text(),'Faculty Santhose')]
		
		//Select selectuser=new Select(this.SelectUselist);
		//selectuser.selectByVisibleText(SelectUselist);
		
		String before="//*[ contains(text(),'";
		String after="')]";
		String totalpath=before+lastname+after;
			
		WebElement ele=driver.findElement(By.xpath(totalpath));
		Select selectuser=new Select(ele);
		selectuser.selectByVisibleText(lastname);
		
		//String Stringpath=driver.findElement(By.xpath(totalpath)).getText();
		
		
		
	}
	public String testUserListbackgroundcolor()
	{
		//String color = driver.findElement(By.id("foo")).getCssValue("color");
		String color = SelectUselist.getCssValue("color");
		return SelectUselist.getCssValue("color");
		//String headercolor = this.SelectUselist.getCssValue("Background color");
				//String headerColor = driver.findElement(By.xpath(".//*[@id='LoginName']/h1")).getCssValue("backgroud-color");
	      //Assert.assertEquals("some message", "#FFFFFF", headerColor);
		//System.out.println("Backgroundcolour"+headercolor);
	   }
	
	public void selectCourseList(String CourseLists) { //select course
		Select selectcourselist=new Select(this.CourseLists);
		selectcourselist.selectByVisibleText(CourseLists);
		
	}
	
	public String testCourseListbackgroundcolor()
	{
		
		String color = CourseLists.getCssValue("color");
		return CourseLists.getCssValue("color");
			   }
	public void clickAddtothecourseBtn() { //add button
		this.AddtothecourseS.click();
	}
	
	public String AlertMsgAftercourseaddedtoUser() {
		return this.AlertMsgAftercourseaddedtoUser.getText();
		
	}

}
