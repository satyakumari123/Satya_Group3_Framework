package com.training.functional.tests;

import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AdministrationPOM;
import com.training.pom.EditUserInformationPOM;
import com.training.pom.LoginPOM;
import com.training.pom.UserListsPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class UserListViewEditDetails {
	private static WebDriver driver;
	private static String baseUrl;
	private static LoginPOM loginPOM;
	private static Properties properties;
	private static ScreenShot screenShot;
	private static AdministrationPOM administrationPOM;
	private static UserListsPOM userListsPOM;
	private static EditUserInformationPOM editUserInformationPOM;
	
  
  @Test(priority=0,enabled=true)
  public void loginProfileAdmin() throws InterruptedException {
	    loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn();
		Thread.sleep(3000);
	    
  }
  
  @Test(priority=1,enabled=true)
  public void clickuserlistLinkOnAdministration() throws InterruptedException {
	  
	 // administrationPOM.clickAdministrationLabel();
	  Thread.sleep(3000);
	  administrationPOM.clickuserlistLink();
	  Thread.sleep(3000);
	  screenShot.captureScreenShot("UserListViewTest");
	  
  }
  
  @Test(priority=2)
  public void userListPage() {
	  userListsPOM.User1stNamefromUserLists();
	  //System.out.println("FromUserLists :"+userListsPOM.User1stNamefromUserLists());
	  String Expected= userListsPOM.User1stNamefromUserLists();
	  userListsPOM.clickEditUserfromEditIcon();
	  editUserInformationPOM.getuser_edit_firstname();
	  //System.out.println("FromEditUserInformations :"+editUserInformationPOM.getuser_edit_firstname());
	  String Actual= editUserInformationPOM.getuser_edit_firstname();//name on after clicked on edit icon
	  //System.out.println("Is equal name :"+editUserInformationPOM.getuser_edit_firstname().equals(editUserInformationPOM.getuser_edit_firstname()));
	  assertEquals(Actual,Expected);//compare 1st name from user list past and user edit page
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
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		
	}

}
