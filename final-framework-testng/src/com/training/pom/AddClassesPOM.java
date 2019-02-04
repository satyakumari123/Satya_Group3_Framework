package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddClassesPOM {
	private WebDriver driver;
	public AddClassesPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		}
	@FindBy(xpath="//img[@title='Back to Administration']")
	private WebElement BacktoAdministration;
	
	@FindBy(xpath="//img[@title='Add classes']")
	private WebElement AddClasses;
	
	@FindBy(xpath="//img[@title='Import']")
	private WebElement Import;

	@FindBy(xpath="//img[@title='Export']")
	private WebElement Export;
	
	public void clickBacktoAdministrationBtn() {
		this.BacktoAdministration.click();
	}
	
	public void clickAddClassesBtn() {
		this.AddClasses.click();
	}
	public void clickImportBtn() {
		this.Import.click();
	}
	public void clickExportBtn() {
		this.Export.click();
	}
}
