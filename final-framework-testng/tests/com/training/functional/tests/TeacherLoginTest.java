package com.training.functional.tests;

import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.ElearningHomePOM;
import com.training.pom.LoginPOM;
import com.training.pom.RegistrationPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class TeacherLoginTest {
	private static WebDriver driver;
	private String baseUrl;
	private static LoginPOM loginPOM;
	private static ElearningHomePOM elearningHomePOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private String loginPageTitle; 
	private String logoutpageTitle;
	private String expectedURL,actualURL;
	
	@Test (priority=0)
	  public void BrowserLaunchTest() {//get url and instanciate object of POM class used
		   driver = DriverFactory.getDriver(DriverNames.CHROME);
		   
		   baseUrl = properties.getProperty("baseURL");
		   loginPOM = new LoginPOM(driver); 
		   elearningHomePOM =new  ElearningHomePOM (driver);
		   screenShot = new ScreenShot(driver); 
			// open the browser 
			driver.get(baseUrl);
	  }
	@Test (priority =1)//login with teacher credentials
	public void validLoginTest() throws InterruptedException {
		/*String loginPageTitle =driver.getTitle();
		System.out.println("Before Login :"+loginPageTitle); */
		loginPOM.sendUserName("satyaTSelf");
		loginPOM.sendPassword("satyaashu5");
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("First");
		 Thread.sleep(3000);
	}
	
	@Test(priority=2)
	  public void ElearningHomeTest() throws InterruptedException {//click on right icon for veiw list,inbox,elearning,logout
		  elearningHomePOM.ElearningHDropdownClick();
		  screenShot.captureScreenShot("TeacherLoginTest");
		  Thread.sleep(3000);
		  elearningHomePOM.clicklogoutDBtn();
		 /* String logoutpageTitle =driver.getTitle();//title of page after log out
		  System.out.println("After Logout :"+logoutpageTitle); */
		   actualURL= driver.getCurrentUrl(); //url after logged out 
		   System.out.println(driver.getCurrentUrl());
		   
		 }
	
   @Test(priority=3,enabled=false)
   public void comparepageTitle() {//compare title of 2 pages
	   
	   assertEquals(loginPageTitle, logoutpageTitle);//use assert for compare value
	   //System.out.println(" Are they equal "+(loginPageTitle.equals(logoutpageTitle)));
	} 
   @Test(priority=4)
   public void comparepageUrl() {//compare url
	   
	   expectedURL="http://elearning.hommelle.com/index.php";//url after log out
	   assertEquals(actualURL,expectedURL);
   }
  @BeforeClass
  public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		
	}
  
  @AfterClass
  public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

}