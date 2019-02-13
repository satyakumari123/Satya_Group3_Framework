package com.training.functional.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.dataproviders.RegistrationDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.AdministrationPOM;
import com.training.pom.ElearningHomePOM;
import com.training.pom.LoginPOM;
import com.training.pom.RegistrationPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
/* Author : Satya Kumari
 * TC ID  : ELTC_076
 * TC Description :TO verify whether application allows multiple user to get registered as Teacher
 * Pre-condition : 1. User should have launched the application
 * #Comment Everytime need to change Sheet name as TC_76 in Apache POI class
 */
public class TC_76ApplicationallowmultiUserToRegisterTest {
	private static WebDriver driver;
	private static JavascriptExecutor jse ;
	private static String baseUrl;
	private static Properties properties;
	private static ScreenShot screenShot;
	private LoginPOM loginPOM;
	private RegistrationPOM registrationPOM;
	private ElearningHomePOM elearningHomePOM;
	private AdministrationPOM administrationPOM;
	String Actual,Expected,Actual1,Expected1;
	
	@Test(priority=0)
	  public void BrowserLaunchTest() {
		    driver = DriverFactory.getDriver(DriverNames.CHROME);
		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			 baseUrl = properties.getProperty("baseURL");
			loginPOM = new LoginPOM(driver);
			registrationPOM=new RegistrationPOM(driver);
			elearningHomePOM=new ElearningHomePOM(driver);
			administrationPOM=new AdministrationPOM(driver);
			screenShot = new ScreenShot(driver); 
			jse =((JavascriptExecutor) driver);
			// open the browser 
			driver.get(baseUrl); 
			}
	
	@Test(priority=1,dataProvider="excel-inputs",dataProviderClass=RegistrationDataProviders.class)
	public void EnterUserCredntialsTogetRegistered(String FirstName, String LastName,String eMail,String UserName,String Pass,String ConfirmPass, String Phone,String Language) throws InterruptedException {
		//Thread.sleep(3000);
		  loginPOM.signUpLink();
		//Thread.sleep(3000);
		  registrationPOM.sendregistration_firstname(FirstName);
		  registrationPOM.sendregistration_lastname(LastName);
		  registrationPOM.sendRegistration_email(eMail);
		  //registrationPOM.sendRegistration_official_code("12345");
		  registrationPOM.senduserName(UserName);
		  registrationPOM.sendPassword(Pass);
		  registrationPOM.sendconfirmPassword(ConfirmPass);
		  registrationPOM.sendregistration_phone(Phone);
		  registrationPOM.selectLanguage(Language);
		 // Thread.sleep(3000);
		  registrationPOM.clickTeacherRBtn();//able to select teacher radio button
		 
		  screenShot.captureScreenShot("RegistrationTest");
		  registrationPOM.clickregistration_submitBtn();
		  
				//Check assertion for displayed message after registration				
			Actual1=registrationPOM.DisplayRegistrationUsersuccessfulSentMsghalf();
			System.out.println("Actual1 "+Actual1);
			Expected1="Dear"+" "+FirstName+" "+LastName+",\n"+
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
			assertTrue(value);
			
			elearningHomePOM.ElearningHDropdownClick();//from teacher login
			elearningHomePOM.clicklogoutDBtn();
			//Thread.sleep(3000);
			loginPOM.sendUserName("admin");
			loginPOM.sendPassword("admin@123");
			loginPOM.clickLoginBtn();
			administrationPOM.clickAdministrationLabel();
			//Thread.sleep(3000);
			administrationPOM.clickuserlistLink();
			administrationPOM.SendNameTosearchTextBox(UserName);
			administrationPOM.clicksearchButton();
			administrationPOM.clickDeleteIcon();
			//Thread.sleep(4000);
			elearningHomePOM.ElearningHDropdownClick();//from teacher login
			elearningHomePOM.clicklogoutDBtn();
			//Thread.sleep(4000);
			
	}
  
	
  @BeforeClass
  public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		
		 }

  @AfterClass
  public void tearDown() throws Exception {
		//Thread.sleep(3000);
		driver.quit();
	}

}
