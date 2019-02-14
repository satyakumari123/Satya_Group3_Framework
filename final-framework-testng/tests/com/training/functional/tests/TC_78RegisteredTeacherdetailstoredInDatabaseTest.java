package com.training.functional.tests;

import org.testng.annotations.Test;

import com.training.dataproviders.RegistrationDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.AdministrationPOM;
import com.training.pom.ElearningHomePOM;
import com.training.pom.LoginPOM;
import com.training.pom.RegistrationPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
/* Author : Satya Kumari
 * TC ID  : ELTC_078
 * TC Description :To verify whether registered Teacher details stored in database
 * Pre-condition : 1. User should have launched the application
 * //it will always fail every assertion as we don't have application connected to db ..
 */
public class TC_78RegisteredTeacherdetailstoredInDatabaseTest {
 
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
	private ElearningHomePOM elearningHomePOM;
	private AdministrationPOM administrationPOM;
	private RegistrationPOM registrationPOM;
	String Actual,Expected;
	@Test (priority=0)
	  public void BrowserLaunchTest() {
		    driver = DriverFactory.getDriver(DriverNames.CHROME);
		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			 baseUrl = properties.getProperty("baseURL");
			loginPOM = new LoginPOM(driver);
			elearningHomePOM=new ElearningHomePOM(driver);
			administrationPOM=new AdministrationPOM(driver);
			registrationPOM=new RegistrationPOM(driver);
			screenShot = new ScreenShot(driver); 
			jse =((JavascriptExecutor) driver);
			// open the browser 
			driver.get(baseUrl); 
			}
	@Test (priority =1,dataProvider = "db-inputs", dataProviderClass = RegistrationDataProviders.class)
	  public void RegisterLinkTest(String FirstName, String LastName,String eMail,String UserName,String Pass,String ConfirmPass, String Phone,String Language) throws InterruptedException {
		  	
		  loginPOM.signUpLink();
		  registrationPOM.sendregistration_firstname("xyz");//every execution need to change value
		  String firstname=registrationPOM.returnFirstName();
		  registrationPOM.sendregistration_lastname("KumariS");
		  String lastname=registrationPOM.returnLastName();
		  registrationPOM.sendRegistration_email("satyakumari@gmail.com");
		  String email=registrationPOM.returneMail();
		 // registrationPOM.sendRegistration_official_code("12345");
		  registrationPOM.senduserName("xyzxx"); //every execution need to change value
		  String username=registrationPOM.returnUserName();
		  registrationPOM.sendPassword("satyaashu5");
		  String pass=registrationPOM.returnPass();
		  registrationPOM.sendconfirmPassword("satyaashu5");
		  String confirmpass=registrationPOM.returnConfirmPass();
		  registrationPOM.sendregistration_phone("7722032874");
		  String phone=registrationPOM.returnPhone();
		  registrationPOM.selectLanguage("English");
		  String language=registrationPOM.returnLanguage();
		 
		  registrationPOM.clickTeacherRBtn();// select teacher radio button
		
		  screenShot.captureScreenShot("RegistrationTest");
		  registrationPOM.clickregistration_submitBtn();//click on submit button
		//Applied Assertion to compare db value to application values but here db is not connected with application so all assertion will get fail and this is expected.  
		  assertEquals(firstname,FirstName);
		  assertEquals(lastname,LastName);
		  assertEquals(email,eMail);
		  assertEquals(username,UserName);
		  assertEquals(pass,Pass);
		  assertEquals(confirmpass,ConfirmPass);
		  assertEquals(phone,Phone);
		  assertEquals(Language,Language);
	
	//As we are using assertion so it will stop  if it got fail in 1st assertion so next assertion will not execute	  
		    
 
		   }
	
	

  @AfterClass
  public void tearDown() throws Exception {
		//Thread.sleep(3000);
		driver.quit();
	}

}
