package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.CreateCategory;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CreateCategoryTest {

	private WebDriver driver;
	private String baseUrl;
	private CreateCategory createCategory;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		createCategory = new CreateCategory(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		// login page
		createCategory.sendUserName("admin");
		createCategory.sendPassword("admin@1234");
		createCategory.clickLoginBtn();
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.quit();
	}
	@Test
	public void validAddUserTest() {
		
		// TO verify whether application allows admin to create a category & course on the category
		createCategory.clickAdminLink();
		createCategory.clickCoursesCategoryLink();
		
		// Creating a new category
		createCategory.clickAddCategoryLink();
		createCategory.sendCategoryCode("11");
		createCategory.sendCategoryName("Category3");
		createCategory.clickYesRadio();
		createCategory.clickCategorySubmit();
		createCategory.clickAdminLink();
		
		// creating a new course
		createCategory.clickCreateCourseLink();
		createCategory.sendCourseTitle("Selenium_121");
		createCategory.sendCode("ABD");
		createCategory.clickTeacherDrpDown();
		createCategory.clickCategoryDrpDown();
		createCategory.clickLanguageDrpDown();
		createCategory.clickSubmitLink();
		
		//Assertion
		String Actual = createCategory.Assertion();;
	    String Expected = "Course Selenium_121 added";
		Assert.assertTrue(Actual.contains(Expected));
		screenShot.captureScreenShot("TC047");
     }
}
