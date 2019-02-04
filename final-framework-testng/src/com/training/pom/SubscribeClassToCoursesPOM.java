package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SubscribeClassToCoursesPOM {
	private WebDriver driver;
	public SubscribeClassToCoursesPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(xpath="//select[@id='elements_not_in']")//courses on platform(list of courses)
	private WebElement Coursesontheplatform;
	
	@FindBy(xpath="//em[@class='fa fa-arrow-right']")//> button
	private WebElement ArrowBtn;
	
	@FindBy(xpath="//select[@id='elements_in']") //courses in grp
	private WebElement Coursesingroup;
	
	@FindBy(xpath="//button[contains(text(),'Subscribe class to courses')]")//Btn for Subscribe class to courses
	private WebElement SubscribeclasstocoursesBtn;
	
	public void sendCoursesontheplatform(String Coursesontheplatform)
    {
    	Select selectUser=new Select(this.Coursesontheplatform);
    	selectUser.selectByVisibleText(Coursesontheplatform);
    }
	
	public String testCoursesOnPlatformbackgroundcolor()//to check selected courses background color
	{
		String color = Coursesontheplatform.getCssValue("color");
		return Coursesontheplatform.getCssValue("color");
			   }
	
	public void ClickArrowBtn()
    {
    	this.ArrowBtn.click();
    }
	
	public String DisplayCoursesingroup() {
	return this.Coursesingroup.getText();
     }
	
	public void ClickSubscribeclasstocoursesBtnBtn()
    {
    	this.SubscribeclasstocoursesBtn.click();
    }

}
