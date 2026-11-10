package test_script;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import grocery_project.GroceryBase;
import pages.Home_Page;
import pages.Login_Page;
import utilities.Excel_Utilities;

public class Home_Test extends GroceryBase{
	Home_Page hp ;
	
	@Test(description="user is trying for successful logout")
	public void verifyWhetherUserSuccessfullyLoggedout() throws IOException {//add login details for logout the website
		String user = Excel_Utilities.readStringData(0, 0, "Login_Data");
		String loginpassword = Excel_Utilities.readStringData(0, 1, "Login_Data");
		Login_Page lp = new Login_Page(driver);
		lp.enterUsernameintheUsernameField(user).enterPasswordinthePasswordField(loginpassword);
		hp = lp.clickSignInButton();
		//Home_Page hp = new Home_page(driver);
		hp.clickAdmin();
		lp = hp.clickLogOut();
		String actualResult = lp.verifyWhethertext7artmarketDisplayed();
		String expectedResult = "7rmart supermarket";
		Assert.assertEquals(actualResult, expectedResult, Constant.ADMIN_LOGOUT_ERROR);
	}
}	
