package com.training.functional.tests;

import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AdministrationPOM;
import com.training.pom.EditProfilePOM;
import com.training.pom.ElearningHomePOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class EditAdminProfileTest {
	private static WebDriver driver;
	private static String baseUrl;
	private static LoginPOM loginPOM;
	private static ElearningHomePOM elearningHomePOM;
	private static Properties properties;
	private static ScreenShot screenShot;
	private static EditProfilePOM editProfilePOM;
	private static AdministrationPOM administrationPOM;
	
	@Test(priority=0,enabled=true)
  public void loginProfileAdmin() throws InterruptedException {
	    loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn();
		Thread.sleep(3000);
	    
  }
  
  @Test (priority=1,enabled=true)//click on homepage from admin login
  public void clickeHomepageAdmin() throws InterruptedException {
	    administrationPOM.clickHomepageLink();
	    Thread.sleep(3000);
	    	  
  }
  
  @Test(priority=2,enabled=true) //click on edit profile link
  public void clickeditProfileAdmin() throws InterruptedException {
	    
   elearningHomePOM.clickeditProfileLink();
	  
  }
  
  
  @Test(priority=3,enabled=true) //click on edit profile content and set new password
  public void editProfileAdmin() throws InterruptedException {
	  editProfilePOM.sendprofilePassword("admin@123"); //admin@123
	  editProfilePOM.sendNewSetPassword("admin@123");//satya@123//dont want to change so keeping same password for update
	  editProfilePOM.sendconfirmSetPassword("admin@123");
	  editProfilePOM.clickProfileApplyChangeBtn();
	  editProfilePOM.alertinfoafterUpdate();//to get message from profile
	  screenShot.captureScreenShot("EditAdminProfile");

	  String Actual=editProfilePOM.alertinfoafterUpdate();
	  String Expected="Your new profile has been saved"; //message should display on screen after update
	  assertEquals(Actual,Expected);//compare message on screen after update
	 Thread.sleep(3000);
  }
  
  
  @BeforeClass
  public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		elearningHomePOM =new  ElearningHomePOM (driver);
		editProfilePOM= new EditProfilePOM(driver);
		administrationPOM=new AdministrationPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		
	}
  @AfterClass
  public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}

  
  /*@BeforeMethod
  public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}*/
 
 
}
