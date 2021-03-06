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
import com.training.pom.LoginAdmin;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LoginAdminTest {

	private WebDriver driver;
	private String baseUrl;
	private LoginAdmin loginAdmin;
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
		loginAdmin = new LoginAdmin(driver); 
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
	public void validLoginTest() {
		
		// To verify whether application allows admin to get login into application
		// Login page
		System.out.println("Login Page Title is:"+driver.getTitle());
		loginAdmin.sendUserName("admin");
		loginAdmin.sendPassword("admin@1234");
		loginAdmin.clickLoginBtn(); 
		// Assertion
		String Actual = driver.getTitle();
		String Expected = "eLearning - eLearning";
		assertEquals(Actual, Expected);
		screenShot.captureScreenShot("TC017");
	}
}
