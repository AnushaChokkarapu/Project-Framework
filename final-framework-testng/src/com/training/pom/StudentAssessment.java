package com.training.pom;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StudentAssessment {

	private WebDriver driver; 
	
	public StudentAssessment(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	//UserName
	@FindBy(id="login")
	private WebElement userName; 
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	// Password
	@FindBy(id="password")
	private WebElement password;
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	// Login Button
	@FindBy(id="formLogin_submitAuth")
	private WebElement loginBtn; 
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
	//Click Course
	@FindBy(xpath="//a[contains(text(),'selenium_test_1')]")
	private WebElement clickCourse;
	
	public void clickCourse() {
		this.clickCourse.click(); 
	}
	
	// Click on Assessments
	@FindBy(id="toolimage_6641")
	private WebElement assessment;
	
	public void clickAssessment() {
		this.assessment.click(); 
	}
	
	// Click on Add Online Activity
	@FindBy(xpath="//img[@title='Add online activity']")
	private WebElement addOnlineActivity;
		
	public void clickAddOnlineActivity() {
		this.addOnlineActivity.click(); 
	}
	
	// Choose type of activity to assess drop down
	@FindBy(xpath="//span[@class='filter-option pull-left']")
	private WebElement activity;
	
	@FindBy(xpath="//span[contains(text(),'Tests')]")
	private WebElement tests;
		
	public void clickActivity() {
		this.activity.click(); 
		this.tests.click();
	}
	
	// Enter Course name
	@FindBy(id="weight_mask")
	private WebElement weight;
		
	public void sendWeight(String weight) {
		this.weight.clear(); 
		this.weight.sendKeys(weight); 
	}
	
	// Click on Add this learning activity
	@FindBy(id="add_link_submit")
	private WebElement addLearning;
		
	public void clickAddLearning() {
		this.addLearning.click(); 
	}
	
	// Click on Edit
	@FindBy(xpath="//*[@id=\"gradebook_list\"]/tbody/tr[2]/td[6]/a[1]/img")
	private WebElement edit;
		
	public void clickEdit() {
		this.edit.click(); 
	}
	
	// Click on Edit Link
	@FindBy(id="edit_link_form_submit")
	private WebElement editLink;
			
	public void clickEditLink() {
		this.editLink.click(); 
	}
	
	// Attach certificate
	@FindBy(xpath="//img[@title='Attach certificate']")
	private WebElement attachCertificate;
			
	public void clickAttachCertificate() {
		this.attachCertificate.click(); 
	}
	
	// User clicks on the drop down
	@FindBy(xpath="//a[@class='dropdown-toggle']")
	private WebElement drpDown;
			
	// Click on logout
	@FindBy(xpath="//a[@id='logout_button']")
	private WebElement logout;
			
	public void clickDrpDown() {
		this.drpDown.click(); 
		this.logout.click(); 
	}
	
	// Click Course catalog
	@FindBy(xpath="//a[@href='main/auth/courses.php']")
	private WebElement courseCatalog;
			
	public void clickCourseCatalog() {
		this.courseCatalog.click(); 
	}
	
	// Enter the course name
	@FindBy(xpath="//input[@name='search_term']")
	private WebElement course;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement search;
		
	public void sendCourseName(String name) {
		this.course.clear(); 
		this.course.sendKeys(name); 
	}
	
	public void clickSearch() {
		this.search.click(); 
	}
	
	// Subscribe the course
	@FindBy(xpath="//*[@id=\"content-section\"]/div/div[2]/div[2]/div/div/div/div[2]/div[4]/div[2]/div/a")
	private WebElement subscribe;
			
	public void clickSubscribe() {
		this.subscribe.click(); 
	}
	
	// Click on course
	@FindBy(xpath="//*[@id=\"content-section\"]/div/div[2]/a")
	private WebElement courseClick;
			
	public void clickCourseName() {
		this.courseClick.click(); 
	}
	
	// Click on Assessment link
	@FindBy(id="toolimage_6641")
	private WebElement assessment1;
	
	public void clickAssessment1() {
		this.assessment1.click(); 
	}
	
	// Click on test name
	@FindBy(xpath="//*[@id=\"gradebook_list\"]/tbody/tr[2]/td[2]/a")
	private WebElement testName;
	
	public void clickTestName() {
		this.testName.click(); 
	}
	
	// Click on Start Test
	@FindBy(xpath="//*[@id=\"content-section\"]/div/div[2]/div[1]/div/a")
	private WebElement startTest;
	
	public void clickStartTest() {
		this.startTest.click(); 
	}
	
	// Select the answer
	@FindBy(xpath="//*[@id=\"question_div_215\"]/div[2]/label[1]/p")
	private WebElement answer;
	
	public void clickAnswer() {
		this.answer.click(); 
	}
	
	@FindBy(xpath="//*[@id=\"question_div_215\"]/div[3]/button")
	private WebElement endTest;
	
	public void clickEndTest() {
		this.endTest.click(); 
	}
	
	@FindBy(xpath="//img[@title='Assessment history']")
	private WebElement assessmentHistory;
	
	public void clickAssessmentHistory() {
		this.assessmentHistory.click(); 
	}
	
	@FindBy(xpath="//h3[contains(text(),'Assessment history')]")
	private WebElement assert1;
	
	public String Assertion() {
		return this.assert1.getText();
	}
}
