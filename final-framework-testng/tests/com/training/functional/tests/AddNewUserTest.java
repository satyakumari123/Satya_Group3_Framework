package com.training.functional.tests;

import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AddaUserPOM;
import com.training.pom.AdministrationPOM;
import com.training.pom.EditUserInformationPOM;
import com.training.pom.LoginPOM;
import com.training.pom.UserListsPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class AddNewUserTest {
	private static WebDriver driver;
	private static String baseUrl;
	private static LoginPOM loginPOM;
	private static Properties properties;
	private static ScreenShot screenShot;
	private static AdministrationPOM administrationPOM;
	private static UserListsPOM userListsPOM;
	private static EditUserInformationPOM editUserInformationPOM;
	private static AddaUserPOM addaUserPOM;
	
	@Test(priority=0,enabled=true)
	  public void loginProfileAdmin() throws InterruptedException {
		    loginPOM.sendUserName("admin");
			loginPOM.sendPassword("admin@123");
			loginPOM.clickLoginBtn();
			Thread.sleep(3000);
		    
	  }
	@Test(priority=1,enabled=true)
	  public void clickAddnewUserLinkOnAdministration() throws InterruptedException {
		  
		 // administrationPOM.clickAdministrationLabel();
		  Thread.sleep(3000);
		  administrationPOM.clickAddaUserLink();
		  Thread.sleep(3000);
		  
	  }  
	@Test(priority=2)//for every sucessful run we have to change firstname,lastname and user name
	public void clickAddNewUserOnAdministration() throws InterruptedException {
		addaUserPOM.sendUserfirstname("LMK4");	
		addaUserPOM.sendUserlastname("KML");
		addaUserPOM.sendUseremail("satyaashu@gmail.com");
		addaUserPOM.sendUserphoneNo("8552971341");
		addaUserPOM.sendUserName("LMKKML4");
		addaUserPOM.sendUserPassword("satyaashu5");		
		//Actions action=new Actions(driver);
		//addaUserPOM.profileOptionsDropdownFrom();//by default value
		screenShot.captureScreenShot("AddNewUser1");
		//Thread.sleep(3000);
		addaUserPOM.selectProfile("Trainer");
		Thread.sleep(3000);
		//addaUserPOM.profileOptionsDropdownTo();
		screenShot.captureScreenShot("AddNewUser2");
		addaUserPOM.clickAddUser_submitBtn();//click on submit button
		Thread.sleep(2000);
		//System.out.println("Hello");
		screenShot.captureScreenShot("AddNewUser3");
		}
	
	@Test(priority=3)//for every succesfull run we need to change in Expected message firstname and lastname
	public void checkDisplayedMsgafterSubmit() {
		addaUserPOM.ViewInfoAfterSubLabel();
		String Actual= addaUserPOM.ViewInfoAfterSubLabel();
		//String Expected="The user has been added: efgg1 hijg";
		String Expected="The user has been added: ";
		boolean namevalue=Actual.contains(Expected);
		assertTrue(namevalue);

		//assertEquals(Actual,Expected);	
		}
	@Test(priority=4)//for every successful run we need change searchbox content
	public void checkaddedUserfromSearch() throws InterruptedException {
		addaUserPOM.sendSearchTextBox("LMKKML4"); //need to change this as username for every run
		addaUserPOM.clicksearchBtn();
		Thread.sleep(3000);
		String Actual1 =addaUserPOM.sendSearchTextBox();
		String Expected1="LMKKML4"; //need to change this value for every run
		assertEquals(Actual1,Expected1);//check login from user list same as added
		
	}
	
	
  @AfterClass
  public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}

  @BeforeClass
  public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		administrationPOM=  new AdministrationPOM(driver);
		 userListsPOM =new UserListsPOM(driver);
		 editUserInformationPOM =new EditUserInformationPOM(driver);
		 addaUserPOM=new AddaUserPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		
	}

}
