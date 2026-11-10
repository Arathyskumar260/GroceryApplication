package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Wait_Utility;

public class Login_Page {
	public WebDriver driver;
	Wait_Utility wu = new Wait_Utility();
	public Login_Page(WebDriver driver) {//constructor
		this.driver = driver;//it is used when instance and local variable same , we are using this keyword
		PageFactory.initElements(driver, this);//for second driver we can represent using this keywordS
		
	}
	@FindBy(xpath = "//input[@name='username']")WebElement username;
	@FindBy(xpath = "//input[@name='password']")WebElement password;
	@FindBy(xpath = "//button[@type='submit']")WebElement signIn;
	@FindBy(linkText ="Dashboard")WebElement dashboard;
	@FindBy(xpath = "//b[text()='7rmart supermarket']")WebElement text7arts;
	public Login_Page enterUsernameintheUsernameField(String user) {//not give the parameter name same as inthe webelement name 
		//instead of void, using Login_page(chaining of pages concept
		username.sendKeys(user);//through method only we can perform actions
		return this;// this is used to after clicking username it is in same page, so we are using this keyword
	}
	public Login_Page enterPasswordinthePasswordField(String loginpassword) {
		password.sendKeys(loginpassword);
		return this;
	}
	public Home_Page clickSignInButton() {
		//here we are giving because after clicking signin it is redirecting to the home page so instead of void we are using Home_page
		wu.waitUntilElementToBeClickable(driver, signIn);//wait apply for sign in button
		signIn.click();
		return new Home_Page(driver) ;//new keyword is used, it is redirecting a new page from login page
	}
	public boolean verifyWhetherDashboardIsDisplayed() {
		return dashboard.isDisplayed();
	}
	public String verifyWhethertext7artmarketDisplayed() {
		return text7arts.getText();
	}

}
