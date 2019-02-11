package com.training.functional.tests;

import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.dataproviders.RegistrationDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.CoursesCatalogPOM;
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

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class TC_76ApplicationAllowsMultipleUsertoGetRegisteredAsTeacherTest {
	
	private static WebDriver driver;
	private static JavascriptExecutor jse ;
	private static String baseUrl;
	private static Properties properties;
	private static ScreenShot screenShot;
	private LoginPOM loginPOM;
	private RegistrationPOM registrationPOM;
	String Actual,Expected,Actual1,Expected1;
	
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
	@Test(priority=2,dataProvider="excel-inputs",dataProviderClass=RegistrationDataProviders.class)
	public void EnterUserCredntialsTogetRegistered(String FirstName, String LastName,String eMail,String UserName,String Pass,String ConfirmPass, String Phone,String Language) throws InterruptedException {
		Thread.sleep(3000);
		  registrationPOM.sendregistration_firstname(FirstName);
		  registrationPOM.sendregistration_lastname(LastName);
		  registrationPOM.sendRegistration_email(eMail);
		  //registrationPOM.sendRegistration_official_code("12345");
		  registrationPOM.senduserName(UserName);
		  registrationPOM.sendPassword(Pass);
		  registrationPOM.sendconfirmPassword(ConfirmPass);
		  registrationPOM.sendregistration_phone(Phone);
		  registrationPOM.selectLanguage(Language);
		  Thread.sleep(3000);
		  registrationPOM.clickTeacherRBtn();//able to select teacher radio button
		 Thread.sleep(2000);
		  screenShot.captureScreenShot("RegistrationTest");
		  registrationPOM.clickregistration_submitBtn();
	}
  
	@Test(priority=3,enabled=false,dataProvider="excel-inputs",dataProviderClass=RegistrationDataProviders.class)
	public void checkvalidationmsgAfterRegistration(String FirstName, String LastName) {
		/*Expected="Dear ,\n" + 
				"\n" + 
				"Your personal settings have been registered.\n" + 
				"\n" + 
				"An email has been sent to help you remember your login and password.";*/
		
		Actual1=registrationPOM.DisplayRegistrationUsersuccessfulSentMsghalf();
		System.out.println("Actual1"+Actual1);
		Expected1="Dear"+FirstName +LastName+"\n,"+
				"\n"+ 
				"Your personal settings have been registered.";
		boolean value1=Actual1.contains(Expected1);
		assertTrue(value1);
		Actual=registrationPOM.DisplayRegistrationMailsentMsgHalf();
		System.out.println("Actual"+Actual);
		Expected="An email has been sent to help you remember your login and password.";
		System.out.println("Expected"+Expected);
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
  public void tearDown() throws Exception {
		Thread.sleep(3000);
		//driver.quit();
	}

}
