package com.training.functional.tests;

import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AddCategoryPOM;
import com.training.pom.AddUsersToCoursePOM;
import com.training.pom.AddaUserPOM;
import com.training.pom.AdministrationPOM;
import com.training.pom.CreateACoursePOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class AllowAdminToCreateUserAndRegisterUserToCourse48Test {
	
	private static WebDriver driver;
	private static JavascriptExecutor jse;
	private static String baseUrl;
	private static LoginPOM loginPOM;
	private static Properties properties;
	private static ScreenShot screenShot;
	private static AdministrationPOM administrationPOM;
	private static AddCategoryPOM addCategoryPOM;
	private static CreateACoursePOM createACoursePOM;
	private static AddaUserPOM addaUserPOM;
	private static AddUsersToCoursePOM addUsersToCoursePOM;
	String Actual,Expected;
	String Sessionname;
	
	@Test(priority=0,enabled=true)
	  public void loginProfileAdmin() throws InterruptedException {
		    loginPOM.sendUserName("admin");
			loginPOM.sendPassword("admin@123");
			loginPOM.clickLoginBtn();
			Thread.sleep(3000);
		 }
	
  @Test(priority=1,enabled=true)
  public void AddaUserLinkClick() {
	  administrationPOM.clickAddaUserLink();
  }
  @Test(priority=2,enabled=true)
  public void AddaUser() {
	  addaUserPOM.sendUserfirstname("SatyaTF112");//in each execution need to change
	  addaUserPOM.sendUserlastname("KumariL");
	  addaUserPOM.sendUserofficialcode("Satya123");
	  addaUserPOM.sendUseremail("satyaashu@gmail.com");
	  addaUserPOM.sendUserphoneNo("7722032874");
	  addaUserPOM.sendUserName("SatyaTAF112"); //in each execution need to change
	  addaUserPOM.sendUserPassword("satyaashu5");
	  addaUserPOM.selectProfile("Trainer");
	  jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
      addaUserPOM.clickAddUser_submitBtn();
  }
  @Test(priority=3,enabled=true)//step 11 validation for new user added with full name 
  public void CheckPagedisplayAfterUserAdded()
  {
	 Actual=addaUserPOM.ViewInfoAfterSubLabel();
	 System.out.println(addaUserPOM.ViewInfoAfterSubLabel());
	 Expected="The user has been added: SatyaTF112 KumariL";//in each execution need to change full name
	 System.out.println(Expected);
	 assertEquals(Actual,Expected);
  }
  
  @Test(priority=4,enabled=true)//click on administration link
  public void ClickAdministrationLink() throws InterruptedException {
	addCategoryPOM.AdministrationLinkClick();
	Thread.sleep(2000);

  }
  
  @Test(priority=5,enabled=true)
  public void ClickAddUsersToCoursesLink() {
  administrationPOM.clickAddUsersToCoursesLink();
  }
  
  @Test(priority=6,enabled=true)
  public void DisplayAddUsersToaCourseHomePage() {
	  addUsersToCoursePOM.displayAddUsersToaCourseHomePage();
	  Actual=addUsersToCoursePOM.displayAddUsersToaCourseHomePage();
	  Expected="Add users to course";
	  boolean labelMsg=Actual.contains(Expected);
	  assertTrue(labelMsg);
  }
  
  @Test(priority=7)//select user from user list and checked highlighted colour for selected item
  public void SelectuserfromUserListForAddtoCourse() {
	  addUsersToCoursePOM.selectuserfromUserList("kumariStu satyaStu1 (satyaStu1)");  
	  addUsersToCoursePOM.testUserListbackgroundcolor();//used coding for highlight background
	  System.out.println("Highlighted Username :"+addUsersToCoursePOM.testUserListbackgroundcolor());
	  //assertTrue(addUsersToCoursePOM.testUserListbackgroundcolor().contains("css=td[bgcolor=#000]"));
	  
  }
  
  @Test(priority=8)//select course from course list and highted and add
  public void SelectCoursefromCourseListforUser() {
	  addUsersToCoursePOM.selectCourseList("(MEDIUMTESTCASES) MediumProject");
	  addUsersToCoursePOM.testCourseListbackgroundcolor();
	  System.out.println("Highlighted Coursename :"+addUsersToCoursePOM.testCourseListbackgroundcolor());
	  
	  
  }
  @Test(priority=9)
  public void ClickUserListAddtoCourseBtn() {
	  addUsersToCoursePOM.clickAddtothecourseBtn(); 
  }
  
  /*@Test(priority=8)//to check background clour is different from highlight color of user selected
  public void checkitemhighlighted() {
	  assertTrue(addUsersToCoursePOM.testUserListbackgroundcolor().contains("css=td[bgcolor=#000]"));
  }*/
  @Test(priority=10)//Step 16 validated
  public void AlertMsgcourseaddedtoUserLabel() {
	  addUsersToCoursePOM.AlertMsgAftercourseaddedtoUser();
	  Actual=addUsersToCoursePOM.AlertMsgAftercourseaddedtoUser();
	  Expected="The selected users are subscribed to the selected course";
	  boolean labelMsg=Actual.contains(Expected);
	  assertTrue(labelMsg);
  }
  
  
  @BeforeClass
  public static void setUpBeforeClass() throws IOException {
	    properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		 jse=((JavascriptExecutor) driver);
		administrationPOM=  new AdministrationPOM(driver);
		addCategoryPOM=new AddCategoryPOM(driver);
		createACoursePOM=new CreateACoursePOM(driver);
		addaUserPOM=new AddaUserPOM(driver);
		addUsersToCoursePOM=new AddUsersToCoursePOM(driver);
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
