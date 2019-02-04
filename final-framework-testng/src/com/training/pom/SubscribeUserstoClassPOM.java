package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SubscribeUserstoClassPOM {
	private WebDriver driver;
	public SubscribeUserstoClassPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		}
	@FindBy(xpath="//li[contains(text(),'Subscribe users to class')]")
	private WebElement SubscribeUserstoclassmsg;
	
	@FindBy(xpath="//select[@id='elements_not_in']")
	private WebElement UsersonPlateform;
	@FindBy(xpath="//em[@class='fa fa-arrow-right']")
	private WebElement ArrowFrdBtn;
	@FindBy(xpath="//select[@id='elements_in']")
	private WebElement Usersingroup;
    @FindBy(xpath="//button[contains(text(),'Subscribe users to class')]")
	private WebElement SubscribeUserstoClassBtn;
    
    @FindBy(xpath="//td[@title='1'and @aria-describedby='usergroups_users']")//for no of users
	private WebElement SubscribeUsersNum;
    

    public String DisplaySubscribeUserstoclassmsg()
    {
    	return this.SubscribeUserstoclassmsg.getText();  
    	}
    
    public void sendUsersonPlateform(String UsersonPlateform)
    {
    	Select selectUser=new Select(this.UsersonPlateform);
    	selectUser.selectByVisibleText(UsersonPlateform);
    }
    public String testUsersonPlateformbackgroundcolor()
	{
		String color = UsersonPlateform.getCssValue("color");
		return UsersonPlateform.getCssValue("color");
			   }
    
    public void clickArrowFrdBtn ()
    {
    	this.ArrowFrdBtn.click();    
    	}
    
    public String selectUsersingroup()
    {
    	return this.Usersingroup.getText();  
    	}
    public void SubscribeUserstoClassBtn()
    {
    	this.SubscribeUserstoClassBtn.click();    
    	}
    public String DisplaySubscribedusernum()
    {
    	return this.SubscribeUsersNum.getText();  
    	}

}
