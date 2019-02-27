package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCategory {

	private WebDriver driver; 
	
	public CreateCategory(WebDriver driver) {
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
	
	// Navigating to admin link
	@FindBy(xpath="//*[@id=\"menuone\"]/ul[1]/li[7]/a")
	private WebElement adminLink;
	
	// Click on Course  category link
	@FindBy(xpath="//*[@id=\"tabs-2\"]/div/div[2]/div[2]/ul/li[5]/a")
	private WebElement coursesCategoryLink;
	
	//click on Add category link
	@FindBy(xpath="//*[@id=\"content-section\"]/div/div[2]/a/img")
	private WebElement addCategoryLink;
	
	// Add relevant details
	@FindBy(id="course_category_code")
	private WebElement categoryCode;
	
	@FindBy(id="course_category_name")
	private WebElement categoryName;
	
	@FindBy(xpath="//*[@id=\"course_category\"]/fieldset/div[3]/div[1]/div[1]/label")
	private WebElement yesRadio;
	
	@FindBy(id="course_category_submit")
	private WebElement categorySubmit;
	
	// click on create course link
	@FindBy(xpath="//*[@id=\"tabs-2\"]/div/div[2]/div[2]/ul/li[2]/a")
	private WebElement createCourseLink;
	
	@FindBy(id="update_course_title")
	private WebElement courseTitle;
	
	@FindBy(id="visual_code")
	private WebElement code;
	
	@FindBy(xpath="//*[@id=\"update_course\"]/fieldset/div[3]/div[1]/div/button/span[1]")
	private WebElement teacher;
	
	@FindBy(xpath="//*[@id=\"update_course\"]/fieldset/div[3]/div[1]/div/div/ul/li[1]/a/span[1]")
	private WebElement teacherName;
	
	@FindBy(xpath="//*[@id=\"update_course\"]/fieldset/div[4]/div[1]/div/button/span[1]")
	private WebElement category;
	
	@FindBy(xpath="//*[@id=\"update_course\"]/fieldset/div[4]/div[1]/div/div/ul/li[19]/a")
	private WebElement categoryName1;
	
	@FindBy(xpath="//*[@id=\"update_course\"]/fieldset/div[7]/div[1]/div/button/span[1]")
	private WebElement language;
	
	@FindBy(xpath="//*[@id=\"update_course\"]/fieldset/div[7]/div[1]/div/div/ul/li[6]/a/span[1]")
	private WebElement languageSelection;
	
	// Click on Submit
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
	
	public void clickCoursesCategoryLink() {
		this.coursesCategoryLink.click(); 
    }
	
	public void clickAddCategoryLink() {
		this.addCategoryLink.click(); 
    }
	
	public void sendCategoryCode(String code) {
		this.categoryCode.clear();
		this.categoryCode.sendKeys(code);
	}
	
	public void sendCategoryName(String name) {
		this.categoryName.clear();
		this.categoryName.sendKeys(name);
	}
	
	public void clickYesRadio() {
		this.yesRadio.click(); 
    }
	
	public void clickCategorySubmit() {
		this.categorySubmit.click(); 
    }
	
	public void clickCreateCourseLink() {
		this.createCourseLink.click(); 
    }
	
	public void sendCourseTitle(String title) {
		this.courseTitle.clear();
		this.courseTitle.sendKeys(title);
	}
	
	public void sendCode(String code) {
		this.code.clear();
		this.code.sendKeys(code);
	}
	
	public void clickTeacherDrpDown() {
		this.teacher.click(); 
		this.teacherName.click();
    }
	
	public void clickCategoryDrpDown() {
		this.category.click(); 
		this.categoryName1.click();
    }
	
	public void clickLanguageDrpDown() {
		this.language.click(); 
		this.languageSelection.click();
    }
	
	public void clickSubmitLink() {
		this.submit.click(); 
    }
}
