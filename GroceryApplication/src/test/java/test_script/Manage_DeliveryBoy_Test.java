package test_script;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import grocery_project.GroceryBase;
import pages.Admin_Page;
import pages.Home_Page;
import pages.Login_Page;
import pages.Manage_DeliveryBoy_Page;
import utilities.Excel_Utilities;

public class Manage_DeliveryBoy_Test extends GroceryBase{
	@Test(description="user is trying ton add new delivery boy")

	public void verifyWhetherUserIsAbleToAddNewDeliveryBoy()throws IOException {

		String user = Excel_Utilities.readStringData( 0, 0, "Login_Data");
        String loginpassword = Excel_Utilities.readStringData( 0, 1, "Login_Data");
        Login_Page lp = new Login_Page(driver);
		lp.enterUsernameintheUsernameField(user);
		lp.enterPasswordinthePasswordField(loginpassword);
		lp.clickSignInButton();
		
		
		 Home_Page hp = new Home_Page(driver);
	        hp.clickManaemoreinfo();
       
        
        
        String deliveryBoyname = Excel_Utilities.readStringData( 0, 0, "DeliveryBoy_Data");
        String deliveryboyEmail = Excel_Utilities.readStringData(0, 1, "DeliveryBoy_Data");
        String deliveryboyPhone = Excel_Utilities.readStringData(0, 2, "DeliveryBoy_Data");
        String deliveryboyAddress = Excel_Utilities.readStringData(0, 3, "DeliveryBoy_Data");
        String deliveryboyUsername = Excel_Utilities.readStringData(0, 4, "DeliveryBoy_Data");
        String deliveryboyPassword = Excel_Utilities.readStringData(0, 5, "DeliveryBoy_Data");


        
        
        Manage_DeliveryBoy_Page mdp = new Manage_DeliveryBoy_Page(driver);
        mdp.clickNew();
        mdp.enterName(deliveryBoyname);
        mdp.enterEmail(deliveryboyEmail);
        mdp.enterPhone(deliveryboyPhone);
        mdp.enterAddress(deliveryboyAddress);
        mdp.enterUsername(deliveryboyUsername);
        mdp.enterPassword(deliveryboyPassword);
        mdp.clickSave();
        
        boolean deliveryboyCreated = mdp.verifyWhetherDeliveryBoyIsCreated();
        Assert.assertTrue(deliveryboyCreated,Constant.DELIVERYBOT_NOTCREATED_ERROR);
        }
	@Test(description="user is trying to search deliveryboy from the excel")
	public void verifyUserisabletoSearchfromExcel() throws IOException {
		String user = Excel_Utilities.readStringData( 0, 0, "Login_Data");
        String loginpassword = Excel_Utilities.readStringData( 0, 1, "Login_Data");
        Login_Page lp = new Login_Page(driver);
		lp.enterUsernameintheUsernameField(user);
		lp.enterPasswordinthePasswordField(loginpassword);
		lp.clickSignInButton();
		
		
		 Home_Page hp = new Home_Page(driver);
	        hp.clickManaemoreinfo();
	        String deliveryboyEmail = Excel_Utilities.readStringData(0, 1, "DeliveryBoy_Data");

		Manage_DeliveryBoy_Page mdp = new Manage_DeliveryBoy_Page(driver);
        mdp.clickSearch();
       // mdp.enterSearchname(deliveryboyUsername);
        mdp.enterSearchemail(deliveryboyEmail);
        mdp.clickSearch2();
		
	}
}
