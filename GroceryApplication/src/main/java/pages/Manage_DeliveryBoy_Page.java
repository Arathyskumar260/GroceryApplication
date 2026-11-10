package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Manage_DeliveryBoy_Page {
	public WebDriver driver;
	public Manage_DeliveryBoy_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);		
}
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")WebElement newDeliveryBoy;
	@FindBy(id = "name")WebElement name;
	@FindBy(id = "email")WebElement email;
	@FindBy(id = "phone")WebElement phone;
	@FindBy(id = "address")WebElement address;
	@FindBy(id = "username")WebElement username;
	@FindBy(id = "password")WebElement password;
	@FindBy(name="create")WebElement save;
	@FindBy(xpath = "//a[@onclick='click_button(2)']")WebElement search;
	//@FindBy(id = "un")WebElement searchname;
	@FindBy(id = "ut")WebElement searchemail;
	@FindBy(xpath = "//button[contains(normalize-space(), 'Search')]")WebElement search2;
	@FindBy(xpath = "//h5[contains(.,'Alert!')]/parent::div")WebElement deliveryboySuccessMessage;
	public void clickNew() {
		newDeliveryBoy.click();
	}
	public void enterName(String deliveryBoyname) {
		name.sendKeys(deliveryBoyname);
		
	}
	public void enterEmail(String deliveryboyEmail) {
		email.sendKeys(deliveryboyEmail);
	}
	public void enterPhone(String deliveryboyPhone) {
		phone.sendKeys(deliveryboyPhone);
	}
	public void enterAddress(String deliveryboyAddress) {
		address.sendKeys(deliveryboyAddress);
	}
	public void enterUsername(String deliveryboyUsername) {
		username.sendKeys(deliveryboyUsername);
	}
	public void enterPassword(String deliveryboyPassword) {
		password.sendKeys(deliveryboyPassword);
	}
	public void clickSave() {
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)","");
		js.executeScript("arguments[0].click();", save);//executeScript() is used to perform click function. arguments[0].click() is constant syntax
	}
	public void clickSearch() {
		search.click();
		}
	//public void enterSearchname(String deliverysearchByName) {
	//	searchname.sendKeys(deliverysearchByName);
	//}
	public void enterSearchemail(String deliverysearchByEmail) {
		searchemail.sendKeys(deliverysearchByEmail);
	}
	public void clickSearch2() {
		search2.click();
	}
	public boolean verifyWhetherDeliveryBoyIsCreated() {
		return deliveryboySuccessMessage.isDisplayed();
		
	}
}