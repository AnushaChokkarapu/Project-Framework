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
import com.training.pom.StudentTaskComment;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class StudentTaskCommentTest {

	private WebDriver driver;
	private String baseUrl;
	private StudentTaskComment studentTaskComment;
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
		studentTaskComment = new StudentTaskComment(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		// Login page
		studentTaskComment.sendUserName("vamshi");
		studentTaskComment.sendPassword("123456");
		studentTaskComment.clickLoginBtn();
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.quit();
	}
				
	@Test
	public void validStudentTaskTest() throws Exception {
		
		// To verify whether application allows student to comment on the task assigned in the project
		System.out.println(driver.getTitle());
		// Adding a comment for the assigned task 
		studentTaskComment.clickCourseLink();
		studentTaskComment.clickProjectLink();
		studentTaskComment.clickMyTaskLink();
		studentTaskComment.clickHomeIcon();
		studentTaskComment.clickTaskNameLink();
		studentTaskComment.sendTitle("Hello5");
		studentTaskComment.clickSave();
		// Assertion
		String Actual = studentTaskComment.Assertion();;
		String Expected = "You comment has been added";
		assertEquals(Actual, Expected);
		screenShot.captureScreenShot("TC046");
	}

}
