package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddClassesAddDetailsPOM {
	private WebDriver driver;
	public String username;//used string variable>>>>>>>
	
	public AddClassesAddDetailsPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		}
	@FindBy(id="usergroup_name") //enter class name
	private WebElement usergroup_name;
	@FindBy(id="usergroup_description") //for enter description
	private WebElement usergroup_description;
	@FindBy(xpath="//button[@title='Closed']")//Select Textbox of user grp permission
	private WebElement usergroup_Permission;
	/*@FindBy(xpath="//button[@title='Open']")
	private WebElement usergroup_PermissionOpen;*/
	
	
	@FindBy(xpath="//li[@data-original-index='0']//a[@tabindex='0']")//select xpath for open selection in grp permission
	private WebElement usergroup_PermisionOpenindex;
	
	@FindBy(id="usergroup_submit") //submit button to add class
	private WebElement Addusergroup_submit;
	
	//@FindBy(xpath="//td[@title='+returnClassname()+']")
	//private WebElement reachingonSameClass;
	//////////////////////////////////
	////////////////////////////////
	//Question value attribute is not given for class name then why value taken ???
	
	/////////////////////////////////Name of class not displayed
	public void sendusergroup_name(String usergroup_name) {//adding class name
		this.usergroup_name.clear();
		this.usergroup_name.sendKeys(usergroup_name);
		username=this.usergroup_name.getAttribute("value");//String variable used for attribute value >>>>>>>>
		//username=this.usergroup_name.getAttribute("title");
		
	}
	
	public String returnClassname()// return class value
	{
		return this.usergroup_name.getAttribute("value");
	}
	
	public void sendusergroup_description(String usergroup_description) { //add class descirption
		this.usergroup_description.clear();
		this.usergroup_description.sendKeys(usergroup_description);
	}
	public void selectusergroup_Permission() {// select from close to open from grp permission drop down
		//this.usergroup_Permission.clear();
		Actions action=new Actions(driver);
		//action.moveToElement(usergroup_Permission).click().perform();
		action.click(usergroup_Permission).moveToElement(usergroup_PermisionOpenindex).click().build().perform();
		
	}
	
	public void clickusergroup_submitBtn() { //click on submit button to add class
		this.Addusergroup_submit.submit(); 
	}
	
	//======================After Class Added==============================
	//===========================================================================
	//===================POM for after class has added==================
	
	
	@FindBy(xpath="//div[@class='alert alert-success']")// for class added msg displayed on screen
	private WebElement AlertmsgAfterclassAdded;
	
	@FindBy(xpath="//tr[2]//td[1]")//for 1st class name 
	private WebElement ClassName;
	//tr[2]//td[1]
	
	
	
	
	//td[@title='demo1']
	
	/*@FindBy(xpath=xpat)
	private WebElement ClassDemo;	*/
	
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
	public String NemeofAddedClassDisplayed() {// check class name added in list
		
		//td[@title='ok']
		String before="//td[@title='";
		String after="']";
		String pat=before+this.username+after; //-----------------
		//return this.ClassName.getText();
		return this.driver.findElement(By.xpath(pat)).getText();
		
	}
	
	/*public String NemeofAddedClassDemo2Displayed(String test) {
		//return driver.findElement(By.xpath("//td[@title='+test+']")).getText();
		return this.ClassDemo2.getText();
		
	} */
	
	
	//td[@title='demo1']//following-sibling::td[@aria-describedby='usergroups_actions']//child::img[@title='Subscribe users to class']
	
	
	public void clickSubscribeuserstoclassBtn() { //image1 click subscribe user to class
	
		String before="//td[@title='";
		String after="']//following-sibling::td[@aria-describedby='usergroups_actions']//child::img[@title='Subscribe users to class']";
		String pat=before+username+after;//-----------------------------------------
		System.out.println(pat);
		driver.findElement(By.xpath(pat)).click();
		//this.Subscribeuserstoclass.click();
		
	}
	public void clickSubscribeclasstocoursesBtn() { //image2 click subscribe class to course
		String before="//td[@title='";
		String after="']//following-sibling::td[@aria-describedby='usergroups_actions']//child::img[@title='Subscribe class to courses']";
		String pat=before+username+after;//------------------------------------------
		System.out.println(pat);
		driver.findElement(By.xpath(pat)).click();
		//this.Subscribeclasstocourses.click();
		
	}
	public void clickSubscribeclasstosessionsBtn() { //image3 click subscribe class to session
		 this.Subscribeclasstosessions.click();
		
	}

	public void clickTitleEditBtn() { //image 4 to edit action
		 this.titleEdit.click();
		
	}
	public void click1stRowDeleteBtn() { //image 5 to delete
		 //this.titleDelete.click();
		String before="//td[@title='";
		String after="']//following-sibling::td[@aria-describedby='usergroups_actions']//child::img[@title='Delete']";
		String pat=before+username+after;//---------------------------------------------
		driver.findElement(By.xpath(pat)).click();

	}

	
	

	
}
