package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserListsPOM {
private WebDriver driver; 
	
	public UserListsPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		}

	@FindBy(xpath="//a[@href='http://elearning.hommelle.com/main/admin/user_edit.php?user_id=6']//img[@title='Edit']")
	private WebElement EditUserfromediticon;
	
	@FindBy(xpath="//a[@href='http://elearning.hommelle.com/whoisonline.php?origin=user_list&id=6'][contains(text(),'emily')]")
	private WebElement User1stNamefromUserLists;
	
	public void clickEditUserfromEditIcon() {
		this.EditUserfromediticon.click(); 
	}
	
	public String User1stNamefromUserLists() {//return value of 1st name in string from user lists
		return this.User1stNamefromUserLists.getText(); 
	}
	
}
