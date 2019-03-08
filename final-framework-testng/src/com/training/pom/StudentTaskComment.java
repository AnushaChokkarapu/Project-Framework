package com.training.pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StudentTaskComment {

	private WebDriver driver; 
	
	public StudentTaskComment(WebDriver driver) {
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
	
	// click on the course
	@FindBy(xpath="//*[@id=\"page\"]/div[4]/div[4]/div/div/div[2]/h4/a")
	private WebElement course;	
	
	//click on project
	@FindBy(xpath="//*[@id=\"toolimage_5255\"]")
	private WebElement project;
	
	// click on the task assigned
	@FindBy(xpath="//*[@id=\"task-blog\"]/div[2]/ul/li/a")
	private WebElement myTask;
	
	// click on Home Icon
	@FindBy(xpath="//*[@id=\"toolbar\"]/div/div/a[1]/img")
	private WebElement homeIcon;
	
	// Click on the Task Name
	@FindBy(xpath="//*[@id=\"post-84\"]/div/div/h3/a")
	private WebElement taskName;
	
	// Enter the title
	@FindBy(id="add_post_title")
	private WebElement title;
	
	// Enter comment description
	@FindBy(xpath="/html/body/p")
	private WebElement comment;
	
	//click on Save 
	@FindBy(id="add_post_save")
	private WebElement save;
	
	@FindBy(xpath="//*[@id=\"content-section\"]/div/div[2]/div/div[2]")
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
	
	public void clickCourseLink() {
		this.course.click(); 
	}
	
	public void clickProjectLink() {
		this.project.click(); 
	}
	
	public void clickMyTaskLink() {
		this.myTask.click(); 
	}
	
	public void clickHomeIcon() {
		this.homeIcon.click(); 
	}
	
	public void clickTaskNameLink() {
		this.taskName.click(); 
	}
	
	public void sendTitle(String title) throws InterruptedException {
		this.title.clear();
		this.title.sendKeys(title);
		Thread.sleep(7000);
		Actions act = new Actions(driver);
		act.sendKeys(Keys.TAB).perform();
		Thread.sleep(5000);
		act.sendKeys("test5");
		act.sendKeys(Keys.ENTER).perform();
	}
	
	public void sendComment(String comment) {
		this.comment.clear();
		this.comment.sendKeys(comment);
	}
	
	public void clickSave() {
		this.save.click(); 
	}
	
	public String Assertion()
	{
		return this.assert1.getText();
	}
}
