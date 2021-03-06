package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.StudentLogout;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class StudentLogoutTest {

	private WebDriver driver;
	private String baseUrl;
	private StudentLogout studentLogout;
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
		studentLogout = new StudentLogout(driver); 
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
				
	@Test
	public void validLogoutTest() {
		// To verify whether application allows teacher to get log out from the application
		// Login page
		System.out.println(driver.getTitle());
		studentLogout.sendUserName("vamshi");
		studentLogout.sendPassword("123456");
		studentLogout.clickLoginBtn(); 
		studentLogout.clickDrpDown();
		studentLogout.clickLogout();
		
		// Assertion
		String Actual = driver.getTitle();
		String Expected = "eLearning - eLearning";
		assertEquals(Actual, Expected);
		screenShot.captureScreenShot("TC016");
	}



}
