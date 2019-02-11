package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestsHomePageInsidePOM {
	private WebDriver driver;
	public TestsHomePageInsidePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		}
	@FindBy(xpath="//a[@class=\"link_tooltip\"]")//Inside test OnlineSeleniumTests link
	private WebElement OnlineSeleniumTestsLink;

	@FindBy(xpath="//tr[@id=\"exercise_list_29\"]//td[@class=\"td_actions\"]//child::a//img[@title=\"Results and feedback\"]")
	private WebElement ResultAndFeedBack;
	
	@FindBy(xpath="//li[contains(text(),'Learner score')]")
	private WebElement LearnerscorePage;
	
	public void ClickTestsLink() {
		this.OnlineSeleniumTestsLink.click();
	}
	
	public void ClickResultAndFeedBackLink() {
		this.ResultAndFeedBack.click();
	}
	
	public String DisplayLearnerscorePage() {
		return this.LearnerscorePage.getText();
	}
	
	
}
