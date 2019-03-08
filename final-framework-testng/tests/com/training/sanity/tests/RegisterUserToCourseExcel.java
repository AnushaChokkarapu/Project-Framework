package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.RegisterUserToCourse;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RegisterUserToCourseExcel {

	private WebDriver driver;
	private String baseUrl;
	private RegisterUserToCourse registerUserToCourse;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		
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

	@AfterClass
	public void tearDown() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.quit();
	}
	
	@Test(dataProvider="excel-inputs2", dataProviderClass = LoginDataProviders.class)
	public void validRegisterUserTest(String firstName, String lastName, String email, String phone, String userName, String password) {
		
		// TO verify whether application allows admin to create multiple user & register users to the course
		registerUserToCourse.clickAdminLink();
		// Adding a new user
		registerUserToCourse.clickAddUserLink();
		registerUserToCourse.sendFirstName(firstName);
		registerUserToCourse.sendLastName(lastName);
		registerUserToCourse.sendEmail(email);
		registerUserToCourse.sendPhone(phone);
		registerUserToCourse.sendUserName1(userName);
		registerUserToCourse.clickPasswordRadio();
		registerUserToCourse.sendPassword1(password);
		registerUserToCourse.clickProfile();
		registerUserToCourse.clickSubmit();	
		registerUserToCourse.clickAdminLink();
		registerUserToCourse.clickAddUsersLink();
		
		// Capturing the user details in a String value
		String user=lastName+" "+firstName+" ("+userName+")";
		System.out.println(user);
		// Subscribing user to course
		registerUserToCourse.clickUsers(user);
		registerUserToCourse.clickCourses("(SELENIUMTEST1) selenium_test_1");
		registerUserToCourse.clickAddToCourses();
		// Assertion
		String Actual = registerUserToCourse.Assertion();
	    String Expected = "The selected users are subscribed to the selected course";
		Assert.assertTrue(Actual.contains(Expected));
		screenShot.captureScreenShot("TC080");
	}



}
