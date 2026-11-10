
package test_script;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import grocery_project.GroceryBase;
import pages.Admin_Page;
import pages.Home_Page;
import pages.Login_Page;
import utilities.Excel_Utilities;
import utilities.Random_Data_Utility;

public class Admin_Test extends GroceryBase {

    @Test(description="user trying to add new admin user")
    public void verifyWhetherUserIsAbleToAddNewUsers()throws IOException {

        String user = Excel_Utilities.readStringData( 0, 0, "Login_Data");
        String loginpassword = Excel_Utilities.readStringData( 0, 1, "Login_Data");
        //String user1 = Excel_Utilities.readStringData( 0, 0, "Admin_Data");
       // String password = Excel_Utilities.readStringData(0, 1, "Admin_Data");
        Random_Data_Utility radu = new Random_Data_Utility();
        String user1 = radu.genrateRandomUsername();//random data genreating using random data utility class
        String password = radu.genrateRandomPassword();
        

        Login_Page lp = new Login_Page(driver);
        lp.enterUsernameintheUsernameField(user);
        lp.enterPasswordinthePasswordField(loginpassword);
        lp.clickSignInButton();

        Home_Page hp = new Home_Page(driver);
        hp.clickMoreInfo();

        Admin_Page ap = new Admin_Page(driver);
        ap.clickNew();
        ap.enterUsernameintheUsernameField(user1);
        ap.enterPasswordinthePasswordField(password);
        ap.selectUserType();
        ap.clickSave();
        boolean userCreated = ap.verifyWhetherUserIsCreated();
        Assert.assertTrue(userCreated,Constant.ADMIN_USERISCREATED_ERROR);
    }

    @Test(description="user is trying to search newly added admin user")
    public void verifyWhetherUserIsAbledToSearchNewlyAddedAdminUser()throws IOException {
    	String user = Excel_Utilities.readStringData( 0, 0, "Login_Data");

        String loginpassword = Excel_Utilities.readStringData( 0, 1, "Login_Data");

        String user1 = Excel_Utilities.readStringData(0, 0, "Admin_Data");
        Login_Page lp = new Login_Page(driver);
        lp.enterUsernameintheUsernameField(user);
        lp.enterPasswordinthePasswordField(loginpassword);
        lp.clickSignInButton();

        Home_Page hp = new Home_Page(driver);
        hp.clickMoreInfo();

        Admin_Page ap = new Admin_Page(driver);
        ap.clickSearch();
        ap.enterSearchUsername(user1);
        ap.selectSearchUserType();
        ap.clickSearch2();
        
    }
}
