package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminAddClass {

private WebDriver driver; 
	
	public AdminAddClass(WebDriver driver) {
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
	
	//Navigating to Admin page
	@FindBy(xpath="//*[@id=\"menuone\"]/ul[1]/li[7]/a")
	private WebElement adminLink;
	
	//Click on classes link
	@FindBy(xpath="//*[@id=\"tabs-1\"]/div/div[2]/div[2]/ul/li[7]/a")
	private WebElement classes;
	
	//click on Add Classes
	@FindBy(xpath="//*[@id=\"content-section\"]/div/div[2]/a[2]/img")
	private WebElement addClasses;
	
	//Enter the details on the page
	@FindBy(id="usergroup_name")
	private WebElement className;
	
	@FindBy(id="usergroup_description")
	private WebElement description;
	
	@FindBy(xpath="//*[@id=\"usergroup\"]/fieldset/div[6]/div[1]/div/button/span[1]")
	private WebElement group;
	
	@FindBy(xpath="//*[@id=\"usergroup\"]/fieldset/div[6]/div[1]/div/div/ul/li[1]/a")
	private WebElement open;
	
	// Click on Submit
	@FindBy(id="usergroup_submit")
	private WebElement submit;
	
	//Click on Subscribe user for the class registered
	@FindBy(xpath="//table//tbody//tr//td[@title='class4']//following-sibling::td//a//img[@title='Subscribe users to class']")
	private WebElement subscribeUser;
	
	@FindBy(xpath="//*[@id=\"content-section\"]/div/form/div/div[2]/div/button[1]")
	private WebElement arrow;
	
	@FindBy(xpath="//*[@id=\"content-section\"]/div/form/button")
	private WebElement subscribeUserToClass;
	
	//Click on Subscribe course for the class registered
	@FindBy(xpath="//table//tbody//tr//td[@title='class4']//following-sibling::td//a//img[@title='Subscribe class to courses']")
	private WebElement subscribeCourse;
	
	@FindBy(xpath="//*[@id=\"content-section\"]/div/form/table/tbody/tr[3]/td[2]/button[1]")
	private WebElement arrow1;
	
	@FindBy(xpath="//*[@id=\"content-section\"]/div/form/table/tbody/tr[4]/td/button")
	private WebElement subscribeClassToCourses;
	
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
	
	public void clickClassesLink() {
		this.classes.click(); 
    }
	
	public void clickAddClassesLink() {
		this.addClasses.click(); 
    }
	
	public void sendClassName(String name) {
		this.className.clear(); 
		this.className.sendKeys(name); 
	}
	
	public void sendClassDescription(String desc) {
		this.description.clear(); 
		this.description.sendKeys(desc); 
	}
	
	public void clickGroupPermissions() {
		this.group.click();
		this.open.click();
    }
	
	public void clickSubmit() {
		this.submit.click();
    }
	
	public void clickSubscribeUser() {
		this.subscribeUser.click();
    }
	
	public void clickUsers(String user) {
		Select userSelect = new Select(driver.findElement(By.xpath("//*[@id=\"elements_not_in\"]")));
        if(userSelect.isMultiple()) {
        	userSelect.selectByVisibleText(user);
        }
    }
	
	public void clickArrowButton() {
		this.arrow.click();
    }
	
	public void clickSubscribeUserToClass() {
		this.subscribeUserToClass.click();
    }
	
	public void clickSubscribeCourse() {
		this.subscribeCourse.click();
    }
	
	public void clickCourses(String course) {
		Select userSelect = new Select(driver.findElement(By.xpath("//*[@id=\"elements_not_in\"]")));
        if(userSelect.isMultiple()) {
        	userSelect.selectByVisibleText(course);
        }
    }
	
	public void clickArrowButton1() {
		this.arrow1.click();
    }
	
	public void clickSubscribeClassToCourses() {
		this.subscribeClassToCourses.click();
    }
}
