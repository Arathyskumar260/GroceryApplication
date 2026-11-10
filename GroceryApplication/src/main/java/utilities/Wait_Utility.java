package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait_Utility {//class used to apply wait
	public static int EXPLICITWAIT = 5;
	public void waitUntilElementToBeClickable(WebDriver driver, WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAIT ));

		wait.until(ExpectedConditions.elementToBeClickable(element)); 
		}
	public void waitUntilAlertPresent(WebDriver driver, WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAIT ));

		wait.until(ExpectedConditions.alertIsPresent()) ;
		}
	public void waitUntilElementToBeSelected(WebDriver driver, WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAIT ));

		wait.until(ExpectedConditions.elementToBeSelected(element));
		}
	public void waitUntilVisibilityOfAllElements(WebDriver driver, WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAIT ));

		wait.until(ExpectedConditions.visibilityOfAllElements(element) );
		}

}
