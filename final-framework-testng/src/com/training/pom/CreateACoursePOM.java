package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateACoursePOM {
	private WebDriver driver;
	public String Start,End,Total,Categoryename;
	public CreateACoursePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		}
	@FindBy(xpath="//li[contains(text(),'Create a course')]")
	private WebElement Create_a_course_title;
	
	@FindBy(id="update_course_title")
	private WebElement update_course_title;
	@FindBy(id="visual_code")
	private WebElement visual_code;
	@FindBy(id="course_teachers") //teachers drop down
	private WebElement course_teachers;
	//private WebElement teachercourselist;
	//@FindBy(id="selectpicker show-tick form-control")//category selection
	@FindBy(xpath="//button[@title='none']")//category selection text box
	private WebElement selectcategorySelection;
	
	@FindBy(xpath="//span[contains(text(),'(BL) Blended Learning')]")//category selection Blended Learning
	private WebElement BlendedLearningSelection;

	
	@FindBy(id="update_course_course_language") //language list
	private WebElement update_course_language;
	
	@FindBy(id="update_course_submit") 
	private WebElement update_course_submit;
	
	public String DisplayCreate_a_course_title_alertmsg() {
		return this.Create_a_course_title.getText(); 
		
	}
	
	public void sendcourseTitle(String update_course_title) {
		this.update_course_title.clear();
		this.update_course_title.sendKeys(update_course_title);
	}
	
	public void sendvisual_code(String visual_code) {
		this.visual_code.clear();
		this.visual_code.sendKeys(visual_code);
	}
	
	public void selectcourse_teachers(String course_teachers) {
		Select dropdown = new Select(this.course_teachers);
		dropdown.deselectAll();
		dropdown.selectByVisibleText(course_teachers);
		//dropdown.selectByIndex(2);
		}
	
    public void selectpicker_show_tick_form_control(String BlendedLearningSelection ) {
    	//Select dropdown1 = new Select(this.selectcategorySelection);
    	//dropdown1.selectByVisibleText(selectcategorySelection);
    	Actions action=new Actions(driver);
    	action.click(this.selectcategorySelection).moveToElement(this.BlendedLearningSelection).click().build().perform();
		}
    
    public void selectCategoryFromList(String BlendedLearningSelection ) {
    	//span[contains(text(),'(BL) Blended Learning')]
    	Start="//span[contains(text(),'";
    	End="')]";
    	Actions action=new Actions(driver);
    	action.click(this.selectcategorySelection).moveToElement(this.BlendedLearningSelection).click().build().perform();
    	
		}
    
    public void update_course_language(String update_course_language) {
    	Select dropdown2 = new Select(this.update_course_language);
    	dropdown2.selectByVisibleText(update_course_language);
		}
    
    public void clickCreateaCourseBtn() {
		this.update_course_submit.submit(); 
	}

}
