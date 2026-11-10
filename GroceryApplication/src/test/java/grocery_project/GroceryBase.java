package grocery_project;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constant.Constant;
import utilities.Screenshot_Utility;

public class GroceryBase {
	public WebDriver driver;
	Properties prop; // predefined class to read url from the property file
	FileInputStream fis;// predefined class to read url from the property file
	@BeforeMethod(alwaysRun=true)

	//after adding groups in the test class extends will not work, so we are using alwaysRun=true for always run the program
	//annotation -- for browser launch
	@Parameters("browsers")
	public void intializeBrowser(String browsers) throws IOException
	{
		prop = new Properties();//object creation of predefined classes
		fis = new FileInputStream(Constant.CONFIG_FILE);//path of the url/file
		prop.load(fis);//to load file, we are using "load" method of predefined class(properties)
		if(browsers.equalsIgnoreCase("chrome"))//equalsIgnoreCase using for avoid case sensitive issue
		{
		driver = new ChromeDriver();
		}
		else if(browsers.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		
		}
		else if(browsers.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
		//driver = new FirefoxDriver();
		driver.get(prop.getProperty("url"));//to get url from the config.properties class
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//to apply implicit wait, we are using "implicitlyWait" method --here set implicit wait for 5 seconds
	}
	@AfterMethod
	//annotation -- 
	public void closeBrowser(ITestResult itestresult) throws IOException{//ITestresult is a interface --used to maintain lifecycle of a testcase--if a testcase is paas or fail or skip
		if(itestresult.getStatus()==ITestResult.FAILURE) {//if the the result fromITestResult is fail only the screenshot will take
			Screenshot_Utility screenshotutility=new Screenshot_Utility();
			screenshotutility.getScreenshot(driver, itestresult.getName());//to get the name of testcase failed
		}
		 // driver.close();
		//driver.quit();
	}
}



