package com.training.functional.tests;

import org.testng.annotations.Test;

/* Author : Satya Kumari
 * TC ID  : ELTC_046
 * TC Description :To verify whether application allows student to comment on the task assigned in the project
 * Pre-condition : 1. User should have launched the application

                   2. User should get logged in as student

                   3. Teacher should have created project, assigned the role to student & assigned the task
 */

import com.training.generics.ScreenShot;
import com.training.pom.CoursesCatalogPOM;
import com.training.pom.LoginPOM;
import com.training.pom.StudentAssignedTaskHomePagePOM;
import com.training.pom.StudentMyCoursesHomePagePOM;
import com.training.pom.StudentProjectCourseProjectHomePagePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class AllowStudentToCommentOnTaskAssigned46Test {
	//private static final boolean WebElement = false;
	private static WebDriver driver;
	private static JavascriptExecutor jse ;
	private static String baseUrl;
	private static LoginPOM loginPOM;
	private static CoursesCatalogPOM coursesCatalogPOM;
	private static Properties properties;
	private static ScreenShot screenShot;
	private static StudentMyCoursesHomePagePOM studentMyCoursesHomePagePOM;
	private static StudentProjectCourseProjectHomePagePOM studentProjectCourseProjectHomePagePOM;
	private static StudentAssignedTaskHomePagePOM studentAssignedTaskHomePagePOM;
	String Actual,Expected;
	
	@Test(priority =0)//Login with Student
	  public void validLoginTest() throws InterruptedException {
		     
			loginPOM.sendUserName("satyaStu5");
			loginPOM.sendPassword("satyaashu5");
			loginPOM.clickLoginBtn();
			}
  @Test(priority=1)//click on Course catalog Step 1 
  public void clickCourseCatalogLink() throws InterruptedException {
	  
	  jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	 // Thread.sleep(3000);
	  studentMyCoursesHomePagePOM.ClickCoursecatalogLink();
	  
	  	  
	  }
  @Test(priority=2,enabled=false)//click on search item step 2 and 3
  public void clickSearchCourseitem() {
	  coursesCatalogPOM.sendSearch_item("SeleniumCourseSatya");
	  coursesCatalogPOM.clickSearchsubmit_Btn();
  }
  
    @Test(priority=5)//search subscribed project and click on project Step 5
    public void clickSearchCourseitemaftersubscribe() throws InterruptedException {
	  coursesCatalogPOM.sendSearch_item("SeleniumCourseSatya");
	  coursesCatalogPOM.clickSearchsubmit_Btn();
	// if(coursesCatalogPOM.CheckAlreadysubscribedCouse()=="Already subscribed")
	// {
	    //jse.executeScript("window.scrollBy(0,200)");//uses code to scroll down
	    jse.executeScript("window.scrollBy(0,300)");
	    Thread.sleep(2000);
		 coursesCatalogPOM.ClickonSubscribed_Project_Link();//Select project which has subscribed and click on project link
	  //}
	 /*else {System.out.println("Subscribed Project is not available check for next :");}*/
	  }
    @Test(priority=6)//On project homepage which has subscribed project Step 5
     public void DisplayProjectNameonProjectHomePage()
     {
	 Actual= coursesCatalogPOM.DisplayProjectNameAfterClickedonProjectLink();
	 Expected= "SeleniumCourseSatya";
	 boolean projectname=Actual.contains(Expected);
	 assertTrue(projectname);
      }
     @Test(priority=7)
      public void ClickonStudentProjectInsideCourse() {// click on project under course 
	   studentProjectCourseProjectHomePagePOM.ClickonStudentProjectUnderCourse();
        }
     @Test(priority=8)
      public void ClickonStudentTaskInsideProject() { //click on mytask under project  Step 6 action
	   studentProjectCourseProjectHomePagePOM.ClickonTaskLinkInsideProject();
       }
     @Test(priority=9,enabled=true)//Display task details Step 6
     public void DisplayTaskBlogonStudentTask() { 
	  Actual=studentProjectCourseProjectHomePagePOM.DisplayTaskBlogsaftercliksonMyTasksTask();
	  Expected="A task for me";
	  boolean Taskblog=Actual.contains(Expected);
	  assertTrue(Taskblog);	
     }

    @Test(priority=10) //click on homeimage on taskblog page //step 7 action
    public void ClickHomeImageTaskBlog() {
    studentProjectCourseProjectHomePagePOM.ClickonHomeImageTaskBlog();
    }
    @Test(priority=11)//check project name Step 7 display
    public void ProjectHomePage() {
	Actual=studentProjectCourseProjectHomePagePOM.DisplayProjetNameafterclickonHomeImage();
	Expected="SeleniumProjectSatya";
	boolean Projecttitle=Actual.contains(Expected);
	assertTrue(Projecttitle);
    }
    @Test(priority=12) //clicked on assigned task link
    public void clickOnAssignedTask() {
	studentProjectCourseProjectHomePagePOM.ClickonAssignedTaskLink();
    }
    
    @Test(priority=13)//validating task details page step 8
    public void DisplayAssignedTaskDetailsPage() {
    Actual=studentAssignedTaskHomePagePOM.DisplayAssignedTaskDetailsPage();
 	   Expected="Task2_Testing";
 	   boolean taskdetailspage=Actual.contains(Expected);
 	   assertTrue(taskdetailspage);
    }
   @Test(priority=14)
   public void TaskPerformedNSubmitByStudent() throws InterruptedException {
	   
	   studentAssignedTaskHomePagePOM.sendTitlebyStudent("TestedBySatya2");
	   //Thread.sleep(4000);
	  
	   studentAssignedTaskHomePagePOM.sendCommentContentByStudent("Comment from student in rich text");
	  // Thread.sleep(4000);
	   studentAssignedTaskHomePagePOM.sendPostFileCommentByStudent("Entered post file comment");
	   studentAssignedTaskHomePagePOM.clickSavePostByStudentBtn();
	   
   }
   @Test(priority=15)
   
   public void AddedcommentDisplayed() {//validate comment added
	   studentProjectCourseProjectHomePagePOM.DisplayAddedComentinTaskHomepage();
	   Actual=studentProjectCourseProjectHomePagePOM.DisplayAddedComentinTaskHomepage();
	   Expected="You comment has been added";
	   boolean commentAdded=Actual.contains(Expected);
	   assertTrue(commentAdded);
	   
   } 
   
   @Test(priority=16,enabled=true) //clicked on assigned task link after commented 
   public void DisplayCommentonAssignedTaskafterAddedComment() {
	//studentProjectCourseProjectHomePagePOM.ClickonAssignedTaskLink();
	   
	  Actual= studentAssignedTaskHomePagePOM.DisplayCommentsonAssignedTaskDetailsPage();
	  Expected="Comment from student in rich text"; //Every time change if u have changed comment
	  assertEquals(Actual,Expected);
	
   }
   
   
  @BeforeClass
  public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 jse =((JavascriptExecutor) driver);
		loginPOM = new LoginPOM(driver); 
		studentMyCoursesHomePagePOM=new StudentMyCoursesHomePagePOM(driver);
		coursesCatalogPOM=new CoursesCatalogPOM(driver);
		coursesCatalogPOM=new CoursesCatalogPOM(driver);
		studentProjectCourseProjectHomePagePOM=new StudentProjectCourseProjectHomePagePOM(driver);
		studentAssignedTaskHomePagePOM=new StudentAssignedTaskHomePagePOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
  @AfterClass
  public void tearDown() throws Exception {
		
		driver.quit();
	}

}
