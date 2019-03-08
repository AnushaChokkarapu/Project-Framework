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
import com.training.pom.AdminUserEdit;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AdminUserEditTest {

	private WebDriver driver;
	private String baseUrl;
	private AdminUserEdit adminUserEdit;
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
		adminUserEdit = new AdminUserEdit(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		
		// Login page
		adminUserEdit.sendUserName("admin");
		adminUserEdit.sendPassword("admin@1234");
		adminUserEdit.clickLoginBtn(); 
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.quit();
	}
				
	@Test
	public void validEditTest() {
		
		// TO verify whether application allows admin to view details of user
		adminUserEdit.clickAdminLink();
		adminUserEdit.clickUserListLink();
		adminUserEdit.clickEditUserLink();
		
		// Assertion
		String Actual = adminUserEdit.Assertion();
		String Expected = "Hari";
		assertEquals(Actual, Expected);
		screenShot.captureScreenShot("TC019");
	}

}
