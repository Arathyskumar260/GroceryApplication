package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot_Utility {
	public void getScreenshot(WebDriver driver, String failedTestCase) throws IOException {//parameterized method --we passed a driver and a variable is passed to store failed testcase method

		TakesScreenshot scrShot = (TakesScreenshot) driver;//predefined interface used to shot screenshot(casting --to get control of driver in the method)
		File screenShot = scrShot.getScreenshotAs(OutputType.FILE);//to store temporary

		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());//to take screenshot time

		File f1 = new File(System.getProperty("user.dir") + "//OutputScreenShot");//system.getproperty --to get the project"s local path and create a folder as outputscreenshot---- create file in directory
		if (!f1.exists()) {

		f1.mkdirs();
		}
		String destination = System.getProperty("user.dir") + "//outputScreenShot//" + failedTestCase + timeStamp
		+ ".png";
		// String destination = f1.getPath() + "//" + failedTestCase + timeStamp +
		// ".png";

		File finalDestination = new File(destination);//create a file as filedestination store in the destination
		FileHandler.copy(screenShot, finalDestination);//temporary stored screenshot is copied to the finalDestination
		}

}
