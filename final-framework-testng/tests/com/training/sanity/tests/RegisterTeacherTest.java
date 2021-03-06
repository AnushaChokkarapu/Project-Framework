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

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.RegisterTeacher;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RegisterTeacherTest {

	private WebDriver driver;
	private String baseUrl;
	private RegisterTeacher registerTeacher;
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
		registerTeacher = new RegisterTeacher(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.quit();
	}
	@Test(dataProvider="excel-inputs", dataProviderClass = LoginDataProviders.class)
	public void validRegistrationTest(String firstName, String lastName, String email, String userName, String password, String password1, String phone ) {
		// TO verify whether application allows multiple user to get registered as Teacher
		// Click on SignUp link
		registerTeacher.signUp();
		// Enter all relevant details
		registerTeacher.sendFirstName(firstName);
		registerTeacher.sendLastName(lastName);
		registerTeacher.sendEmail(email);
		registerTeacher.sendUserName(userName);
		registerTeacher.sendPassword(password);
		registerTeacher.sendPassword1(password1);
		registerTeacher.sendPhone(phone);
		registerTeacher.selectLanguage();
		registerTeacher.clickTeacher();
		// Click on Submit
		registerTeacher.clickSubmit();	
		
		// Assertion
		String Actual = registerTeacher.Assertion();;
	    String Expected = "Your personal settings have been registered.";
		Assert.assertTrue(Actual.contains(Expected));
		screenShot.captureScreenShot("TC076");
	}

}
