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
import com.training.pom.StudentAssessment;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class StudentAssessmentTest {

	private WebDriver driver;
	private String baseUrl;
	private StudentAssessment studentAssessment;
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
		studentAssessment = new StudentAssessment(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		// Login page
		studentAssessment.sendUserName("teacher12");
		studentAssessment.sendPassword("123456");
		studentAssessment.clickLoginBtn(); 
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.quit();
	}
				
	@Test
	public void validEditTest() {
		
		// To verify whether application allows teacher to author course with assessment, 
		// students register the course complete assessment & teacher review Assessment history
		studentAssessment.clickCourse();
		studentAssessment.clickAssessment();
		studentAssessment.clickAddOnlineActivity();
		studentAssessment.clickActivity();
		studentAssessment.sendWeight("1");
		studentAssessment.clickAddLearning();
		studentAssessment.clickEdit();
		studentAssessment.clickEditLink();
		studentAssessment.clickAttachCertificate();
		studentAssessment.clickDrpDown();
		studentAssessment.sendUserName("honey4");
		studentAssessment.sendPassword("123456");
		studentAssessment.clickLoginBtn(); 
		studentAssessment.clickCourseCatalog();
		studentAssessment.sendCourseName("selenium_test_1");
		studentAssessment.clickSearch();
		studentAssessment.clickSubscribe();
		studentAssessment.clickCourseName();
		studentAssessment.clickAssessment1();
		studentAssessment.clickTestName();
		studentAssessment.clickStartTest();
		studentAssessment.clickAnswer();
		studentAssessment.clickEndTest();
		studentAssessment.clickDrpDown();
		studentAssessment.sendUserName("teacher12");
		studentAssessment.sendPassword("123456");
		studentAssessment.clickLoginBtn(); 
		studentAssessment.clickCourse();
		studentAssessment.clickAssessment();
		studentAssessment.clickAssessmentHistory();
		
		
		// Assertion
		String Actual = studentAssessment.Assertion();
		String Expected = "Assessment history";
		assertEquals(Actual, Expected);
		screenShot.captureScreenShot("TC079"); 
	}

}
