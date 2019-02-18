package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPasswordChange {

private WebDriver driver; 
	
	public AdminPasswordChange(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="login")
	private WebElement userName; 
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="formLogin_submitAuth")
	private WebElement loginBtn; 
	
	@FindBy(xpath="//*[@id=\"menuone\"]/ul[1]/li[1]/a")
	private WebElement homePage;
	
	@FindBy(xpath="//*[@id=\"profileCollapse\"]/div/ul/li[4]/a")
	private WebElement editProfile;
	
	@FindBy(id="profile_password0")
	private WebElement password0;
	
	@FindBy(id="password1")
	private WebElement password1;
	
	@FindBy(id="profile_password2")
	private WebElement password2;
	
	@FindBy(id="profile_apply_change")
	private WebElement save;
	
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
	
	public void clickHomePage() {
		this.homePage.click();
		
	}
	
	public void clickEditProfile() {
		this.editProfile.click();
		
	}
	
	public void sendPassword0(String password) {
		this.password0.clear(); 
		this.password0.sendKeys(password); 
	}
	
	public void sendPassword1(String password) {
		this.password1.clear(); 
		this.password1.sendKeys(password); 
	}
	
	public void sendPassword2(String password) {
		this.password2.clear(); 
		this.password2.sendKeys(password); 
	}
	
	public void saveChanges() {
		this.save.click();
	}
}
