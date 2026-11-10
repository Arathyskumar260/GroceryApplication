package test_script;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constant.Constant;
import grocery_project.GroceryBase;
import pages.Home_Page;
import pages.Login_Page;
import utilities.Excel_Utilities;

public class Login_Test extends GroceryBase{
	Home_Page hp;//reference for home_page
	@Test(priority=1,description="user is trying to login with valid creditionals")
	//priority is used for ordering the execution of testcase in the testNg(least priority)
	//description is a clear explanation of what a testcase is doing
	public void verifyUserloginWithValidCreditionals() throws IOException {
		String user = Excel_Utilities.readStringData(0, 0, "Login_Data");
		String loginpassword = Excel_Utilities.readStringData(0, 1, "Login_Data");
		Login_Page lp = new Login_Page(driver);
		lp.enterUsernameintheUsernameField(user).enterPasswordinthePasswordField(loginpassword);//chaining of pages applied
		
		hp = lp.clickSignInButton();//after signin the page is redirect to home page so here we connecting it with Home_page
		boolean dashboardvalue = lp.verifyWhetherDashboardIsDisplayed();
		Assert.assertTrue(dashboardvalue,Constant.VALIDCREDINTIAL_ERROR);// error message given in the constant class
		
	}
	@Test(priority=2,description="user is trying to login with invalid creditionals",groups="smoke",retryAnalyzer=reTry.ReTry.class)//retryAnalyzer is used for flaky testcase
	public void verifyUserloginWithInvalidCreditionals() throws IOException {
		String user = Excel_Utilities.readStringData(1, 0, "Login_Data");
		String loginpassword = Excel_Utilities.readStringData(1, 1, "Login_Data");
		Login_Page lp = new Login_Page(driver);
		lp.enterUsernameintheUsernameField(user).enterPasswordinthePasswordField(loginpassword).clickSignInButton();//invalid login so it is in the login page itself so connecting sign in with username and password
		String actualResult = lp.verifyWhethertext7artmarketDisplayed();
		String expectedResult = "7rmart supermarket";
		Assert.assertEquals(actualResult, expectedResult, Constant.INVALIDCREDINTIAL_ERROR);
	}
	@Test(priority=3,description="user is trying to login with invalid username")
	public void verifyUserLoginWithInvalidUsername() throws IOException {

		String user = Excel_Utilities.readStringData(2, 0, "Login_Data");
		String loginpassword = Excel_Utilities.readStringData(2, 1, "Login_Data");
		Login_Page lp = new Login_Page(driver);
		lp.enterUsernameintheUsernameField(user).enterPasswordinthePasswordField(loginpassword).clickSignInButton();
		String actualResult = lp.verifyWhethertext7artmarketDisplayed();
		String expectedResult = "7rmart supermarket";
		Assert.assertEquals(actualResult, expectedResult, Constant.INVALIDUSERNAME_ERROR);
	}
	
	@Test(priority=4,description="user is trying to login with invalid password",groups="smoke",dataProvider="logindata")
	public void verifyUserLoginWithInvalidPassword(String user, String loginpassword) throws IOException {

		//String user = Excel_Utilities.readStringData(3, 0, "Login_Data");
	//	String loginpassword = Excel_Utilities.readStringData(3, 1, "Login_Data");
		Login_Page lp = new Login_Page(driver);
		lp.enterUsernameintheUsernameField(user).enterPasswordinthePasswordField(loginpassword).clickSignInButton();
		String actualResult = lp.verifyWhethertext7artmarketDisplayed();
		String expectedResult = "7rmart supermarket";
		Assert.assertEquals(actualResult, expectedResult, Constant.INVALIDPASSWORD_ERROR);
	}

	@DataProvider(name = "logindata")
	public Object[][] getDatafromDataProvider() {// object--return type
		return new Object[][] { new Object[] { "admin", "admin123" }, new Object[] { "admin", "qwerd" } };
	}
}