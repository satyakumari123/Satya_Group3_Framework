package com.training.functional.tests;

import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AssessmentHomePagePOM;
import com.training.pom.CourseHomePageInsidePOM;
import com.training.pom.CoursesCatalogPOM;
import com.training.pom.CreateACoursePOM;
import com.training.pom.ElearningHomePOM;
import com.training.pom.LoginPOM;
import com.training.pom.StudentMyCoursesHomePagePOM;
import com.training.pom.StudentProjectCourseProjectHomePagePOM;
import com.training.pom.TestsHomePageInsidePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class TC_79ApplicationAllowsTeachertoAuthorCourseAssignmentsQuizStudentsRegisterCourseCompleteAssignmentsTeacherReviewSendMailTest {
	
	private static WebDriver driver;
	private static JavascriptExecutor jse ;
	private static String baseUrl;
	private static Properties properties;
	private static ScreenShot screenShot;
	private LoginPOM loginPOM;
	private CreateACoursePOM createACoursePOM;
	private CourseHomePageInsidePOM courseHomePageInsidePOM;
	private AssessmentHomePagePOM assessmentHomePagePOM;
	private ElearningHomePOM elearningHomePOM;
	private StudentMyCoursesHomePagePOM studentMyCoursesHomePagePOM;
	private CoursesCatalogPOM coursesCatalogPOM;
	private StudentProjectCourseProjectHomePagePOM studentProjectCourseProjectHomePagePOM;
	private TestsHomePageInsidePOM testsHomePageInsidePOM;
	String Actual;
	String Expected;
	
	@Test (priority=0)
	  public void BrowserLaunchTest() throws IOException {
		    driver = DriverFactory.getDriver(DriverNames.CHROME);
		    baseUrl = properties.getProperty("baseURL");
			screenShot = new ScreenShot(driver); 
			jse =((JavascriptExecutor) driver);
			loginPOM = new LoginPOM(driver); 
			createACoursePOM=new CreateACoursePOM(driver);
			courseHomePageInsidePOM=new CourseHomePageInsidePOM(driver);
			assessmentHomePagePOM=new AssessmentHomePagePOM(driver);
			elearningHomePOM=new ElearningHomePOM(driver);
			studentMyCoursesHomePagePOM=new StudentMyCoursesHomePagePOM(driver);
			coursesCatalogPOM=new CoursesCatalogPOM(driver);
			studentProjectCourseProjectHomePagePOM=new StudentProjectCourseProjectHomePagePOM(driver);
			testsHomePageInsidePOM=new TestsHomePageInsidePOM(driver);
			// open the browser 
			driver.get(baseUrl); 
			}
	
	@Test(priority=1)//Login with Student
	  public void validTeacherLoginTest() throws InterruptedException {
		     
			loginPOM.sendUserName("satyaTec6");//login with teacher
			loginPOM.sendPassword("satyaashu5");
			loginPOM.clickLoginBtn();
			Thread.sleep(3000);
			jse.executeScript("window.scrollBy(0,500)");
			createACoursePOM.ClickonCreatedCoursePage("SeleniumCourseSatya ");//click on existing course having task
			}
	
	  @Test(priority=2,enabled=true)
	  public void clickOnAssessmentLink() {//Click on assessment link
		  jse.executeScript("window.scrollBy(0,500)");
		courseHomePageInsidePOM.clickAssessmentLink();
		Actual=assessmentHomePagePOM.DisplayAssessmentHomePage();
		Expected="Assessments";
		assertEquals(Actual,Expected);
		}
	
	@Test(priority=3,enabled=true)
	public void AssessmentHomePage()
	{
		jse.executeScript("window.scrollBy(0,500)");
		assessmentHomePagePOM.clickOnAddOnlineImg();
		Actual=assessmentHomePagePOM.DisplayAddOnlineActivityHomePage();
		Expected="Add online activity";
		boolean pagecontains=Actual.contains(Expected);
		assertTrue(pagecontains);
	}
	@Test(priority=4,enabled=true)
	public void ChooseTypeOfActivityToAccess() throws InterruptedException {
	    assessmentHomePagePOM.ChooseTypeOfActivityToAccess();
		Thread.sleep(3000);
		assessmentHomePagePOM.DisplayTestsInChooseActivity();
		Actual=assessmentHomePagePOM.DisplayTestsInChooseActivity();
		Expected="Tests";
		assertEquals(Actual,Expected);
	}
	
	@Test(priority=5,enabled=true)
	public void ChooseActivityToAccess() {
		//assessmentHomePagePOM.ChooseActivityToAccess();
		assessmentHomePagePOM.DisplayActivity();
		Actual=assessmentHomePagePOM.DisplayActivity();
		Expected="OnlineSeleniumTests";
		jse.executeScript("window.scrollBy(0,500)");
		assessmentHomePagePOM.sendWeight("10");
		assessmentHomePagePOM.clickonAddLearningActivityBtn();
	}
	@Test(priority=6)
	public void clickOnEditIconofCreatedAssessment() throws InterruptedException {
		assessmentHomePagePOM.clickoneditIconofCreatedAssessment();
		//parent::tbody//img[@title='Edit']
		Thread.sleep(3000);
		assessmentHomePagePOM.clickOnEditButton();
	}
	@Test(priority=7)
	public void clickOnAttachedCertificateIcon()
	{
		assessmentHomePagePOM.clickOnAttachCertificateIcon();
		Actual=assessmentHomePagePOM.DisplayDefaultcertificate();
		Expected="Default certificate";
		assertEquals(Actual,Expected);
	}
	
	@Test(priority=8)
	 public void SignOutFromTeacherTest() throws InterruptedException {//click on right icon for veiw list,inbox,elearning,logout
		  elearningHomePOM.ElearningHDropdownClick();//from teacher login
		 
		  Thread.sleep(3000);
		  elearningHomePOM.clicklogoutDBtn();
		  }
	@Test(priority=9,enabled=true)
	public void StudentLogin() throws InterruptedException {
		loginPOM.sendUserName("satyaStu5");//login with teacher
		loginPOM.sendPassword("satyaashu5");
		loginPOM.clickLoginBtn();
		Thread.sleep(3000);
		}
	@Test(priority=10)//click on Course catalog Step 1 
	  public void clickCourseCatalogLink() throws InterruptedException {
		  
		  jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		  Thread.sleep(3000);
		  studentMyCoursesHomePagePOM.ClickCoursecatalogLink();
		  }
	  @Test(priority=11,enabled=true)//click on search item 
	  //search subscribed project and click on project on row 500
	    public void clickSearchCourseitemaftersubscribe() throws InterruptedException {
		  coursesCatalogPOM.sendSearch_item("SeleniumCourseSatya");
		  coursesCatalogPOM.clickSearchsubmit_Btn();
		  jse.executeScript("window.scrollBy(0,300)");
		  Thread.sleep(2000);
	      coursesCatalogPOM.ClickonSubscribed_Project_Link();//Select project which has subscribed and click on project link
	   }
	  
	  @Test(priority=12)//From student 
	  public void clickOnStudentAssessmentLink() throws InterruptedException {//Click on assessment link
		  jse.executeScript("window.scrollBy(0,500)");
		courseHomePageInsidePOM.clickAssessmentLink();//click on assessment link inside course
		Thread.sleep(2000);
		assessmentHomePagePOM.clickOnlineSeleniumTestsLink(); //click on created test link inside Assessment homepage
		assessmentHomePagePOM.clickOnStartTestsBtn();
		}
	  
	  @Test(priority=13)
	  public void clickonAnswersofTest() throws InterruptedException {
		  assessmentHomePagePOM.clickOn1stQuestionAnswer();
		  assessmentHomePagePOM.clickNextQuestionBtn();
		  Thread.sleep(3000);
		  assessmentHomePagePOM.clickOn2ndQuestionAnswer();
		  assessmentHomePagePOM.clickNextQuestionBtn();
		  Thread.sleep(3000);
		  assessmentHomePagePOM.clickOn3rdQuestionAnswer();
		  assessmentHomePagePOM.clickNextQuestionBtn();
		  Thread.sleep(3000);
	  }
	  
	  @Test(priority=14)
	  public void DisplayStudentTestResult() {
		  Actual=assessmentHomePagePOM.DisplayTestResultHeader();
		  System.out.println("Actual Page"+Actual);
		  Expected="OnlineSeleniumTests : Result";
		  System.out.println("Expected Page"+Expected);
		  boolean ResultPage=Actual.contains(Expected);
		  assertTrue(ResultPage);
		  String StudentResult=assessmentHomePagePOM.DisplayFullTestResultPage();
		  System.out.println("Student Result :"+StudentResult);
	  }
	  
	  @Test(priority=15)
		 public void SignOutFromStudentTest() throws InterruptedException {//click on right icon for veiw list,inbox,elearning,logout
			  elearningHomePOM.ElearningHDropdownClick();//from Student login
			 
			  Thread.sleep(3000);
			  elearningHomePOM.clicklogoutDBtn();
			  }
	  @Test(priority=16)//Login with Student
	  public void CheckTeacherLoginTest() throws InterruptedException {
		    loginPOM.sendUserName("satyaTec6");//login with teacher
			loginPOM.sendPassword("satyaashu5");
			loginPOM.clickLoginBtn();
			Thread.sleep(3000);
			jse.executeScript("window.scrollBy(0,500)");
			createACoursePOM.ClickonCreatedCoursePage("SeleniumCourseSatya ");//click on existing course having task
			courseHomePageInsidePOM.clickTestsLink();	
			testsHomePageInsidePOM.ClickResultAndFeedBackLink();
			testsHomePageInsidePOM.DisplayLearnerscorePage();
			Actual=testsHomePageInsidePOM.DisplayLearnerscorePage();
			Expected="Learner score";
			assertEquals(Actual,Expected);
	  }
	  
	  
	  
  @BeforeClass
  public static void setUpBeforeClass() throws IOException {
	properties = new Properties();
	FileInputStream inStream = new FileInputStream("./resources/others.properties");
	properties.load(inStream);
	
	 }

	
  @AfterClass
  public void tearDown() throws Exception {
		Thread.sleep(3000);
		//driver.quit();
	}

}
