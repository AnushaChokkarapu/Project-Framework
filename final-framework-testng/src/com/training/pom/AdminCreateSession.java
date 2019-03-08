package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminCreateSession {

	private WebDriver driver; 
	
	public AdminCreateSession(WebDriver driver) {
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
	
	//Navigating to admin page
	@FindBy(xpath="//*[@id=\"menuone\"]/ul[1]/li[7]/a")
	private WebElement adminLink;
	
	//click on Add Session Link
	@FindBy(xpath="//*[@id=\"tabs-4\"]/div/div[2]/div[2]/ul/li[2]/a")
	private WebElement addSession;
	
	//Enter all relevant details
	@FindBy(id="add_session_name")
	private WebElement sessionName;
	
	@FindBy(xpath="//*[@id=\"add_session\"]/fieldset/div[2]/div[1]/div/button")
	private WebElement coachName;
	
	@FindBy(xpath="//*[@id=\"add_session\"]/fieldset/div[2]/div[1]/div/div/ul/li[1]/a/span[1]")
	private WebElement coachName1;
	
	@FindBy(id="add_session_submit")
	private WebElement sessionSubmit;
	
	@FindBy(xpath="//*[@id=\"multiple-add-session\"]/div[2]/div[2]/div[1]/button")
	private WebElement button;
	
	@FindBy(xpath="//*[@id=\"multiple-add-session\"]/div[2]/div[2]/div[4]/button")
	private WebElement nextStep;
	
	@FindBy(id="user_to_add")
	private WebElement userAdd;
	
	@FindBy(xpath="//*[@id=\"ajax_list_users_single\"]/a")
	private WebElement selectUser;
	
	// Click on Finish Session
	@FindBy(xpath="//*[@id=\"multiple-add-session\"]/div[2]/div/button")
	private WebElement finishSession;
	
	@FindBy(xpath="//*[@id=\"session-user-list\"]/tbody/tr[2]/td[1]/a")
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
	
	public void clickAddSessionLink() {
		this.addSession.click(); 
    }
	
	public void sendSessionName(String name) {
		this.sessionName.clear();
		this.sessionName.sendKeys(name);
	}
	
	public void coachName() {
		this.coachName.click(); 
		this.coachName1.click();
    }
	
	public void clickSessionSubmit() {
		this.sessionSubmit.click(); 
    }
	
	public void clickCourses(String user) {
		Select courseSelect = new Select(driver.findElement(By.xpath("//*[@id=\"origin\"]")));
        if(courseSelect.isMultiple()) {
        	courseSelect.selectByVisibleText(user);
        }
    }
	
	public void clickButton() {
		this.button.click(); 
    }
	
	public void clickNextStep() {
		this.nextStep.click(); 
    }
	
	public void sendUserAdd(String user) {
		this.userAdd.clear();
		this.userAdd.sendKeys(user);
	}
	
	public void clickSelectUser() {
		this.selectUser.click(); 
    }
	
	public void clickFinishSession() {
		this.finishSession.click(); 
    }
	
	public String Assertion() {
		return this.assert1.getText();
	}
}
