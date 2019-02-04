package com.training.functional.tests;

import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AddCategoryPOM;
import com.training.pom.AddClassesAddDetailsPOM;
import com.training.pom.AddClassesPOM;
import com.training.pom.AddUsersToCoursePOM;
import com.training.pom.AddaUserPOM;
import com.training.pom.AdministrationPOM;
import com.training.pom.AfterAddedClassesMsgPOM;
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

public class AllowAdminToAddClassSubscribeUserToClassToCoursenSession49Test {
	
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
		
	   }
  @Test(priority=1)//Click on Classes Link
  public void clickClassesLink() throws InterruptedException {
		administrationPOM.clickClassesLink();
		
		 }  
  @Test(priority=2)//Click on AddClasses Button
  public void clickAddClassesLink() throws InterruptedException {
	  addClassesPOM.clickAddClassesBtn();
	  }  
  @Test(priority=3)//On Add Classess Details screen to add contentent
  public void AddClassesAddSdetails() throws InterruptedException {
	  addClassesAddDetailsPOM.sendusergroup_name("demo45");//every time need to change
	// test=addClassesAddDetailsPOM.returnClassname();
	//  System.out.println("Class name :"+test);
	  addClassesAddDetailsPOM.sendusergroup_description("demo Class description");
	  addClassesAddDetailsPOM.selectusergroup_Permission();
	  addClassesAddDetailsPOM.clickusergroup_submitBtn();
	  
		 }
  
  @Test(priority=4)//Msg displayed on screen (Changes after added classess)
  public void AfterClassAddedSmsgDisplayed() throws InterruptedException {//how to go on actual class added need to check on page
	 /* afterAddedClassesMsgPOM.AlertMsgAfterClassessAdded();
	  Actual=afterAddedClassesMsgPOM.AlertMsgAfterClassessAdded();*/
	  addClassesAddDetailsPOM.AlertMsgAfterClassessAdded();
	  Actual=addClassesAddDetailsPOM.AlertMsgAfterClassessAdded();
	  
	  Expected="Item added";
	  boolean msgdisplayed=Actual.contains(Expected);
	  assertTrue(msgdisplayed);
	  
		}
  @Test(priority=5)//Step 7 //validate added class name is present in classes list (Changes after added classess)
  public void AfterClassAddedClassNameDisplayed() throws InterruptedException {
	  /*afterAddedClassesMsgPOM.NemeofAddedClassDisplayed();//2nd row 1st colum class name ABC
	  Actual=afterAddedClassesMsgPOM.NemeofAddedClassDisplayed();*/
	  addClassesAddDetailsPOM.NemeofAddedClassDisplayed();//2nd row 1st colum class name ABC
	  Actual=addClassesAddDetailsPOM.NemeofAddedClassDisplayed();
	  
	  Expected="demo45";//every time need to change
	  //Actual= afterAddedClassesMsgPOM.NemeofAddedClassDemo2Displayed(test);
	  //System.out.println("test click "+Actual);
	  boolean msgdisplayed=Actual.contains(Expected);
	  assertTrue(msgdisplayed);
	  System.out.println("Display class name in list");
		}
  
  @Test(priority=6)//Step 8 ////click on Subscribe users to class icon
  public void ClickonSubscribeBtnForSubscribeUsersToClass() throws InterruptedException {
	  //afterAddedClassesMsgPOM.clickSubscribeuserstoclassBtn();
	  addClassesAddDetailsPOM.clickSubscribeuserstoclassBtn();
	  }
  @Test(priority=7,enabled=true)// Step 8 validated
  
  public void DisplaySubscribeUserstoclassmsg() {
	  Actual=subscribeUserstoClassPOM.DisplaySubscribeUserstoclassmsg();
	  Expected="Subscribe users to class";
	  boolean SubscribeusersToclass=Actual.contains(Expected);
	  assertTrue(SubscribeusersToclass);
  }
  
  @Test(priority=8,enabled=true)//step 9 highlighted user
  public void ClickUsersinPlatformtocheckHighlighted() {
	  subscribeUserstoClassPOM.sendUsersonPlateform("satyaStu1 kumariStu (satyaStu1)  - Student1");//if chnage every time
	  subscribeUserstoClassPOM.testUsersonPlateformbackgroundcolor();
	  System.out.println("Highlighted Username :"+subscribeUserstoClassPOM.testUsersonPlateformbackgroundcolor());
  }
  
  @Test(priority=9,enabled=true)//Step 11 No of users subscribed
  public void SubscribeUsersToClass() throws InterruptedException {
	  
	  subscribeUserstoClassPOM.clickArrowFrdBtn();
	  subscribeUserstoClassPOM.selectUsersingroup();
	  subscribeUserstoClassPOM.SubscribeUserstoClassBtn();
	  //Thread.sleep(3000);
	  Actual=subscribeUserstoClassPOM.DisplaySubscribedusernum();
	  Expected="1";//chnage no every time if no of user chnageds
	  Boolean expectedsubsuser=Actual.contains(Expected);
	  assertTrue(expectedsubsuser);
	  
	  }
  
  
  @Test(priority=10,enabled=true)
  public void ClickonSubscribeBtnForSubscribeClassToCourses() throws InterruptedException {
	  //afterAddedClassesMsgPOM.clickSubscribeclasstocoursesBtn();
	  addClassesAddDetailsPOM.clickSubscribeclasstocoursesBtn();
	   }
  
  @Test(priority=11,enabled=true)//select course and highlighted //step-13 validated
  public void SubscribeClassToCourses() throws InterruptedException { //Subscribe class to course
	  subscribeClassToCoursesPOM.sendCoursesontheplatform("Java8 (4)");// we need to change course everytime
	  //need to check background color of selected course
	  subscribeClassToCoursesPOM.testCoursesOnPlatformbackgroundcolor();
	  System.out.println("Highlighted Coursename :"+subscribeClassToCoursesPOM.testCoursesOnPlatformbackgroundcolor());
	  subscribeClassToCoursesPOM.ClickArrowBtn();
	  subscribeClassToCoursesPOM.DisplayCoursesingroup();
	  subscribeClassToCoursesPOM.ClickSubscribeclasstocoursesBtnBtn();
	  
	  }
  
  @Test(priority=12,enabled=true)
  public void AfterSubscribeClassToCourses() throws InterruptedException {//After subscribe course msg on screen
	  afterSubscribeClassToCoursesPOM.AlertmsgAfterClassToCoursesAdded();
	  Expected="Update successful";
	  Actual=afterSubscribeClassToCoursesPOM.AlertmsgAfterClassToCoursesAdded();
	  boolean labelmsg=Actual.contains(Expected);
	  assertTrue(labelmsg);
	  Thread.sleep(3000);
	  
	  }
  @Test(priority=13,enabled=true)
  public void AfterSubscribeNumofCourses() throws InterruptedException {// number of courses for particular class ?? how to check in same class
	  afterSubscribeClassToCoursesPOM.NoOfCoursesToClass();
	  Expected="1";
	  Actual=afterSubscribeClassToCoursesPOM.NoOfCoursesToClass();
	  boolean labelmsg=Actual.contains(Expected);
	  assertTrue(labelmsg);
	  
	  }
  @Test(priority=14,enabled=false)
  public void performDeleteClass()
  {
	  //afterAddedClassesMsgPOM.click1stRowDeleteBtn();
	  addClassesAddDetailsPOM.click1stRowDeleteBtn();
	  Alert a=driver.switchTo().alert();
	  a.accept();
	  System.out.println("Deleted Class successfully"); 
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
