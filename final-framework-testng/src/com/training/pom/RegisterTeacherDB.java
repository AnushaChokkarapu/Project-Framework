package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterTeacherDB {

private WebDriver driver; 
	
	public RegisterTeacherDB(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	//Login page
	@FindBy(xpath="//*[@id=\"login_block\"]/div/ul/li[1]/a")
	private WebElement signUp; 
	
	//Navigates to Registration page and enter all the relevant details
	@FindBy(name="firstname")
	private WebElement firstName;
	
	@FindBy(name="lastname")
	private WebElement lastName;
	
	@FindBy(name="email")
	private WebElement email;
	
	@FindBy(name="username")
	private WebElement username;
	
	@FindBy(name="pass1")
	private WebElement password;
	
	@FindBy(name="pass2")
	private WebElement password1;
	
	@FindBy(name="phone")
	private WebElement phone;
	
	@FindBy(xpath="//*[@id=\"registration\"]/fieldset/div[10]/div[1]/div/button/span[1]")
	private WebElement language;
	
	@FindBy(xpath="//*[@id=\"registration\"]/fieldset/div[10]/div[1]/div/div/ul/li[6]/a/span[1]")
	private WebElement english;
		
	@FindBy(xpath="//*[@id=\"registration\"]/fieldset/div[12]/div[1]/div/label")
	private WebElement teacher;
	
	// Click on Submit 
	@FindBy(name="submit")
	private WebElement submit;
	
	public void signUp() {
		this.signUp.click();
	}
	
	public String sendFirstName(String firstName) {
		this.firstName.clear();
		this.firstName.sendKeys(firstName);
		return this.firstName.getAttribute("value");
	}
	
	public String sendLastName(String lastName) {
		this.lastName.clear();
		this.lastName.sendKeys(lastName);
		return this.lastName.getAttribute("value");
	}
	
	public String sendEmail(String email) {
		this.email.clear();
		this.email.sendKeys(email);
		return this.email.getAttribute("value");
	}
	
	public String sendUserName(String userName) {
		this.username.clear();
		this.username.sendKeys(userName);
		return this.username.getAttribute("value");
	}
	
	public String sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
		return this.password.getAttribute("value");
	}
	
	public String sendPassword1(String password) {
		this.password1.clear(); 
		this.password1.sendKeys(password); 
		return this.password1.getAttribute("value");
	}
	
	public String sendPhone(String phone) {
		this.phone.clear();
		this.phone.sendKeys(phone);
		return this.phone.getAttribute("value");
	}
	
	public String selectLanguage() {
		this.language.click(); 
		this.english.click();
		return this.english.getAttribute("value");
    }
	
	public void clickTeacher() {
		this.teacher.click(); 
    }
	
	public void clickSubmit() {
		this.submit.click(); 
    }


}
