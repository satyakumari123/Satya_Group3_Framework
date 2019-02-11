package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AssessmentHomePagePOM {
	//private static final WebElement Activity = null;
	private WebDriver driver;
	public String Start,End,Total,Activitiesname;
	public AssessmentHomePagePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		}
	@FindBy(xpath="//li[contains(text(),'Assessments')]")
	private WebElement DisplayAssessmentHomePage;
	
	@FindBy(xpath="//img[@title='Add online activity']")
	private WebElement AddOnlineImg;
	
	@FindBy(xpath="//li[contains(text(),'Add online activity')]")
	private WebElement AddOnlineActivityHomePage;
	
	@FindBy(xpath="//button[@title='[Choose type of activity to assess]']")//activity type box
	private WebElement ChooseTypeOfActivityToAccess;
	
	@FindBy(xpath="//li[@data-original-index='1']//a[@tabindex='0']")//activity type selection
	private WebElement chooseActivityType;
	
	//@FindBy(xpath="//button[@title='Tests']")
	@FindBy(xpath="//button[@title='Tests']//span[@class='filter-option pull-left'][contains(text(),'Tests')]")
	private WebElement Tests;
	
	@FindBy(xpath="//button[@title='OnlineSeleniumTests']")//On activity select box
	private WebElement OnActivitySelectionBox;
	
	@FindBy(xpath="//span[@class='text'][contains(text(),'OnlineSeleniumTests')]")
	private WebElement Activityname;
	
	@FindBy(xpath="//span[@class='filter-option pull-left'][contains(text(),'OnlineSeleniumTests')]")
	private WebElement Activitydisplayesonbox;
	
	@FindBy(xpath="//input[@id='weight_mask']")
	private WebElement Weight;
	
	@FindBy(xpath="//button[@id='add_link_submit']")
	private WebElement AddLearningActivityBtn;
	
	@FindBy(xpath="//a[@href='gradebook_edit_link.php?editlink=4&cidReq=SELENIUMCOURSESATYA&id_session=0&gidReq=0']//img[@title='Edit']")
	private WebElement editIconofCreatedAssessment;
	
	@FindBy(xpath="//input[@name='visible' ]")
	private WebElement visiblecheckedtextbox;
	
	@FindBy(xpath="//button[@id='edit_link_form_submit']")//edit button inside the edit home page
	private WebElement editButton;
	
	@FindBy(xpath="//img[@title='Attach certificate']")
	private WebElement AttachCertificateIcon;
	
	@FindBy(xpath="//a[contains(text(),'Default certificate')]")
	private WebElement Defaultcertificate;
	
	//From student login
	@FindBy(xpath="//a[contains(text(),'OnlineSeleniumTests')]")//created Selenium test link
	private WebElement OnlineSeleniumTestsLink;
	
	@FindBy(xpath="//a[@class='btn btn-success btn-large']")
	private WebElement StartTest;
	
	//From Question Answer of Test
	@FindBy(xpath="//input[@id='choice-33-4']")
	private WebElement Question1Ans;
	
	@FindBy(xpath="//button[@name='save_now']")  
	private WebElement NextQuestionBtn;
	
	@FindBy(xpath="//input[@id='choice-34-4']")
	private WebElement Question2Ans;
	
	@FindBy(xpath="//input[@id='choice-35-1']")
	private WebElement Question3Ans;
	
	@FindBy(xpath="//h2[@class='page-header']")
	private WebElement TestResultHeader;
	
	@FindBy(xpath="//div[@class='question-result']")
	private WebElement TestResultHeaderfull;
	
	public String DisplayAssessmentHomePage() {
		return this.DisplayAssessmentHomePage.getText();
	}
	
	public void clickOnAddOnlineImg() {
		this.AddOnlineImg.click();
	}
	
	public String DisplayAddOnlineActivityHomePage() {
		return this.AddOnlineActivityHomePage.getText();
	}
	
	public void ChooseTypeOfActivityToAccess() {
		Actions action=new Actions(driver);
    	action.click(this.ChooseTypeOfActivityToAccess).moveToElement(this.chooseActivityType).click().build().perform();
    }
	public String DisplayTestsInChooseActivity() {
		
		return this.Tests.getText();
	}
	public void ChooseActivityToAccess() {
				
		Actions action=new Actions(driver);
    	action.click(this.OnActivitySelectionBox).moveToElement(Activityname).click().build().perform();
    }
	
   public String DisplayActivity() {
		
		return this.Activitydisplayesonbox.getText();
	}
   
   public void sendWeight(String Weight) {
		this.Weight.clear();
		this.Weight.sendKeys(Weight);
	}
   public void clickonAddLearningActivityBtn()
   {
	   this.AddLearningActivityBtn.click();
   }
   
   public void clickoneditIconofCreatedAssessment()
   {
	   this.editIconofCreatedAssessment.click();
   }
   public void clickOnEditButton()
   {
	   this.editButton.click();
   }
   
   public void clickOnAttachCertificateIcon() {
	// TODO Auto-generated method stub
	this.AttachCertificateIcon.click();
   }
   
    public String DisplayDefaultcertificate() {
	// TODO Auto-generated method stub
	return this.Defaultcertificate.getText();
   }
    
    //From Student Login
    public void clickOnlineSeleniumTestsLink() {
    	this.OnlineSeleniumTestsLink.click();
    }
    
    public void clickOnStartTestsBtn() {
    	this.StartTest.click();
    }
    //Clicked on Answers of Test
    public void clickOn1stQuestionAnswer() {
    	this.Question1Ans.click();
    }
    public void clickNextQuestionBtn() {
    	this.NextQuestionBtn.click();
    }
    
    public void clickOn2ndQuestionAnswer() {
    	this.Question2Ans.click();
    }
    public void clickOn3rdQuestionAnswer() {
    	this.Question3Ans.click();
    }
    public String DisplayTestResultHeader() {
    	// TODO Auto-generated method stub
    	return this.TestResultHeader.getText();
       } 
    public String DisplayFullTestResultPage() {
    	// TODO Auto-generated method stub
    	return this.TestResultHeaderfull.getText();
       }

	 
}
