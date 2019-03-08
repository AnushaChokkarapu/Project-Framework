package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegisterUserToCourse {

private WebDriver driver; 
	
	public RegisterUserToCourse(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	// Login page
	@FindBy(id="login")
	private WebElement userName; 
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="formLogin_submitAuth")
	private WebElement loginBtn; 
	
	// Navigating to Admin page
	@FindBy(xpath="//*[@id=\"menuone\"]/ul[1]/li[7]/a")
	private WebElement adminLink;
	
	// Click on Add User Link
	@FindBy(xpath="//*[@id=\"tabs-1\"]/div/div[2]/div[2]/ul/li[2]/a")
	private WebElement addUserLink;
	
	// Enter all relevant details
	@FindBy(name="firstname")
	private WebElement firstName;
	
	@FindBy(name="lastname")
	private WebElement lastName;
	
	@FindBy(name="email")
	private WebElement email;
	
	@FindBy(name="phone")
	private WebElement phone;
	
	@FindBy(name="username")
	private WebElement username1;
	
	@FindBy(name="password[password_auto]")
	private WebElement passwordRadio;
	
	@FindBy(name="password[password]")
	private WebElement password1;
	
	@FindBy(xpath="//*[@id=\"user_add\"]/fieldset/div[11]/div[1]/div/button/span[1]")
	private WebElement profile;
	
	@FindBy(xpath="//*[@id=\"user_add\"]/fieldset/div[11]/div[1]/div/div/ul/li[1]/a/span[1]")
	private WebElement trainer;
	
	//Click on Submit
	@FindBy(name="submit")
	private WebElement submit;
	
	// Select the users
	@FindBy(xpath="//*[@id=\"tabs-2\"]/div/div[2]/div[2]/ul/li[6]/a")
	private WebElement addUsers;
	
	// Select the Courses
	@FindBy(xpath="//*[@id=\"content-section\"]/div/form[2]/table/tbody/tr[2]/td[2]/button")
	private WebElement addCourses;
	
	@FindBy(xpath="//*[@id=\"content-section\"]/div/div[3]")
	private WebElement assert1;
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
	public void clickAdminLink() {
		this.adminLink.click(); 
    }
	
	public void clickAddUserLink() {
		this.addUserLink.click(); 
    }
	
	public void sendFirstName(String firstName) {
		this.firstName.clear();
		this.firstName.sendKeys(firstName);
	}
	
	public void sendLastName(String lastName) {
		this.lastName.clear();
		this.lastName.sendKeys(lastName);
	}
	
	public void sendEmail(String email) {
		this.email.clear();
		this.email.sendKeys(email);
	}
	
	public void sendPhone(String phone) {
		this.phone.clear();
		this.phone.sendKeys(phone);
	}
	
	public void sendUserName1(String userName) {
		this.username1.clear();
		this.username1.sendKeys(userName);
	}
	
	public void clickPasswordRadio() {
		this.passwordRadio.click(); 
    }
	
	public void sendPassword1(String password) {
		this.password1.clear(); 
		this.password1.sendKeys(password); 
	}
	
	public void clickProfile() {
		this.profile.click(); 
		this.trainer.click();
    }
	
	public void clickSubmit() {
		this.submit.click(); 
    }

	public void clickAddUsersLink() {
		this.addUsers.click(); 
    }
	
	public void clickUsers(String user) {
		Select userSelect = new Select(driver.findElement(By.xpath("//*[@id=\"content-section\"]/div/form[2]/table/tbody/tr[2]/td[1]/select")));
        if(userSelect.isMultiple()) {
        	userSelect.selectByVisibleText(user);
        }
    }
	
	public void clickCourses(String course) {
		Select courseSelect = new Select(driver.findElement(By.xpath("//*[@id=\"content-section\"]/div/form[2]/table/tbody/tr[2]/td[3]/select")));
        if(courseSelect.isMultiple()) {
        	courseSelect.selectByVisibleText(course);
        }
    }
	
	public void clickAddToCourses() {
		this.addCourses.click(); 
    }
	
	public String Assertion()
	{
		return this.assert1.getText();
	}
}
