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

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class TC_78RegisteredTeacherdetailstoredInDatabaseTest {
  @Test
  public void f() {
  }
  @BeforeClass
  public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		
		 }
  private static WebDriver driver;
	private static JavascriptExecutor jse ;
	private static String baseUrl;
	private static Properties properties;
	private static ScreenShot screenShot;
	private LoginPOM loginPOM;
	private RegistrationPOM registrationPOM;
	String Actual,Expected;
	@Test (priority=0)
	  public void BrowserLaunchTest() {
		    driver = DriverFactory.getDriver(DriverNames.CHROME);
			 baseUrl = properties.getProperty("baseURL");
			loginPOM = new LoginPOM(driver);
			registrationPOM=new RegistrationPOM(driver);
			screenShot = new ScreenShot(driver); 
			jse =((JavascriptExecutor) driver);
			// open the browser 
			driver.get(baseUrl); 
			}
	@Test (priority =1)
	  public void RegisterLinkTest() throws InterruptedException {
		  	
		  Thread.sleep(3000);
		  loginPOM.signUpLink();
		  }

  @AfterClass
  public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}

}
