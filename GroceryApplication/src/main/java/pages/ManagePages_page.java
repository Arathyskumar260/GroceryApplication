package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManagePages_page {
	public WebDriver driver;
	public ManagePages_page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);		
}	
	@FindBy(xpath = "//a[@onclick='click_button(1)']")WebElement newPage;
	@FindBy(id = "title")WebElement pageTitle;
	@FindBy(id = "page")WebElement pageName;
	@FindBy(xpath = "//button[@name='create']")WebElement clickSave;
	@FindBy(xpath = "//a[@onclick='click_button(2)']")WebElement clickSearch;
	@FindBy(xpath = "//input[@name='un']")WebElement searchbyTitle;
	@FindBy(xpath = "//button[@name='Search']")WebElement SearchButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")WebElement pageSuccessfulMessage;
	public void clickNewPage() {
		newPage.click();
	}
	public void enterTitle(String titleName) {
		pageTitle.sendKeys(titleName);
		
	}
	public void enterPageName(String newPagename) {
		pageName.sendKeys(newPagename);
	}
	public void clickSave() {
		clickSave.click();
	}
	public void clickSearchpage() {
		clickSearch.click();
		
	}
	public void enterTitleforSearch(String enterTitle) {
		searchbyTitle.sendKeys(enterTitle);
	}
	public void clickSearchButton() {
		SearchButton.click();
	}
	public boolean verifyWhetherUserIsIsCreated() {
		return pageSuccessfulMessage.isDisplayed();
		
	}

}
