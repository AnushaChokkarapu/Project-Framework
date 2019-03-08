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
import com.training.pom.RegisterTeacherDB;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RegisterTeacherDBTest {

	private WebDriver driver;
	private String baseUrl;
	private RegisterTeacherDB registerTeacherDB;
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
		registerTeacherDB = new RegisterTeacherDB(driver); 
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
	@Test(dataProvider="db-inputs", dataProviderClass = LoginDataProviders.class)
	public void validRegistrationTest(String firstName, String lastName, String email, String userName, String password, String confirmPassword, String phone ) {
		// Click on SignUp link
		registerTeacherDB.signUp();
		// Enter all relevant details
		String firstname = registerTeacherDB.sendFirstName("manzoor9");
		String lastname = registerTeacherDB.sendLastName("mehadi");
		String Email = registerTeacherDB.sendEmail("manzoor9@gmail.com");
		String username = registerTeacherDB.sendUserName("manzoor9");
		String Password = registerTeacherDB.sendPassword("manzoor");
		String ConfirmPassword = registerTeacherDB.sendPassword1("manzoor");
		String Phone = registerTeacherDB.sendPhone("9535318611");
		registerTeacherDB.selectLanguage();
		registerTeacherDB.clickTeacher();
		// Click on Submit
		registerTeacherDB.clickSubmit();	
		
		// Assertion
		Assert.assertEquals(firstname, firstName);
		Assert.assertEquals(lastname, lastName);
		Assert.assertEquals(Email, email);
		Assert.assertEquals(username, userName);
		Assert.assertEquals(Password, password);
		Assert.assertEquals(ConfirmPassword, confirmPassword);
		Assert.assertEquals(Phone, phone);
		screenShot.captureScreenShot("TC078");
	}

}
