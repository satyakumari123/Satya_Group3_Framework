package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StudentProjectCourseProjectHomePagePOM {
	private WebDriver driver;
	public StudentProjectCourseProjectHomePagePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		}
	//click on project inside course
	@FindBy(xpath="//img[@id='toolimage_676']")
	private WebElement CoursecatalogProject;
	
	//click on task link inside project
	
	@FindBy(xpath="//a[@title='[Blog: SeleniumProjectSatya] A task for me']")//click on My task in task
	private WebElement AssignedTasklinkinMytask;

	//@FindBy(xpath="//span[@class='blogpost_title']']")//display tasks after clicked My task
	
	@FindBy(xpath="//li[contains(text(),'A task for me')]")
	private WebElement Taskblog;
	
	//Homeimage task blog
	@FindBy(xpath="//img[@title='Home']")
	private WebElement HomeImageTaskBlog;
	
	//After clicked on Homeimage on project task homepage
	
	@FindBy(xpath="//h1[contains(text(),'SeleniumProjectSatya')]")//check project name
	private WebElement ProjectTitleDisplays;
	
	//link of assigned task
	@FindBy(xpath="//a[@title='Task2_Testing']")
	private WebElement AssignedTaskLink1;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement AddedCommentDisplay;	
	
	public void ClickonStudentProjectUnderCourse() //click on project inside course
	{
		this.CoursecatalogProject.click();
	}
	
	public void ClickonTaskLinkInsideProject() //click on task link inside project
	{
		this.AssignedTasklinkinMytask.click();
	}
	public String DisplayTaskBlogsaftercliksonMyTasksTask() //click on task link inside project
	{
		return this.Taskblog.getText();
	}

	public void ClickonHomeImageTaskBlog() //click on Homeimag inside task blog
	{
		this.HomeImageTaskBlog.click();
	}
	
	//On project homepage title display after click on home image of task blog
	public String DisplayProjetNameafterclickonHomeImage() //click on task link inside project
	{
		return this.ProjectTitleDisplays.getText();
	}
	
	//click on assigned task link
	public void ClickonAssignedTaskLink() //click on assigned task 
	{
		this.AssignedTaskLink1.click();
	}
	
	public String DisplayAddedComentinTaskHomepage() //click on task link inside project
	{
		return this.AddedCommentDisplay.getText();
	}
	
}
