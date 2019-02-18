package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminAddUser {

	private WebDriver driver; 
		
		public AdminAddUser(WebDriver driver) {
			this.driver = driver; 
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(id="login")
		private WebElement userName; 
		
		@FindBy(id="password")
		private WebElement password;
		
		@FindBy(id="formLogin_submitAuth")
		private WebElement loginBtn; 
		
		@FindBy(xpath="//*[@id=\"menuone\"]/ul[1]/li[7]/a")
		private WebElement adminLink;
		
		@FindBy(xpath="//*[@id=\"tabs-1\"]/div/div[2]/div[2]/ul/li[2]/a")
		private WebElement addUserLink;
		
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
		
		@FindBy(name="submit")
		private WebElement submit;
		
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
}
