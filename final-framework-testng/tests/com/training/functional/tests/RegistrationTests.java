package com.training.functional.tests;

import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.RegistrationPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import org.testng.annotations.BeforeClass;

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
	  registrationPOM.sendregistration_firstname("SatyaT");
	  registrationPOM.sendregistration_lastname("KumariT");
	  registrationPOM.sendRegistration_email("satyakumari@gmail.com");
	  registrationPOM.sendRegistration_official_code("12345");
	  registrationPOM.senduserName("SatyaTU");
	  registrationPOM.sendPassword("satyaashu5");
	  registrationPOM.sendconfirmPassword("satyaashu5");
	  registrationPOM.sendregistration_phone("7722032874");
	  Thread.sleep(3000);
	  registrationPOM.clickTeacherRBtn();//unable to select teacher radio button
	  Thread.sleep(2000);
	  screenShot.captureScreenShot("RegistrationTest");
	  registrationPOM.clickregistration_submitBtn();
	 	
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
