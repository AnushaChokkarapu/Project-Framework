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
import com.training.pom.AdminCreateSession;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AdminCreateSessionTest {

	private WebDriver driver;
	private String baseUrl;
	private AdminCreateSession adminCreateSession;
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
		adminCreateSession = new AdminCreateSession(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		
		//login page
		adminCreateSession.sendUserName("admin");
		adminCreateSession.sendPassword("admin@1234");
		adminCreateSession.clickLoginBtn();
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void validCreateSessionTest() {
		adminCreateSession.clickAdminLink();
		
		// Creating a new session
		adminCreateSession.clickAddSessionLink();
		adminCreateSession.sendSessionName("Fifth");
		adminCreateSession.coachName();
		adminCreateSession.clickSessionSubmit();
		adminCreateSession.clickCourses("Selenium_123 (AA)");
		adminCreateSession.clickButton();
		adminCreateSession.clickNextStep();
		adminCreateSession.sendUserAdd("vamshi");
		adminCreateSession.clickSelectUser();
		adminCreateSession.clickFinishSession();
		
		// Assertion
		String Actual = driver.findElement(By.xpath("//*[@id=\"session-user-list\"]/tbody/tr[2]/td[1]/a")).getText();
	    String Expected = "Vamshi Krishna (vamshi)";
		Assert.assertTrue(Actual.contains(Expected));
		screenShot.captureScreenShot("TC050");
	}

}
