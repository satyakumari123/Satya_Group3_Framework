package com.training.functional.tests;

import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.RegistrationPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class RegistrationTests {
	
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private RegistrationPOM registrationPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	public String Actual,Expected,Actual1,Expected1;

  @Test (priority=0)
  public void BrowserLaunchTest() {
	    driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		registrationPOM = new RegistrationPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
  }
  
  @Test (priority =1)
  public void RegisterLinkTest() throws InterruptedException {
	  	
	  Thread.sleep(3000);
	  loginPOM.signUpLink();
	
  }
  
  @Test(priority=2)
  public void RegisterHomeTest() throws InterruptedException {
	  	
	  Thread.sleep(3000);
	  registrationPOM.sendregistration_firstname("xyz");
	  registrationPOM.sendregistration_lastname("KumariS");
	  registrationPOM.sendRegistration_email("satyakumari@gmail.com");
	  registrationPOM.sendRegistration_official_code("12345");
	  registrationPOM.senduserName("xyzxx");
	  registrationPOM.sendPassword("satyaashu5");
	  registrationPOM.sendconfirmPassword("satyaashu5");
	  registrationPOM.sendregistration_phone("7722032874");
	  Thread.sleep(3000);
	 // registrationPOM.clickTeacherRBtn();//unable to select teacher radio button
	 // Thread.sleep(2000);
	  screenShot.captureScreenShot("RegistrationTest");
	  registrationPOM.clickregistration_submitBtn();
	 	
  }
  @Test(priority=3)
  public void DisplayRegistrationSuccessfulFullMsg() {
	/*  Actual=registrationPOM.DisplayRegistrationSuccessfulFullMsg();
	  System.out.println("Actual msg"+Actual);
	  Expected="Dear xyzxx KumariS,\n" + 
	  		"\n" + 
	  		"Your personal settings have been registered.\n" + 
	  		"\n" + 
	  		"An email has been sent to help you remember your login and password.";
	  System.out.println("Expected msg"+Expected);
	  
	  boolean msgDisplayed=Actual.contains(Expected);
	  assertTrue(msgDisplayed);*/
	  Actual1=registrationPOM.DisplayRegistrationUsersuccessfulSentMsghalf();
		System.out.println("Actual1 "+Actual1);
		Expected1="Dear xyz KumariS,\n"+
				"\n"+
				"Your personal settings have been registered.";
		System.out.println("Expected1 "+Expected1);
		boolean value1=Actual1.contains(Expected1);
		assertTrue(value1);
		Actual=registrationPOM.DisplayRegistrationMailsentMsgHalf();
		System.out.println("Actual "+Actual);
		Expected="An email has been sent to help you remember your login and password.";
		System.out.println("Expected "+Expected);
		boolean value=Actual.contains(Expected);
		assertEquals(Actual,Expected);
  }
  
  @BeforeClass
  
	  public static void setUpBeforeClass() throws IOException {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/others.properties");
			properties.load(inStream);
		
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
	  
  }

}
