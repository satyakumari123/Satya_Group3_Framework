package com.training.functional.tests;

import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AddCategoryPOM;
import com.training.pom.AddClassesAddDetailsPOM;
import com.training.pom.AddClassesPOM;
import com.training.pom.AddUsersToCoursePOM;
import com.training.pom.AddaUserPOM;
import com.training.pom.AdministrationPOM;
import com.training.pom.AfterSubscribeClassToCoursesPOM;
import com.training.pom.CreateACoursePOM;
import com.training.pom.LoginPOM;
import com.training.pom.SubscribeClassToCoursesPOM;
import com.training.pom.SubscribeUserstoClassPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class ClassesNewTest {
	private static WebDriver driver;
	private static String baseUrl;
	private static LoginPOM loginPOM;
	private static Properties properties;
	private static ScreenShot screenShot;
	private static AdministrationPOM administrationPOM;
	private static AddClassesPOM addClassesPOM;
	private static AddClassesAddDetailsPOM addClassesAddDetailsPOM;
	//private static AfterAddedClassesMsgPOM afterAddedClassesMsgPOM;
	private static SubscribeUserstoClassPOM subscribeUserstoClassPOM;
	private static SubscribeClassToCoursesPOM subscribeClassToCoursesPOM;
	private static AfterSubscribeClassToCoursesPOM afterSubscribeClassToCoursesPOM;
	String Actual,Expected;
	String Sessionname;
	private String test;
	 @Test(priority=0) //Admin Login
	  public void validLoginTest() throws InterruptedException {
			loginPOM.sendUserName("admin");
			loginPOM.sendPassword("admin@123");
			loginPOM.clickLoginBtn(); 
			screenShot.captureScreenShot("First");	
			administrationPOM.clickClassesLink();
			Thread.sleep(3000);
			addClassesPOM.clickAddClassesBtn();
			Thread.sleep(3000);
		   }
	 @Test(priority=1)//On Add Classess Details screen to add contentent
	  public void AddClassesAddSdetails() throws InterruptedException {
		  addClassesAddDetailsPOM.sendusergroup_name("zemo5");//every time need to change
		  addClassesAddDetailsPOM.sendusergroup_description("demo Class description");
		  addClassesAddDetailsPOM.selectusergroup_Permission();
		  addClassesAddDetailsPOM.clickusergroup_submitBtn();
			Thread.sleep(3000);
     }
	 
	 @Test(priority=2)//Msg displayed on screen (Changes after added classess)
	  public void AfterClassAddedSmsgDisplayed() throws InterruptedException {
		 //how to go on actual class added need to check on page
		  addClassesAddDetailsPOM.AlertMsgAfterClassessAdded();
		  Actual=addClassesAddDetailsPOM.AlertMsgAfterClassessAdded();
		  
		  Expected="Item added";
		  boolean msgdisplayed=Actual.contains(Expected);
		  assertTrue(msgdisplayed);
			}
	 @Test(priority=3)
	 public void checkclassnameaddedinlist() {
		  addClassesAddDetailsPOM.NemeofAddedClassDisplayed();//2nd row 1st colum class name ABC
		  Actual=addClassesAddDetailsPOM.NemeofAddedClassDisplayed();
		  Expected="zemo5";//every time need to change
		  boolean msgdisplayed=Actual.contains(Expected);
		  assertTrue(msgdisplayed);
	 }
	 @Test(priority=4)//Step 8 ////click on Subscribe users to class icon
	  public void ClickonSubscribeBtnForSubscribeUsersToClass() throws InterruptedException {
		  addClassesAddDetailsPOM.clickSubscribeuserstoclassBtn();
		  Actual=subscribeUserstoClassPOM.DisplaySubscribeUserstoclassmsg();
		  Expected="Subscribe users to class";
		  boolean SubscribeusersToclass=Actual.contains(Expected);
		  assertTrue(SubscribeusersToclass);
		  }
	 @Test(priority=5)//step 9 highlighted user
	  public void ClickUsersinPlatformtocheckHighlighted() {
		  subscribeUserstoClassPOM.sendUsersonPlateform("satyaStu1 kumariStu (satyaStu1)  - Student1");//if chnage every time
		  subscribeUserstoClassPOM.testUsersonPlateformbackgroundcolor();
		  System.out.println("Highlighted Username :"+subscribeUserstoClassPOM.testUsersonPlateformbackgroundcolor());
	  }
	 
	 @Test(priority=6)//Step 11 No of users subscribed
	  public void SubscribeUsersToClass() throws InterruptedException {
		  
		  subscribeUserstoClassPOM.clickArrowFrdBtn();
		  subscribeUserstoClassPOM.selectUsersingroup();
		  subscribeUserstoClassPOM.SubscribeUserstoClassBtn();
		  Thread.sleep(3000);
		  Actual=subscribeUserstoClassPOM.DisplaySubscribedusernum();
		  Expected="1";//chnage no every time if no of user chnageds
		  Boolean expectedsubsuser=Actual.contains(Expected);
		  assertTrue(expectedsubsuser);
		  addClassesAddDetailsPOM.clickSubscribeclasstocoursesBtn();

		  }
	 @Test(priority=7)
	  public void AfterSubscribeClassToCourses() throws InterruptedException {//After subscribe course msg on screen
		  afterSubscribeClassToCoursesPOM.AlertmsgAfterClassToCoursesAdded();
		  Expected="Update successful";
		  Actual=afterSubscribeClassToCoursesPOM.AlertmsgAfterClassToCoursesAdded();
		  boolean labelmsg=Actual.contains(Expected);
		  assertTrue(labelmsg);
		  
		  }
	  @Test(priority=8)
	  public void AfterSubscribeNumofCourses() throws InterruptedException {// number of courses for particular class ?? how to check in same class
		  afterSubscribeClassToCoursesPOM.NoOfCoursesToClass();
		  Expected="1";
		  Actual=afterSubscribeClassToCoursesPOM.NoOfCoursesToClass();
		  boolean labelmsg=Actual.contains(Expected);
		  assertTrue(labelmsg);
		  
		  }
	  @Test(priority=9,enabled=true)
	  public void performDeleteClass()
	  {
		  //afterAddedClassesMsgPOM.click1stRowDeleteBtn();
		  addClassesAddDetailsPOM.click1stRowDeleteBtn();
		  Alert a=driver.switchTo().alert();
		  a.accept();
	  }
	 
	  
  @BeforeClass
  public static void setUpBeforeClass() throws IOException {
	    properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		administrationPOM=  new AdministrationPOM(driver);
		new AddCategoryPOM(driver);
		new CreateACoursePOM(driver);
		new AddaUserPOM(driver);
		new AddUsersToCoursePOM(driver);
		addClassesPOM=new AddClassesPOM(driver);
		addClassesAddDetailsPOM=new AddClassesAddDetailsPOM(driver);
		//afterAddedClassesMsgPOM=new AfterAddedClassesMsgPOM(driver);
		subscribeUserstoClassPOM=new SubscribeUserstoClassPOM(driver);
		subscribeClassToCoursesPOM=new SubscribeClassToCoursesPOM(driver);
		afterSubscribeClassToCoursesPOM=new AfterSubscribeClassToCoursesPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
	    //Open the browser 
		driver.get(baseUrl);
	}

  @AfterClass
  public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}
}
