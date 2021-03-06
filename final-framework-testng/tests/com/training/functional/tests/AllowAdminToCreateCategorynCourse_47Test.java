package com.training.functional.tests;

import org.testng.annotations.Test;
import com.training.generics.ScreenShot;
import com.training.pom.AddCategoryPOM;
import com.training.pom.AdministrationPOM;
import com.training.pom.CourseListPOM;
import com.training.pom.CreateACoursePOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
/* Author : Satya Kumari
 * TC ID  : ELTC_047
 * TC Description :TO verify whether application allows admin to create a category & course on the category
 * Pre-condition : 1. User should have launched the application

                   2. User should get logged in as admin
 */

public class AllowAdminToCreateCategorynCourse_47Test {
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
			//Thread.sleep(2000);
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
			//Thread.sleep(2000);
		  addCategoryPOM.AddCategoryimgclick();
			
		  }
	@Test(priority=3,enabled=true)
	  public void AddCategory() throws InterruptedException {
		  addCategoryPOM.sendcourse_category_code("BL1");//every time need to change the course
		 // Thread.sleep(1000);
		  addCategoryPOM.sendcourse_category_name("Blended Learning2");
		 addCategoryPOM.addingcoursesinthiscategoryradioBtn();
		 
		 	   }
	
	@Test(priority=4,enabled=true)
	public void CreatedCategorySubmit() throws InterruptedException {
		 jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		  //Thread.sleep(2000);
		  addCategoryPOM.course_category_submitBtn();
		 //Thread.sleep(2000);
		
	}
	@Test(priority=5,enabled=true)
	  public void ClickAdministrationLinkthenCourseCategoryLink() throws InterruptedException {
		addCategoryPOM.AdministrationLinkClick();
		administrationPOM.clickCoursescategoriesLink();
		//Thread.sleep(4000);

	  }
	@Test(priority=6,enabled=true)//Step 7 Added Category should get displayed in Courses categories
	  public void NemeofAddedCategoryDisplayedinCoursescategories() {
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	  Actual=addCategoryPOM.NemeofAddedCategoryDisplayed();
	  Expected="Blended Learning2";
	  boolean categorymatch=Actual.contains(Expected);
	  assertTrue(categorymatch);
	  //assertEquals(Actual,Expected);
	  }
	@Test(priority=7,enabled=true)
	  public void ClickAdministrationLink() throws InterruptedException {
		addCategoryPOM.AdministrationLinkClick();
		//Thread.sleep(2000);

	  }
	  
	  @Test(priority=8,enabled=true)
	  public void CreateaCourseLink() throws InterruptedException {
		administrationPOM.clickcreateaCoursesLink();
		//Thread.sleep(3000);
	 }
	  @Test(priority=9,enabled=true)//step 9 validated Add a new course page should get displayed
	  public void DisplayCreateACoursepage() throws InterruptedException {
		  createACoursePOM.DisplayCreate_a_course_title_alertmsg();
		  Actual=createACoursePOM.DisplayCreate_a_course_title_alertmsg();
		  Expected="Create a course";
		  boolean createaCourse=Actual.contains(Expected);
		  assertTrue(createaCourse);
		  //Thread.sleep(3000);
		 }
	  
	  @Test(priority=10,enabled=true)
	  public void CreateCourseHomePage() throws InterruptedException
	  {
		  createACoursePOM.sendcourseTitle("Phython2"); //everytime need to change
		  createACoursePOM.sendvisual_code("Phython2");
		  createACoursePOM.selectcourse_teachers("satyaTec1 kumariTec1");
		 
		  createACoursePOM.selectCategoryFromList("(BL) Blended Learning"); //everytime need to change selection if we change course
		  createACoursePOM.update_course_language("English");
		  createACoursePOM.clickCreateaCourseBtn();
	  }
	 
	  @Test(priority=11,enabled=true)//perform search on course list page
	  public void DisplayCourseinCourseListAfterCreatedCourse() throws InterruptedException {
		  courseListPOM.sendsearch_courseitem("Phython2");//everytime need to change if want to change course
		  courseListPOM.clicksearch_simple_submitBtn();
		//Thread.sleep(3000);  
	  }
	  @Test(priority=12,dependsOnMethods= {"DisplayCourseinCourseListAfterCreatedCourse"},enabled=true)//Step 15 added course should be visible
	  public void DisplayAfterSearchedinList() {//check added item in courselist
		  
		  Actual=courseListPOM.Displaysearch_itemmatch();
		  Expected="Phython2";//everytime need to change
		  boolean checkcourseinlist=Actual.contains(Expected);
		  assertTrue(checkcourseinlist);
	  }
	   

  
  @BeforeClass
  public static void setUpBeforeClass() throws IOException {
	    properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
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
		//Thread.sleep(3000);
		driver.quit();
	}


}
