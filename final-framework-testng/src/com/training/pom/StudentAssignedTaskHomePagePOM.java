package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StudentAssignedTaskHomePagePOM {
	private WebDriver driver;
	public String commentvalue,start,end,Totalcomment;
	public StudentAssignedTaskHomePagePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		}
	
	
	//After clicked on Assigned TaskLink
	@FindBy(xpath="//h1[@title='Task2_Testing']")
	private WebElement Task2_Testing;
	
	
	@FindBy(xpath="//input[@id='add_post_title']")
	private WebElement TitlebyStudent;
	
	//@FindBy(xpath="//div[@id='cke_1_contents']")
	
	
	@FindBy(xpath="//iframe[@title='Rich Text Editor, comment']")
	private WebElement CommentContentByStudent;    //comment by student in rich textbox
	
	@FindBy(xpath="//@FindBy(id=\"cke_1_contents\")")
	private WebElement editableRichtextbox;
	
	@FindBy(xpath="//textarea[@id='add_post_post_file_comment']")
	private WebElement PostfileCommentbyStudent;
	
	
	@FindBy(id="add_post_save")      //save button
	private WebElement SavePostByStudent;
	
	@FindBy(xpath="//p[contains(text(),'')]")
	private WebElement studentComment;
	//p[contains(text(),'cooment from student for test...')]
	
	
	public String DisplayAssignedTaskDetailsPage() {
		return this.Task2_Testing.getText();
	}
	
	public void sendTitlebyStudent(String TitlebyStudent) {
		this.TitlebyStudent.clear();
		this.TitlebyStudent.sendKeys(TitlebyStudent);
	}
	/////////
	///////
	
	////why here getAttribute value is not working as it is working on Add classes Add details for TC-50 
	 /////////////////////////
	 ///////////////////////
	public void sendCommentContentByStudent(String editableRichtextbox) {
		driver.switchTo().frame(CommentContentByStudent);
		//WebElement editableRichtextbox = driver.switchTo().activeElement();
		 this.editableRichtextbox = driver.switchTo().activeElement();
		 this.editableRichtextbox.sendKeys(editableRichtextbox);
		 
		 commentvalue=this.editableRichtextbox.getText();//getting value of rich textcomment box
		 //Sir used getAttribute("value") but here it is not working ???
		 //System.out.println("Richtextbox comment:"+commentvalue);
		      driver.switchTo().defaultContent();
		
	}
	
	public void sendPostFileCommentByStudent(String PostfileCommentbyStudent) {
		this.PostfileCommentbyStudent.sendKeys(Keys.ENTER);
		this.PostfileCommentbyStudent.clear();
		this.PostfileCommentbyStudent.sendKeys(PostfileCommentbyStudent);
	}

	
	public void clickSavePostByStudentBtn() {
		this.SavePostByStudent.click(); 
	}
	
	public String DisplayCommentsonAssignedTaskDetailsPage() {
		//return this.Task2_Testing.getText();
		//p[contains(text(),'cooment from student for test...')]
		start="//p[contains(text(),'";
		end="')]";
		Totalcomment=start+commentvalue+end;
		return this.driver.findElement(By.xpath(Totalcomment)).getText();
		
		
	}

}
