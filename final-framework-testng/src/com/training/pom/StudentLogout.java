package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StudentLogout {

	private WebDriver driver; 
		
		public StudentLogout(WebDriver driver) {
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
		
		// User clicks on the drop down
		@FindBy(xpath="//*[@id=\"menuone\"]/ul[2]/li[2]/a")
		private WebElement drpDown;
		
		// Click on logout
		@FindBy(xpath="//*[@id=\"logout_button\"]")
		private WebElement logout;
		
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
		
		public void clickDrpDown() {
			this.drpDown.click(); 
		}
		
		public void clickLogout() {
			this.logout.click(); 
		}
}
