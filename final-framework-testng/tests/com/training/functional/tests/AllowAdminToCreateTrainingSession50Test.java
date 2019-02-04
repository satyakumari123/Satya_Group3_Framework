package com.training.functional.tests;
import org.testng.annotations.Test;
import com.training.generics.ScreenShot;
import com.training.pom.AddCoursestoSessionPOM;
import com.training.pom.AddaTrainingSessionPOM;
import com.training.pom.AdministrationPOM;
import com.training.pom.LoginPOM;
import com.training.pom.SubscribeUserPOM;
import com.training.pom.SubscribeUsertoThisSessionPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;

public class AllowAdminToCreateTrainingSession50Test {
	private static WebDriver driver;
	private static String baseUrl;
	private static LoginPOM loginPOM;
	private static Properties properties;
	private static ScreenShot screenShot;
	private static AdministrationPOM administrationPOM;
	private static AddaTrainingSessionPOM addaTrainingSessionPOM;
	private static AddCoursestoSessionPOM addCoursestoSessionPOM;
	private static SubscribeUserPOM subscribeUserPOM;
	private static SubscribeUsertoThisSessionPOM subscribeUsertoThisSessionPOM;
	String Actual,Expected;
	String Sessionname;
  @Test(priority=0)
  public void validLoginTest() throws InterruptedException {
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("First");	
	   }
  @Test(priority=1)
  public void AdministrationHomePageValidation() throws InterruptedException {
	     // administrationPOM.clickAdministrationLabel();
		  Thread.sleep(5000);
		 Expected="http://elearning.upskills.in/main/admin/index.php";       	
		  Actual=driver.getCurrentUrl();
		  System.out.println("URL Actual :"+driver.getCurrentUrl());
		  assertEquals(Actual,Expected);
		  
		
		  }  
  @Test(priority=2)//click on Add a training session link step 2 validation
  public void AdministrationHomePageUnderCoursesessions() throws InterruptedException{
	     administrationPOM.clickAddTrainingsession();
	     Thread.sleep(3000);
	     Expected="http://elearning.upskills.in/main/session/session_add.php";          
	     Actual= driver.getCurrentUrl();
	     System.out.println("URL Actual :"+driver.getCurrentUrl());
	     assertEquals(Actual,Expected);
	   }
  @Test(priority=3)// added training session page validation step 2 //and Step 3
  public void AddaTrainingSessionPage(){
	  Expected="Add a training session";
	  Actual=addaTrainingSessionPOM.ViewAddatrainingsessionLabel();
	  assertEquals(Actual,Expected);
      addaTrainingSessionPOM.sendadd_session_name("selenium training session34");// in every execution need to change value
      addaTrainingSessionPOM.clicksession_submitBtn();
          }
    @Test(priority=4)//Check step 4 display Add courses to this session (session name) page
  public void Displaycoursestothissessionname() {//full name  displayed need to taken dynamic 
	 
	  Expected="Add courses to this session (selenium training session34)"; //need to keep change same session name in every execution
	  System.out.println("Expected course :"+Expected);
	  Actual=addaTrainingSessionPOM.Displayadd_CoursestoThisSessionLabel();
	  System.out.println("Actual course :"+addaTrainingSessionPOM.Displayadd_CoursestoThisSessionLabel());
	  assertEquals(Actual,Expected);
	  }
  
  @Test(priority=5)//step 5 //course selected from course list so selected course will get hilighted
  public void ValidateSelectedCoursefromCourseListHighlighted() throws InterruptedException {
	  addCoursestoSessionPOM.Selectcourses("felenium7 (FELE7)");//course selected from course list
	  addCoursestoSessionPOM.testSlectedCoursebackgroundcolorinCourseList();//background clour of selected item
	  System.out.println("Selected course Highlighted "+addCoursestoSessionPOM.testSlectedCoursebackgroundcolorinCourseList());
	  
	  Thread.sleep(4000);
 }
  
  @Test(priority=6)//Step 6 validated selected course in Courses in this session window should get displayed
  public void validateSelectedCourseinCoursesinThisSession() {
	  addCoursestoSessionPOM.clickbuttonBtn();//click on arrow> button
	  String Actual=addCoursestoSessionPOM.showSelectcoursesinSession();//course in session courses lists
		  Expected="felenium7 (FELE7)";
		  boolean compare=Actual.contains(Expected);
		  assertTrue(compare);
  }
  
