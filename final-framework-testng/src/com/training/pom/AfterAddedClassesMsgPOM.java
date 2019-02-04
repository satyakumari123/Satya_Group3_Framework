package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AfterAddedClassesMsgPOM {
	private WebDriver driver;
	public AfterAddedClassesMsgPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		}
	@FindBy(xpath="//div[@class='alert alert-success']")// for class added msg displayed on screen
	private WebElement AlertmsgAfterclassAdded;
	
	@FindBy(xpath="//tr[2]//td[1]")//for 1st class name 
	private WebElement ClassName;
	//tr[2]//td[1]
	
	String before="//td[@title='";
	String after="']";
	/*String xpat=before+add+after;	
	
	@FindBy(xpath="xpat")
	private WebElement ClassDemo;*/
	
	@FindBy(xpath="//img[@title='Subscribe users to class']")//image1 subscribe user to class
	private WebElement Subscribeuserstoclass;

	@FindBy(xpath="//img[@title='Subscribe class to courses']")//image2 subscribe class to course
	private WebElement Subscribeclasstocourses;

	@FindBy(xpath="//img[@title='Subscribe class to sessions']")//image 3 subscribe class to session
	private WebElement Subscribeclasstosessions;
	
	@FindBy(xpath="//img[@title='Edit']") //image 4 to edit 
	private WebElement titleEdit;
	@FindBy(xpath="//img[@title='Delete']")//image 5 to delete
	private WebElement titleDelete;

	
	public String AlertMsgAfterClassessAdded() { // for class added msg displayed on screen
		return this.AlertmsgAfterclassAdded.getText();
		
	}
	//To check 1st row of class name
	public String NemeofAddedClassDisplayed() {// check 1st row for 1st class name
		return this.ClassName.getText();
		
	}
	
	/*public String NemeofAddedClassDemo2Displayed(String test) {
		//return driver.findElement(By.xpath("//td[@title='+test+']")).getText();
		return this.ClassDemo2.getText();
		
	} */
	
	public void clickSubscribeuserstoclassBtn() { //image1 click subscribe user to class
		 this.Subscribeuserstoclass.click();
		
	}
	public void clickSubscribeclasstocoursesBtn() { //image2 click subscribe class to course
		 this.Subscribeclasstocourses.click();
		
	}
	public void clickSubscribeclasstosessionsBtn() { //image3 click subscribe class to session
		 this.Subscribeclasstosessions.click();
		
	}

	public void clickTitleEditBtn() { //image 4 to edit action
		 this.titleEdit.click();
		
	}
	public void click1stRowDeleteBtn() { //image 5 to delete
		 this.titleDelete.click();
		
	}

}
