package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminUserEdit {

private WebDriver driver; 
	
	public AdminUserEdit(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	//Login page
	@FindBy(id="login")
	private WebElement userName; 
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="formLogin_submitAuth")
	private WebElement loginBtn; 
	
	//Navigating to Admin page
	@FindBy(xpath="//*[@id=\"menuone\"]/ul[1]/li[7]/a")
	private WebElement adminLink;
	
	//Click on User list link
	@FindBy(xpath="//*[@id=\"tabs-1\"]/div/div[2]/div[2]/ul/li[1]/a")
	private WebElement userListLink;
	
	//Click on Edit user link
	@FindBy(xpath="/html[1]/body[1]/div[1]/section[1]/div[1]/div[2]/div[1]/section[1]/div[1]/form[1]/table[1]/tbody[1]/tr[2]/td[11]/a[5]/img[1]")
	private WebElement editUserLink;
	
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
	
	public void clickUserListLink() {
		this.userListLink.click(); 
	}
	
	public void clickEditUserLink() {
		this.editUserLink.click(); 
	}
}
