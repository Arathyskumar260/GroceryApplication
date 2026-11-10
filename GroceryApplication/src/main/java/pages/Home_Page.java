package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page {
	public WebDriver driver;
	public Home_Page(WebDriver driver) {//constructor
		this.driver = driver;//it is used when instance and local variable same , we are using this keyword
		PageFactory.initElements(driver, this);//for second driver we can represent using this keywordS
		
	}
	@FindBy(xpath = "//a[@data-toggle='dropdown']")WebElement admin;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/logout' and @class='dropdown-item']")WebElement logout;
	@FindBy(xpath = "//a[@class='small-box-footer' and contains(@href,'list-admin')]")WebElement adminusers;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")WebElement newuser;
	@FindBy(xpath = "//a[contains(@href,'list-deliveryboy')]")WebElement ManageDeliveryBoyMoreInfo;
	@FindBy(xpath = "//a[@class='small-box-footer' and contains(@href,'list-page')]")WebElement ManagePagesInfo;
	public Home_Page clickAdmin() {
		admin.click();
		return this;
		}
	public Login_Page clickLogOut() {
		logout.click(); 
		return new Login_Page(driver);
	}
	public Admin_Page clickMoreInfo() {
		adminusers.click();	
		return new Admin_Page(driver);
	}
	public void clickNew() {
	newuser.click();
	}
	public Manage_DeliveryBoy_Page clickManaemoreinfo() {
		ManageDeliveryBoyMoreInfo.click();
		return new Manage_DeliveryBoy_Page(driver);
	}
	public ManagePages_page clickManagePagesInfo() {
		ManagePagesInfo.click();
		return new ManagePages_page(driver);
	}

}
