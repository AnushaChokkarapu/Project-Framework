package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

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
		
		createCategory.sendUserName("admin");
		createCategory.sendPassword("admin@1234");
		createCategory.clickLoginBtn();
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void validAddUserTest() {
		createCategory.clickAdminLink();
		createCategory.clickCoursesCategoryLink();
		createCategory.clickAddCategoryLink();
		createCategory.sendCategoryCode("11");
		createCategory.sendCategoryName("Category3");
		createCategory.clickYesRadio();
		createCategory.clickCategorySubmit();
		createCategory.clickAdminLink();
		createCategory.clickCreateCourseLink();
		createCategory.sendCourseTitle("Selenium_121");
		createCategory.sendCode("ABD");
		createCategory.clickTeacherDrpDown();
		createCategory.clickCategoryDrpDown();
		createCategory.clickLanguageDrpDown();
		createCategory.clickSubmitLink();
		
		String Actual = driver.findElement(By.xpath("//*[@id=\"content-section\"]/div/div[2]/div/div[2]")).getText();
	    String Expected = "Course Selenium_121 added";
		Assert.assertTrue(Actual.contains(Expected));
		screenShot.captureScreenShot("TC047");
     }
}
