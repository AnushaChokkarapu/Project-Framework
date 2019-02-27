package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AdminAddClass;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AdminAddClassTest {

	private WebDriver driver;
	private String baseUrl;
	private AdminAddClass adminAddClass;
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
		adminAddClass = new AdminAddClass(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		
		// Login page
		adminAddClass.sendUserName("admin");
		adminAddClass.sendPassword("admin@1234");
		adminAddClass.clickLoginBtn();
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void validAddClassTest() {
		adminAddClass.clickAdminLink();
		adminAddClass.clickClassesLink();
		adminAddClass.clickAddClassesLink();
		
		// Creating a new class
		adminAddClass.sendClassName("class4");
		adminAddClass.sendClassDescription("demo");
		adminAddClass.clickGroupPermissions();
		adminAddClass.clickSubmit();
		
		// Subscribing user to class
		adminAddClass.clickSubscribeUser();
		adminAddClass.clickUsers("Anu Ch (anu)");
		adminAddClass.clickArrowButton();
		adminAddClass.clickSubscribeUserToClass();
		
		// Capturing the course count before subscribing
		WebElement actmsg=driver.findElement(By.xpath("//table//tbody//tr//td[@title='class4']//following-sibling::td[2]"));
		String  actmsgval = actmsg.getText();
		int num1 = Integer.parseInt(actmsgval);
        System.out.println("value is " +actmsgval);
        
        // Subscribing class to course
		adminAddClass.clickSubscribeCourse();
		adminAddClass.clickCourses("Selenium_123 (AA)");
		adminAddClass.clickArrowButton1();
		adminAddClass.clickSubscribeClassToCourses();
		
		// Capturing the course count before subscribing
		WebElement expmsg=driver.findElement(By.xpath("//table//tbody//tr//td[@title='class4']//following-sibling::td[2]"));
		String expmsgval = expmsg.getText();
		int num2 = Integer.parseInt(expmsgval);
        System.out.println("value is " +expmsgval);
        // Assertion
        Assert.assertTrue (num1 < num2);
		screenShot.captureScreenShot("TC049");
	}


}
