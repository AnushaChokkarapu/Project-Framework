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
import com.training.pom.AdminAddUser;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AdminAddUserTest {

	private WebDriver driver;
	private String baseUrl;
	private AdminAddUser adminAddUser;
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
		adminAddUser = new AdminAddUser(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		
		// Login page
		adminAddUser.sendUserName("admin");
		adminAddUser.sendPassword("admin@1234");
		adminAddUser.clickLoginBtn();
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.quit();
	}
	@Test
	public void validAddUserTest() {
		// To verify whether application allows admin to add new user as a trainer 
		// by entering valid credentials in mandatory fields only
		adminAddUser.clickAdminLink();
		// Adding a new user
		adminAddUser.clickAddUserLink();
		adminAddUser.sendFirstName("Honey5");
		adminAddUser.sendLastName("G");
		adminAddUser.sendEmail("honey5.g@gmail.com");
		adminAddUser.sendPhone("9878765765");
		adminAddUser.sendUserName1("honey5");
		adminAddUser.clickPasswordRadio();
		adminAddUser.sendPassword1("123456");
		adminAddUser.clickProfile();
		adminAddUser.clickSubmit();	
		
		// Assertion
		String Actual = adminAddUser.Assertion();
	    String Expected = "The user has been added:";
		Assert.assertTrue(Actual.contains(Expected));
		screenShot.captureScreenShot("TC020");
	}

}
