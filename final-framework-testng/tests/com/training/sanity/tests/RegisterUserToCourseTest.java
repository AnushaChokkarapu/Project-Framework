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
import com.training.pom.RegisterUserToCourse;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RegisterUserToCourseTest {

	private WebDriver driver;
	private String baseUrl;
	private RegisterUserToCourse registerUserToCourse;
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
		registerUserToCourse = new RegisterUserToCourse(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		// Login page
		registerUserToCourse.sendUserName("admin");
		registerUserToCourse.sendPassword("admin@1234");
		registerUserToCourse.clickLoginBtn();
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void validRegisterUserTest() {
		registerUserToCourse.clickAdminLink();
		// Adding a new user
		registerUserToCourse.clickAddUserLink();
		registerUserToCourse.sendFirstName("Honey8");
		registerUserToCourse.sendLastName("G");
		registerUserToCourse.sendEmail("honey8.g@gmail.com");
		registerUserToCourse.sendPhone("9878765123");
		registerUserToCourse.sendUserName1("honey8");
		registerUserToCourse.clickPasswordRadio();
		registerUserToCourse.sendPassword1("123456");
		registerUserToCourse.clickProfile();
		registerUserToCourse.clickSubmit();	
		registerUserToCourse.clickAdminLink();
		registerUserToCourse.clickAddUsersLink();
		
		// Subscribing user to course
		registerUserToCourse.clickUsers("G Honey8 (honey8)");
		registerUserToCourse.clickCourses("(AA) Selenium_123");
		registerUserToCourse.clickAddToCourses();
		// Assertion
		String Actual = driver.findElement(By.xpath("//*[@id=\"content-section\"]/div/div[3]")).getText();
	    String Expected = "The selected users are subscribed to the selected course";
		Assert.assertTrue(Actual.contains(Expected));
		screenShot.captureScreenShot("TC048");
	}


}
