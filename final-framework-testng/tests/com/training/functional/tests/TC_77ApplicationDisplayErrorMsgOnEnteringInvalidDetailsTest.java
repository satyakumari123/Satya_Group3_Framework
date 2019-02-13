package com.training.functional.tests;

import org.testng.annotations.Test;

import com.google.common.base.Verify;
import com.training.dataproviders.RegistrationDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.AdministrationPOM;
import com.training.pom.ElearningHomePOM;
import com.training.pom.LoginPOM;
import com.training.pom.RegistrationPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
/* Author : Satya Kumari
 * TC ID  : ELTC_077
 * TC Description :TO verify whether application displays error message upon entering invalid details while getting registered as Teacher
 * Pre-condition : 1. User should have launched the application
 * #Comment Everytime need to change Sheet name as TC_77 in Apache POI class
 */
public class TC_77ApplicationDisplayErrorMsgOnEnteringInvalidDetailsTest {
	private static WebDriver driver;
	private static JavascriptExecutor jse ;
	private static String baseUrl;
	private static Properties properties;
	private static ScreenShot screenShot;
	private LoginPOM loginPOM;
	private RegistrationPOM registrationPOM;
	private ElearningHomePOM elearningHomePOM;
	private AdministrationPOM administrationPOM;
	String Actual,Expected;
	@BeforeMethod
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
		try {
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
		  registrationPOM.clickTeacherRBtn();//able to select teacher radio button
		  	screenShot.captureScreenShot("RegistrationTest");
		  registrationPOM.clickregistration_submitBtn();
		 
		  Actual=registrationPOM.DisplayRegistrationErrorMsg();
		 // if (Actual!=null) {
		  System.out.println("Error Msg After Clicked registration Btn :"+Actual);
		   //}
		  }catch(NoSuchElementException e) {
		      //String xyz=registrationPOM.DisplayRegistrationMailsentMsgHalf(); 
			  System.out.println("Registration Done successfully: This is Defect: As accepted wrong data");
			    elearningHomePOM.ElearningHDropdownClick();//from teacher login
				elearningHomePOM.clicklogoutDBtn();
				
				loginPOM.sendUserName("admin");
				loginPOM.sendPassword("admin@123");
				loginPOM.clickLoginBtn();
				administrationPOM.clickAdministrationLabel();
				
				administrationPOM.clickuserlistLink();
				administrationPOM.SendNameTosearchTextBox(UserName);
				administrationPOM.clicksearchButton();
				administrationPOM.clickDeleteIcon();
				
				elearningHomePOM.ElearningHDropdownClick();//from teacher login
				elearningHomePOM.clicklogoutDBtn();
				
			   }
		  }

	@Test(priority=3,enabled=false)
	public void checkInvalidmsgAfterRegistration() {
		/*Expected="Dear ,\n" + 
				"\n" + 
				"Your personal settings have been registered.\n" + 
				"\n" + 
				"An email has been sent to help you remember your login and password.";*/
		
		//Actual=registrationPOM.DisplayRegistrationMailsentMsg();
		Expected="An email has been sent to help you remember your login and password.";
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
		//Thread.sleep(3000);
		driver.quit();
	}

}
