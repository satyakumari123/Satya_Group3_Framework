package com.training.pom;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SubscribeUserPOM {
	private WebDriver driver;
	public SubscribeUserPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(xpath="//legend[contains(text(),'')]")
	private WebElement Subscribeusersmsg;
	@FindBy(id="user_to_add")
	private WebElement user_to_add;
	
	//@FindBy(id="ajax_list_users_single")
	//@FindBy(xpath="//a[contains(text(),'kumar sunil (sunil94)')]")
	@FindBy(xpath="//a[contains(text(),'kumar sunil (sunkum09) SUNKUM09')]")
	private WebElement Portaluserslistnamelink;

	@FindBy(id="destination_users")
	private WebElement destination_users;//for multi values
	
	//@FindBy(xpath="//option[@value='19']")
	
	@FindBy(xpath="//option[@value='24']")
	private WebElement destination1stusers;
	
	@FindBy(xpath="//button[contains(text(),'Finish session creation')]")
	private WebElement Finishsessioncreation;
	
	
		
	public String SubscribeusersmsgLabel() {
		
		return this.Subscribeusersmsg.getText();
		//legend[contains(text(),'Subscribe users to this session (selenium training session34) ')]
	}
	public void sendStudName(String user_to_add) {
		this.user_to_add.clear();
		this.user_to_add.sendKeys(user_to_add);
		}
	
  public String Portaluserslistnamelink() {
		
		return this.Portaluserslistnamelink.getText();
		//System.out.println(this.Subscribeusersmsg.getText());	
	}
  public void PortaluserslistnamelinkClick() {
		this.Portaluserslistnamelink.click();}
  
  public String getTagnameofuserlinkdisplayPortaluserslist() {
	  return Portaluserslistnamelink.getTagName();
  }

public List<WebElement> ajax_listuser_Destination() {
	Select selectuser=new Select(this.destination_users);
	System.out.println(this.destination_users);
	selectuser.getAllSelectedOptions();
	return selectuser.getAllSelectedOptions(); 
	}
  
   public String ajax_listuser1stDestination() {
	  return this.destination1stusers.getText();// On 11 Feb 
	  //return this.Portaluserslistnamelink.getText();
	  }

public void FinishsessioncreationClick() {
	this.Finishsessioncreation.click();}
}
