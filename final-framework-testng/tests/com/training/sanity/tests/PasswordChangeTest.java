package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AdminPasswordChange;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class PasswordChangeTest {

	private WebDriver driver;
	private String baseUrl;
	private AdminPasswordChange adminPasswordChange;
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
		adminPasswordChange = new AdminPasswordChange(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		// Login page
		adminPasswordChange.sendUserName("admin");
		adminPasswordChange.sendPassword("admin@123");
		adminPasswordChange.clickLoginBtn(); 
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.quit();
	}
				
	@Test
	public void validEditTest() {
		
		// To verify whether application allows admin to change the password in Edit Profile page
		adminPasswordChange.clickHomePage();
		
		// Edit profile page
		adminPasswordChange.clickEditProfile();
		adminPasswordChange.sendPassword0("admin@123");
		adminPasswordChange.sendPassword1("admin@1234");
		adminPasswordChange.sendPassword2("admin@1234");
		adminPasswordChange.saveChanges();
		// Assertion
		String Actual = adminPasswordChange.Assertion();;
		String Expected = "Your new profile has been saved";
		assertEquals(Actual, Expected);
		screenShot.captureScreenShot("TC018");
	}


}
