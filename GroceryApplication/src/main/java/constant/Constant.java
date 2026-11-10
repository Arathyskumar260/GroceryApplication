package constant;

public class Constant {
	public static final String CONFIG_FILE = System.getProperty("user.dir")+"\\src\\main\\resources\\config.properties";
			//to get the local path automatically(//"C:\Users\HP\eclipse-workspace\GroceryApplication)
	public static final String TEST_DATA = System.getProperty("user.dir")+"\\src\\test\\resources\\TestData.xlsx";
	public static final String VALIDCREDINTIAL_ERROR = "User is unable to login with valid creditional";
	public static final String INVALIDCREDINTIAL_ERROR = "User is able to login with invalid creditional";
	public static final String INVALIDUSERNAME_ERROR = "User is able to login with invalid Username";
	public static final String INVALIDPASSWORD_ERROR = "User is able to login with invalid Password";
	
	//Home.test Admin logout error
	public static final String ADMIN_LOGOUT_ERROR = "User is unable to logout";
	
	//Admin.Test - error
	public static final String ADMIN_USERISCREATED_ERROR = "User was not created successfully";
	
	//Deliveryboy - error
	public static final String DELIVERYBOT_NOTCREATED_ERROR = "DeliveryBoy was not created successfully";
	
	//ManagePage - error
	public static final String MANAGEPAGE_NOTCREATED_ERROR = "page was not created successfully";

}






//"C:\Users\HP\eclipse-workspace\GroceryApplication\src\main\resources\config.properties" --config.properties

//"C:\\Users\\HP\\eclipse-workspace\\GroceryApplication\\src\\test\\resources\\TestData.xlsx" --excel