  @Test(priority=7)//step 7 validated Display full name with <session name>
  public void StudentSubscribe()
  {
	  addCoursestoSessionPOM.clicknextStepbuttonBtn();
	  subscribeUserPOM.SubscribeusersmsgLabel();
	  Actual=subscribeUserPOM.SubscribeusersmsgLabel();
	  Expected="Subscribe users to this session (selenium training session34)";
	  assertEquals(Actual,Expected);
	 // boolean valuelabel=Actual.contains(Expected);
	 // assertTrue(valuelabel);
  }
  
  @Test(priority=8)//step 8 validated for linked name 
  public void StudentSessionSubscribe()
  {
	  /*subscribeUsertoThisSessionPOM.SubscribeuserssessionmsgLabel();
	  Actual=subscribeUserPOM.SubscribeusersmsgLabel();
	  Expected="Subscribe users to this session";
	  assertEquals(Actual,Expected);*/
	  subscribeUserPOM.sendStudName("sunil");//to check value in portal user list 
	  subscribeUserPOM.Portaluserslistnamelink();
	  subscribeUserPOM.getTagnameofuserlinkdisplayPortaluserslist();//get tag name
	  Actual=subscribeUserPOM.getTagnameofuserlinkdisplayPortaluserslist();
	  System.out.println("Tag name for Link name: "+subscribeUserPOM.getTagnameofuserlinkdisplayPortaluserslist());
	  Expected="a";
	  boolean tagoflink=Actual.contains(Expected);
	  assertTrue(tagoflink);
	 /* Expected="sunil";
	  Actual=subscribeUserPOM.Portaluserslistnamelink();
	  boolean valuelabe2=Actual.contains(Expected);
	  assertTrue(valuelabe2); */
	   //System.out.println(subscribeUsertoThisSessionPOM.SubscribeuserssessionmsgLabel());
  }
  @Test(priority=9)//step 9 validated
  public void StudentSessionSubscribemessage() throws InterruptedException
  {
	  Thread.sleep(3000);
   subscribeUserPOM.PortaluserslistnamelinkClick();
   subscribeUserPOM.ajax_listuser1stDestination();
   //Actual="kumar sunil (sunil94)";
   Actual="kumar sunil (sunkum09) SUNKUM09 ";
   Expected=subscribeUserPOM.ajax_listuser1stDestination();
   System.out.println("Expected Displayed "+subscribeUserPOM.ajax_listuser1stDestination());
   boolean username=Actual.contains(Expected);
   assertTrue(username);
   Thread.sleep(4000);
  }
  
  @Test(priority=10)//step 10 validated
  public void FinishSubmissionBtn() {
  subscribeUserPOM.FinishsessioncreationClick();
  subscribeUsertoThisSessionPOM.SubscribeuserssessionmsgLabel();
 Actual= subscribeUsertoThisSessionPOM.Courselisttitle();
 Expected="felenium7 (FELE7)";
 // Actual=subscribeUsertoThisSessionPOM.SubscribeuserssessionmsgLabel();//getting fail due to iframe
  //Expected="selenium training session";
 boolean valuelabe3=Actual.contains(Expected);
 assertTrue(valuelabe3);
  
  }
  @BeforeClass
  public static void setUpBeforeClass() throws IOException {
	    properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		administrationPOM=  new AdministrationPOM(driver);
		addaTrainingSessionPOM=new AddaTrainingSessionPOM(driver);
		addCoursestoSessionPOM=new AddCoursestoSessionPOM(driver);
		subscribeUserPOM=new SubscribeUserPOM(driver);
		subscribeUsertoThisSessionPOM=new SubscribeUsertoThisSessionPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
	    //Open the browser 
		driver.get(baseUrl);
	}

  @AfterClass
  public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}
}

/*List user=subscribeUserPOM.ajax_listuser_Destination();//how to compare with destination list
user.size();
for(int i=0;i<user.size();i++) {
	 // user.get(i).getText();
	  String name =  user.get(i).getText();
	  //System.out.println("User name :"+user.get(i)); }*/
