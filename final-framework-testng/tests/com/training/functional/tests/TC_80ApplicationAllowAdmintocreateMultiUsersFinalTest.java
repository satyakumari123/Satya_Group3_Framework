package com.training.functional.tests;

import org.testng.annotations.Test;

import com.training.dataproviders.RegistrationDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.AddCategoryPOM;
import com.training.pom.AddUsersToCoursePOM;
import com.training.pom.AddaUserPOM;
import com.training.pom.AdministrationPOM;
import com.training.pom.ElearningHomePOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class TC_80ApplicationAllowAdmintocreateMultiUsersFinalTest {
	private static WebDriver driver;
	private static JavascriptExecutor jse ;
	private static String baseUrl;
	private static Properties properties;
	private static ScreenShot screenShot;
	private LoginPOM loginPOM;
	private AdministrationPOM administrationPOM;
	private AddaUserPOM addaUserPOM;
	private AddCategoryPOM addCategoryPOM;
	private AddUsersToCoursePOM addUsersToCoursePOM;
	private ElearningHomePOM elearningHomePOM;
	String Actual,Expected;
	@Test (priority=0)
	  public void BrowserLaunchTest() {
		    driver = DriverFactory.getDriver(DriverNames.CHROME);
			 baseUrl = properties.getProperty("baseURL");
			loginPOM = new LoginPOM(driver);
			administrationPOM=new AdministrationPOM(driver);
			addaUserPOM=new AddaUserPOM(driver);
			addCategoryPOM=new AddCategoryPOM(driver);
			addUsersToCoursePOM=new AddUsersToCoursePOM(driver);
			elearningHomePOM=new ElearningHomePOM(driver);
			screenShot = new ScreenShot(driver); 
			jse =((JavascriptExecutor) driver);
			// open the browser 
			driver.get(baseUrl); 
			}
	@Test(priority=1)
	  public void validLoginTest() throws InterruptedException {
		     
			loginPOM.sendUserName("admin");
			loginPOM.sendPassword("admin@123");
			loginPOM.clickLoginBtn(); 
			Thread.sleep(4000);
			}
	
	@Test(priority=2,enabled=true,dataProvider="excel-inputs",dataProviderClass=RegistrationDataProviders.class)//for every sucessful run we have to change firstname,lastname and user name
	public void clickAddNewUserOnAdministration(String FirstName, String LastName,String eMail,String Phone,String UserName,String Pass) throws InterruptedException {
		  administrationPOM.clickAdministrationLabel();
		  Thread.sleep(3000);
		  administrationPOM.clickAddaUserLink();
		  Thread.sleep(3000);
		addaUserPOM.sendUserfirstname(FirstName);	//firstname
		addaUserPOM.sendUserlastname(LastName); //last name
		addaUserPOM.sendUseremail(eMail); //email id
		addaUserPOM.sendUserphoneNo(Phone); //ph no.
		addaUserPOM.sendUserName(UserName); //user name
		addaUserPOM.sendUserPassword(Pass);		 //password
		screenShot.captureScreenShot();
		addaUserPOM.selectProfile("Trainer");
		Thread.sleep(3000);
		//addaUserPOM.profileOptionsDropdownTo();
		
		addaUserPOM.clickAddUser_submitBtn();//click on submit button
		Thread.sleep(2000);
		addaUserPOM.ViewInfoAfterSubLabel();
		String Actual= addaUserPOM.ViewInfoAfterSubLabel();
		//String Expected="The user has been added: efgg1 hijg";
		String Expected="The user has been added: ";
		boolean namevalue=Actual.contains(Expected);
		assertTrue(namevalue);
		}
	/*@Test(priority=4,enabled=false)//for every succesfull run we need to change in Expected message firstname and lastname
	public void checkDisplayedMsgafterSubmit() {
		addaUserPOM.ViewInfoAfterSubLabel();
		String Actual= addaUserPOM.ViewInfoAfterSubLabel();
		//String Expected="The user has been added: efgg1 hijg";
		String Expected="The user has been added: ";
		boolean namevalue=Actual.contains(Expected);
		assertTrue(namevalue);

		//assertEquals(Actual,Expected);	
		}*/
	 @Test(priority=3,enabled=true)//click on administration link //enabled true done
	  public void ClickAdministrationLink() throws InterruptedException {
		addCategoryPOM.AdministrationLinkClick();
		Thread.sleep(2000);
 }
	  
	  @Test(priority=4,enabled=true)
	  public void ClickAddUsersToCoursesLink() {
	  administrationPOM.clickAddUsersToCoursesLink();
	  }
	  
	  @Test(priority=5,enabled=true)
	  public void DisplayAddUsersToaCourseHomePage() {
		  addUsersToCoursePOM.displayAddUsersToaCourseHomePage();
		  Actual=addUsersToCoursePOM.displayAddUsersToaCourseHomePage();
		  Expected="Add users to course";
		  boolean labelMsg=Actual.contains(Expected);
		  assertTrue(labelMsg);
	  }
	  
    @Test(priority=6,dataProvider="excel-inputs",dataProviderClass=RegistrationDataProviders.class)//select user from user list and checked highlighted colour for selected item
   public void SelectuserfromUserListForAddtoCourse(String FirstName, String LastName,String eMail,String Phone,String UserName,String Pass) throws InterruptedException {
	  addUsersToCoursePOM.selectuserfromUserListforExcel(FirstName,LastName);
	  
	  addUsersToCoursePOM.testUserListbackgroundcolor();//used coding for highlight background
	  System.out.println("Highlighted Username :"+addUsersToCoursePOM.testUserListbackgroundcolor());
	  //
	  addUsersToCoursePOM.selectCourseList("(MEDIUMTESTCASES) MediumProject");
	  addUsersToCoursePOM.testCourseListbackgroundcolor();
	  System.out.println("Highlighted Coursename :"+addUsersToCoursePOM.testCourseListbackgroundcolor());
	  addUsersToCoursePOM.clickAddtothecourseBtn();
	  addUsersToCoursePOM.AlertMsgAftercourseaddedtoUser();
	  Actual=addUsersToCoursePOM.AlertMsgAftercourseaddedtoUser();
	  Expected="The selected users are subscribed to the selected course";
	  boolean labelMsg=Actual.contains(Expected);
	  assertTrue(labelMsg);
	    }
    @Test (priority=7)
    public void ClickOnAdministrationLabelAndUserListLink() throws InterruptedException {
    	administrationPOM.clickAdministrationLabel();
		Thread.sleep(3000);
		administrationPOM.clickuserlistLink();
    }
    @Test(priority=8,dataProvider="excel-inputs",dataProviderClass=RegistrationDataProviders.class)
    public void DeleteAddedUserFromUserList(String FirstName, String LastName,String eMail,String Phone,String UserName,String Pass) throws InterruptedException {
    	administrationPOM.SendNameTosearchTextBox(FirstName);
		administrationPOM.clicksearchButton();
		administrationPOM.clickDeleteIcon();
		Thread.sleep(4000);
		elearningHomePOM.ElearningHDropdownClick();//from teacher login
		elearningHomePOM.clicklogoutDBtn();
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
			driver.quit();
		}

}
