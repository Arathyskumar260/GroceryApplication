package test_script;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import grocery_project.GroceryBase;
import pages.Home_Page;
import pages.Login_Page;
import pages.ManagePages_page;
import pages.Manage_DeliveryBoy_Page;
import utilities.Excel_Utilities;

public class ManagePages_Test extends GroceryBase{
	@Test(description="user is trying ton add new delivery boy")

	public void verifyWhetherUserIsAbleToAddNewPage()throws IOException {

		String user = Excel_Utilities.readStringData( 0, 0, "Login_Data");
        String loginpassword = Excel_Utilities.readStringData( 0, 1, "Login_Data");
        Login_Page lp = new Login_Page(driver);
		lp.enterUsernameintheUsernameField(user);
		lp.enterPasswordinthePasswordField(loginpassword);
		lp.clickSignInButton();
		
		
		 Home_Page hp = new Home_Page(driver);
	        hp.clickManagePagesInfo();
	        
	        
	        
	        String titleName = Excel_Utilities.readStringData( 0, 0, "Page_Data");
	        String newPagename = Excel_Utilities.readStringData(0, 1, "Page_Data");  
	        
	        
	        ManagePages_page mp = new ManagePages_page(driver);
	        mp.clickNewPage();
	        mp.enterTitle(titleName);
	        mp.enterPageName(newPagename);
	        mp.clickSave();
	        
	        boolean pageCreated = mp.verifyWhetherUserIsIsCreated();
	        Assert.assertTrue(pageCreated,Constant.MANAGEPAGE_NOTCREATED_ERROR);
	     

}
	@Test
	public void verifyWhetherUserisAbletoSearchPagesbyExcel()throws IOException {
		String user = Excel_Utilities.readStringData( 0, 0, "Login_Data");
        String loginpassword = Excel_Utilities.readStringData( 0, 1, "Login_Data");
        Login_Page lp = new Login_Page(driver);
		lp.enterUsernameintheUsernameField(user);
		lp.enterPasswordinthePasswordField(loginpassword);
		lp.clickSignInButton();
		
		
		 Home_Page hp = new Home_Page(driver);
	        hp.clickManagePagesInfo();
	          
	        String titleName = Excel_Utilities.readStringData(0, 0, "Page_Data");
	        
	        ManagePages_page mp = new ManagePages_page(driver);
	        mp.clickSearchpage();
	        mp.enterTitleforSearch(titleName);
	        mp.clickSearchButton();
	        
	}
}

