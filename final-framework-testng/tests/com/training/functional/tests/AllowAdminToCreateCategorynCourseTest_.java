package com.training.functional.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AddCategoryPOM;
import com.training.pom.AddCoursestoSessionPOM;
import com.training.pom.AddaTrainingSessionPOM;
import com.training.pom.AdministrationPOM;
import com.training.pom.CourseListPOM;
import com.training.pom.CreateACoursePOM;
import com.training.pom.LoginPOM;
import com.training.pom.SubscribeUserPOM;
import com.training.pom.SubscribeUsertoThisSessionPOM;
import com.training.pom.UserListsPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AllowAdminToCreateCategorynCourseTest_ {
	private static WebDriver driver;
	private static JavascriptExecutor jse;
	private static String baseUrl;
	private static LoginPOM loginPOM;
	private static Properties properties;
	private static ScreenShot screenShot;
	private static AdministrationPOM administrationPOM;
	private static AddCategoryPOM addCategoryPOM;
	private static CreateACoursePOM createACoursePOM;
	private static CourseListPOM courseListPOM;
	String Actual,Expected;
	String Sessionname;
	@Test(priority=0,enabled=true)
	  public void loginProfileAdmin() throws InterruptedException {
		    loginPOM.sendUserName("admin");
			loginPOM.sendPassword("admin@123");
			loginPOM.clickLoginBtn();
			Thread.sleep(3000);
		 }
  @Test(priority=1,enabled=true)
  public void CategoryCourse() {
	  administrationPOM.clickCoursescategoriesLink();
	  Expected="http://elearning.upskills.in/main/admin/course_category.php";
	  Actual=driver.getCurrentUrl();
	  boolean urlcheck=Actual.contains(Expected);
	  assertTrue(urlcheck);
	  }
  @Test(priority=2,enabled=true)
  public void CategoryCourseImage() throws InterruptedException {
		Thread.sleep(2000);
	  addCategoryPOM.AddCategoryimgclick();
		
	  }
  
  @Test(priority=3,enabled=true)
  public void AddCategory() throws InterruptedException {
	  addCategoryPOM.sendcourse_category_code("BL1");
	  addCategoryPOM.sendcourse_category_name("Blended Learning1");
	 // addCategoryPOM.addingcoursesinthiscategoryradioBtn();
	  jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	  Thread.sleep(2000);
	  addCategoryPOM.course_category_submitBtn();
	 Thread.sleep(2000);
	 	   }
  
  @Test(priority=4)//Step 7 Added Category should get displayed in Courses categories
  public void NemeofAddedCategoryDisplayedinCoursescategories() {
  Actual=addCategoryPOM.NemeofAddedCategoryDisplayed();
  Expected="Blended Learning1";
  assertEquals(Actual,Expected);
  }
  @Test(priority=5,enabled=true)
  public void ClickAdministrationLink() throws InterruptedException {
	addCategoryPOM.AdministrationLinkClick();
	Thread.sleep(2000);

  }
  
  @Test(priority=6,enabled=true)
  public void CreateaCourseLink() throws InterruptedException {
	administrationPOM.clickcreateaCoursesLink();
	Thread.sleep(3000);
 }
  @Test(priority=7,enabled=true)//step 9 validated Add a new course page should get displayed
  public void DisplayCreateACoursepage() throws InterruptedException {
	  createACoursePOM.DisplayCreate_a_course_title_alertmsg();
	  Actual=createACoursePOM.DisplayCreate_a_course_title_alertmsg();
	  Expected="Create a course";
	  boolean createaCourse=Actual.contains(Expected);
	  assertTrue(createaCourse);
	  Thread.sleep(3000);
	 }
  
  @Test(priority=8,enabled=true)
  public void CreateCourseHomePage() throws InterruptedException
  {
	  createACoursePOM.sendcourseTitle("Phython1"); //everytime need to change
	  createACoursePOM.sendvisual_code("Phython1");
	  createACoursePOM.selectcourse_teachers("satyaTec1 kumariTec1");
	 // Thread.sleep(2000);
	  createACoursePOM.selectpicker_show_tick_form_control("(BL) Blended Learning"); //everytime need to change selection if we change course
	  Thread.sleep(2000);
	  createACoursePOM.update_course_language("English");
	  createACoursePOM.clickCreateaCourseBtn();
  }
 
  @Test(priority=9,enabled=true)//perform search on course list page
  public void DisplayCourseinCourseListAfterCreatedCourse() throws InterruptedException {
	  courseListPOM.sendsearch_courseitem("Phython1");//everytime need to change if want to change course
	  courseListPOM.clicksearch_simple_submitBtn();
	Thread.sleep(3000);  
  }
  @Test(priority=10,dependsOnMethods= {"DisplayCourseinCourseListAfterCreatedCourse"},enabled=true)//Step 15 added course should be visible
  public void DisplayAfterSearchedinList() {//check added item in courselist
	  
	  Actual=courseListPOM.Displaysearch_itemmatch();
	  Expected="Phython1";//everytime need to change
	  boolean checkcourseinlist=Actual.contains(Expected);
	  assertTrue(checkcourseinlist);
  }
   
  @BeforeClass
  public static void setUpBeforeClass() throws IOException {
	    properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		jse=((JavascriptExecutor) driver);
		administrationPOM=  new AdministrationPOM(driver);
		addCategoryPOM=new AddCategoryPOM(driver);
		createACoursePOM=new CreateACoursePOM(driver);
		courseListPOM=new CourseListPOM(driver);
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
