package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.Page_Utility;

public class Admin_Page {
	public WebDriver driver;
	Page_Utility pu = new Page_Utility();
	public Admin_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath = "//a[@onclick='click_button(1)']")WebElement newuser;
	@FindBy(id = "username")WebElement username;
	@FindBy(id = "password")WebElement password;
	@FindBy(id = "user_type")WebElement userType;
	@FindBy(xpath = "//button[@name='Create']")WebElement save;
	@FindBy(xpath = "//a[text()=' Search']")WebElement search;
	@FindBy(id = "un")WebElement searchusername;
	@FindBy(id = "ut")WebElement searchusertype;
	@FindBy(xpath = "//button[@name='Search']")WebElement search2;
	@FindBy(xpath = "//h5[text()=' Alert!']")WebElement successMessage;

	public void clickNew() {
			newuser.click();
		}
	public void enterUsernameintheUsernameField(String user) {//not give the parameter name same as inthe webelement name 
		username.sendKeys(user);//through method only we can perform actions
	}
	public void enterPasswordinthePasswordField(String passworduser) {
		password.sendKeys(passworduser);
	}
	public void selectUserType() {
		pu.selectDragDropWithVisibileText(userType, "Admin");//for select value from dropdown(using page utility class
		
		//Select s = new Select(userType);
        //s.selectByVisibleText("Admin");
	}
	public void clickSave() {
		save.click();
	}
	public void clickSearch() {
		search.click();
	}
	public void enterSearchUsername(String searchUser) {
        searchusername.sendKeys(searchUser);
    }

    public void selectSearchUserType() {
    	pu.selectDragDropWithVisibileText(searchusertype, "Admin");//select value from the dropdown using page utility class
        //Select s = new Select(searchusertype);
      //  s.selectByVisibleText("Admin");
    }
    public void clickSearch2() {
    	search2.click();
    }
    public boolean verifyWhetherUserIsCreated() {
	    return successMessage.isDisplayed();
	}

 

    
}